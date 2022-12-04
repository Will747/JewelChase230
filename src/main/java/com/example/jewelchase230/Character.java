package com.example.jewelchase230;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

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

    private boolean validNextMove(final Tile nextMoveTile) {

        Tile thisTile = getLevel().getTile(getGridPosition());
        ArrayList<TileColour> thisTileColours = thisTile.getTileColours();
        ArrayList<TileColour> nextTileColours = nextMoveTile.getTileColours();
        for (int i = 0; i < thisTileColours.size(); i++) {
            for (int j = 0; j < nextTileColours.size(); j++) {
                if (thisTileColours.get(i) == nextTileColours.get(j)) {
                    Item tileItem =
                            getLevel().getItem(nextMoveTile.getGridPosition());
                    if (tileItem != null) {
                        if (!(tileItem.getCollidable())) {
                            return false;
                        } else {
                            tileItem.doOnCollision();
                        }
                    } else if (nextMoveTile.isNextToBomb()) {
                        nextMoveTile.getBomb().doOnCollision();
                        return true;
                }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the character can move up.
     *
     * @return a boolean, true or false.
     */
    protected IntVector2D canMoveUp() {
        IntVector2D gridPos = getGridPosition();
        int currentDifference = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            currentDifference -= 1;
            IntVector2D yTry =
                new IntVector2D(gridPos.getX(), gridPos.getY() + currentDifference);
            if (getLevel().checkValidTile(yTry)) {
                Tile nextMoveTile = getLevel().getTile(yTry);
                if (validNextMove(nextMoveTile)) {
                    return yTry;
                }
            } else {
                stillInRange = false;
            }
        }
        return gridPos;
    }

    /**
     *Checks if the character can move down.
     *
     * @return a boolean, true or false.
     */
    protected IntVector2D canMoveDown() {
        IntVector2D gridPos = getGridPosition();
        int currentDifference = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            currentDifference += 1;
            IntVector2D yTry =
                new IntVector2D(gridPos.getX(), gridPos.getY() + currentDifference);
            if (getLevel().checkValidTile(yTry)) {
                Tile nextMoveTile = getLevel().getTile(yTry);
                if (validNextMove(nextMoveTile)) {
                    return yTry;
                }
            } else {
                stillInRange = false;
            }
        }
        return gridPos;
    }

    /**
     * Checks if the character can move right.
     *
     * @return a boolean, true or false.
     */
    protected IntVector2D canMoveRight() {
        IntVector2D gridPos = getGridPosition();
        int currentDifference = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            currentDifference += 1;
            IntVector2D xTry =
                new IntVector2D(gridPos.getX() + currentDifference, gridPos.getY());
            if (getLevel().checkValidTile(xTry)) {
                Tile nextMoveTile = getLevel().getTile(xTry);
                if (validNextMove(nextMoveTile)) {
                    return xTry;
                }
            } else {
                stillInRange = false;
            }
        }
        return gridPos;
    }

    /**
     * Checks if the character can move left.
     *
     * @return a boolean, true or false
     */
    protected IntVector2D canMoveLeft() {
        IntVector2D gridPos = getGridPosition();
        int currentDifference = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            currentDifference -= 1;
            IntVector2D xTry =
                new IntVector2D(gridPos.getX() + currentDifference, gridPos.getY());
            if (getLevel().checkValidTile(xTry)) {
                Tile nextMoveTile = getLevel().getTile(xTry);
                if (validNextMove(nextMoveTile)) {
                    return xTry;
                }
            } else {
                stillInRange = false;
            }
        }
        return gridPos;
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
     * Changes the position of the character on the grid and handles collisions.
     * @param inGridPosition New position on the grid.
     */
    @Override
    public void setGridPosition(final IntVector2D inGridPosition) {
        super.setGridPosition(inGridPosition);
        /*Level level = getLevel();
        if (level != null) {
            Item itemOnTile = level.getTile(inGridPosition).getItem();
            if (itemOnTile != null) {
                itemOnTile.doOnCollision();
            }
        }*/
    }
}
