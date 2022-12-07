package com.example.jewelchase230;

import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.items.Bomb;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.DoubleVector2D;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * A tile is one square on the grid that can have a different colour for
 * each side.
 */
public final class Tile extends Renderable implements Collidable {
    /** The width of the border around the tile. */
    private static final double BORDER_WIDTH = 0.04;

    /** Top left side of tile. */
    private final TileColour topLeft;
    /** Bottom left side of tile. */
    private final TileColour bottomLeft;
    /** Top right side of tile. */
    private final TileColour topRight;
    /** Bottom right side of tile. */
    private final TileColour bottomRight;
    /** List of all nearby bombs. */
    private ArrayList<IntVector2D> bombsNextToTile = new ArrayList<>();

    /**
     * Item currently on this tile.
     * null when no item is on this tile.
     */
    private Item item;

    /**
     * Constructs a new tile.
     * @param inTopLeft Top left colour
     * @param inTopRight Top right colour
     * @param inBottomLeft Bottom left colour
     * @param inBottomRight Bottom right colour
     */
    public Tile(final TileColour inTopLeft,
                final TileColour inTopRight,
                final TileColour inBottomLeft,
                final TileColour inBottomRight) {
        super();
        topLeft = inTopLeft;
        topRight = inTopRight;
        bottomLeft = inBottomLeft;
        bottomRight = inBottomRight;
    }

    /**
     * Checks if there is a bomb on a neighbouring tile.
     * @return True if there's a bomb near, false if not.
     */
    public boolean isNextToBomb() {
        return bombsNextToTile.size() > 0;
    }

    @Override
    public void onCollision(final Character movingCharacter) {
        if (movingCharacter.canInteractWithItems()) {
            if (isNextToBomb()) {
                triggerAllNearbyBombs(movingCharacter);
            }

            if (item != null) {
                item.onCollision(movingCharacter);
            }
        }
    }

    @Override
    public boolean isCollidable() {
        if (item != null) {
            return item.isCollidable();
        }

        return true;
    }

    /**
     * Triggers all bombs next to this tile to explode.
     * @param character The character causing the explosion.
     */
    private void triggerAllNearbyBombs(final Character character) {
        ArrayList<Bomb> bombs = getBombs();
        for (Bomb bomb : bombs) {
            bomb.onCollision(character);
        }
    }

    /**
     * Get a list of all nearby bombs.
     * @return ArrayList of bombs.
     */
    private ArrayList<Bomb> getBombs() {
        ArrayList<Bomb> itemArray = new ArrayList<>();
        for (IntVector2D vectorInstance : bombsNextToTile) {
            itemArray.add((Bomb) getLevel().getItem(vectorInstance));
        }
        return itemArray;
    }

    /**
     * Add a bomb trigger to this tile.
     * @param bombPos Bomb position.
     */
    public void setBombTrigger(IntVector2D bombPos) {
        bombsNextToTile.add(bombPos);
    }

    /**
     * Remove a bomb.
     * @param bombPos The bomb's position.
     */
    public void removeBombTrigger(IntVector2D bombPos) {
        bombsNextToTile.remove(bombPos);
    }

    /**
     * @return The item on this tile or null if there isn't one.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Adds an item to this tile.
     * @param inItem Item on this tile.
     */
    public void setItem(final Item inItem) {
        item = inItem;
    }

    /**
     * Gets all the colours contained in this tile.
     * @return Array of tile colours.
     */
    public ArrayList<TileColour> getTileColours() {
        ArrayList<TileColour> coloursArray = new ArrayList<>();
        coloursArray.add(getTopLeft());
        coloursArray.add(getTopRight());
        coloursArray.add(getBottomLeft());
        coloursArray.add(getBottomRight());
        return coloursArray;
    }

    /**
     * @return Top left part of the tile.
     */
    public TileColour getTopLeft() {
        return topLeft;
    }

    /**
     * @return Top right part of tile.
     */
    public TileColour getTopRight() {
        return topRight;
    }

    /**
     * @return Bottom left part of tile.
     */
    public TileColour getBottomLeft() {
        return bottomLeft;
    }

    /**
     * @return Bottom right part of tile.
     */
    public TileColour getBottomRight() {
        return bottomRight;
    }

    /**
     * Draws the tile with all four sections.
     */
    @Override
    public void draw(final GraphicsContext gc) {
        DoubleVector2D pos = getRenderPosition();
        double cubeSize = getCubeSize();
        double halfSize = cubeSize / 2;

        gc.drawImage(
                topLeft.getImage(), pos.getX(), pos.getY(), halfSize, halfSize);
        gc.drawImage(
                topRight.getImage(), pos.getX() + halfSize, pos.getY(),
                halfSize, halfSize);
        gc.drawImage(bottomLeft.getImage(), pos.getX(), pos.getY() + halfSize,
                halfSize, halfSize);
        gc.drawImage(bottomRight.getImage(), pos.getX() + halfSize,
                pos.getY() + halfSize, halfSize, halfSize);

        gc.setLineWidth(halfSize * BORDER_WIDTH);
        gc.strokeRect(pos.getX(), pos.getY(), cubeSize, cubeSize);
    }
}
