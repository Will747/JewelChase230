package com.example.jewelchase230.characters;
import com.example.jewelchase230.Collidable;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.Sprite;
import com.example.jewelchase230.Tile;
import com.example.jewelchase230.TileColour;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

/**
 * Renders the characters to the game.
 *
 * @author Caroline Segestaaland and Ben Stott.
 */
public abstract class Character extends Sprite implements Collidable {
    /** True if the character is alive. */
    private boolean alive = true;
    /** Bones image. */
    private static final String BONES_IMAGE = "images/BONES.png";
    /**
     * Constructs a renderable component.
     */
    public Character() {
        super();
    }

    /**
     * Checks that the next move is a valid move, if valid, collides
     * with items as expected.
     * @param nextMoveTile The tile to be moved to.
     * @return True if valid move, false if not.
     */
    private boolean validNextTile(final Tile nextMoveTile) {
        return validNextTile(nextMoveTile, null);
    }

    /**
     * Checks that the next move is a valid move, if valid, collides
     * with items as expected.
     * @param nextMoveTile The tile to be moved to.
     * @param colourFollow The specific colour the next tile must be.
     * @return True if valid move, false if not.
     */
    private boolean validNextTile(final Tile nextMoveTile,
                                  final TileColour colourFollow) {
        Tile thisTile = getLevel().getTile(getGridPosition());

        // Check if the tile/item can be collided with.
        if (!nextMoveTile.isCollidable()) {
            return false;
        }

        ArrayList<TileColour> thisTileColours = new ArrayList<>();
        ArrayList<TileColour> nextTileColours = nextMoveTile.getTileColours();
        // Select the applicable colours that can be moved to.
        if (colourFollow == null) {
            thisTileColours = thisTile.getTileColours();
        } else {
            thisTileColours.add(colourFollow);
        }

        // Check if the next tile has any matching colours with the current.
        for (int i = 0; i < thisTileColours.size(); i++) {
            for (int j = 0; j < nextTileColours.size(); j++) {
                if (thisTileColours.get(i) == nextTileColours.get(j)) {
                    return canCharactersCollide(
                            nextMoveTile.getGridPosition());
                }
            }
        }
        return false;
    }

    /**
     * Checks if a character can move to a new tile.
     * @param xChange Positive for moving right, negative for moving left.
     * @param yChange Positive for moving down, negative for moving up.
     * @return new tile position, or current position if invalid move.
     */
    protected IntVector2D canMove(final int xChange, final int yChange) {
        IntVector2D currentPos = getGridPosition();
        int xDiff = 0;
        int yDiff = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            xDiff += xChange;
            yDiff += yChange;
            IntVector2D newPos =
                    currentPos.add(new IntVector2D(xDiff, yDiff));
            //Check the newPos is a valid tile
            if (getLevel().checkValidTile(newPos)) {
                Tile nextMoveTile = getLevel().getTile(newPos);
                //Makes sure the new tile has matching colours
                if (validNextTile(nextMoveTile)) {
                    return newPos;
                }
            } else {
                stillInRange = false;
            }
        }
        return getGridPosition();
    }

    /**
     * @return True if the character is still alive.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Kills a character.
     */
    public void kill() {
        alive = false;
        setImageFromFile(BONES_IMAGE);
    }

    /**
     * Decides if a character on specific tile can be collied with.
     * @param nextTilePosition The position of the tile.
     * @return True if the player can move, false if not.
     */
    protected boolean canCharactersCollide(final IntVector2D nextTilePosition) {
        Character collidingCharacter =
                getLevel().getSpecificCharacter(nextTilePosition);

        if (collidingCharacter != null) {
            return collidingCharacter.isCollidable() || canKill();
        }

        return true;
    }

    /**
     * Weather the character is able to affect items such as
     * pick up loot.
     * @return True if the player can collect/interact with items.
     */
    public boolean canInteractWithItems() {
        return true;
    }

    /**
     * Weather this character can kill other characters when moving
     * around the grid even if the character cannot be collided with.
     * @return True if this character kills others.
     */
    public boolean canKill() {
        return false;
    }

    /**
     * Weather other objects can collide into this character.
     * @return True if another object (character) can collide with this.
     */
    @Override
    public boolean isCollidable() {
        return !alive;
    }

    /**
     * Handles a collision event.
     * @param character The colliding character.
     */
    @Override
    public void onCollision(final Character character) {
        kill();
    }

    /**
     * Changes the position of the character on the grid and handles collisions.
     * @param inGridPosition New position on the grid.
     */
    @Override
    public void setGridPosition(final IntVector2D inGridPosition) {
        // If the characters coordinates are different trigger a collision
        if (!getGridPosition().equals(inGridPosition)) {
            Level level = getLevel();
            if (level != null) {
                level.onCharacterMove(this, inGridPosition);
            }
        }

        super.setGridPosition(inGridPosition);
    }
}
