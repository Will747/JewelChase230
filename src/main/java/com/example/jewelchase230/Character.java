package com.example.jewelchase230;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Renders the characters to the game.
 *
 * @author Caroline Segestaal.
 */
public abstract class Character extends Sprite {
    /**
     * Constructs a renderable component.
     */
    public Character() {
        super();
    }

    /**
     * Checks if the character can move up.
     *
     * @return a boolean, true or false.
     */
    protected boolean canMoveUp() {
        IntVector2D levelSize = getLevel().getLevelSize();
        IntVector2D gridPos = getGridPosition();
        IntVector2D yTry =
                new IntVector2D(gridPos.getX(), gridPos.getY() + 1);
        Tile tile = getLevel().getTile(gridPos);
        Tile newTile = getLevel().getTile(yTry);

        if (levelSize.getY() < gridPos.getY()) {
            if (tile.getTopLeft() == newTile.getBottomLeft()
                    && (tile.getTopRight() == newTile.getBottomRight())) {
                return true;
            }
        }
        return false;
    }

    /**
     *Checks if the character can move down.
     *
     * @return a boolean, true or false.
     */
    protected boolean canMoveDown() {
        IntVector2D levelSize = getLevel().getLevelSize();
        IntVector2D gridPos = getGridPosition();
        IntVector2D yTry =
                new IntVector2D(gridPos.getX(), gridPos.getY() - 1);
        Tile tile = (getLevel().getTile(gridPos));
        Tile newTile = getLevel().getTile(yTry);

        if (levelSize.getY() > gridPos.getY()) {
            if (tile.getBottomLeft() == newTile.getTopLeft()
                    && (tile.getBottomRight() == newTile.getTopRight())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the character can move right.
     *
     * @return a boolean, true or false.
     */
    protected boolean canMoveRight() {
        IntVector2D levelSize = getLevel().getLevelSize();
        IntVector2D gridPos = getGridPosition();
        IntVector2D xTry =
                new IntVector2D(gridPos.getX() + 1, gridPos.getY());
        Tile tile = (getLevel().getTile(gridPos));
        Tile newTile = getLevel().getTile(xTry);

        if (levelSize.getX() > gridPos.getX()) {
            if (tile.getBottomRight() == newTile.getBottomRight()
                    && (tile.getTopRight() == newTile.getTopRight())) {
                    return true;
            }
        }
        return false;
    }

    /**
     * Checks if the character can move left.
     *
     * @return a boolean, true or false
     */
    protected boolean canMoveLeft() {
        IntVector2D levelSize = getLevel().getLevelSize();
        IntVector2D gridPos = getGridPosition();
        IntVector2D xTry =
                new IntVector2D(gridPos.getX() - 1, gridPos.getY());
        Tile tile = (getLevel().getTile(gridPos));
        Tile newTile = getLevel().getTile(xTry);

        if (levelSize.getX() < gridPos.getX()) {
            if (tile.getBottomLeft() == newTile.getBottomLeft()
                    && (tile.getTopLeft() == newTile.getTopLeft())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to collect item. If Character and Item are at the same tile,
     * item will be collected.
     */
    protected void doOnCollision() {

    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {

    }

    /**
     * Changes the position of this on the grid.
     * @param inGridPosition New position on the grid.
     */
    @Override
    public void setGridPosition(final IntVector2D inGridPosition) {
        super.setGridPosition(inGridPosition);
        Item itemOnTile = getLevel().getTile(inGridPosition).getItem();
        if (itemOnTile != null) {
            itemOnTile.doOnCollision();
        }
    }
}
