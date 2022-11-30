package com.example.jewelchase230;

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
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveUp(int x, int y) {
        IntVector2D yTry = new IntVector2D(getGridPosition().getX(), getGridPosition().getY() + 1);
        if (getLevel().getLevelSize().getY() < getGridPosition().getY()) {
            if (getLevel().getTile(getGridPosition()).getTop() == getLevel().getTile(yTry).getBottom()) {
                return true;
            }
        }
        // no interrupting items then make the move
        return false;
    }

    /**
     *Checks if the character can move down.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveDown(int x, int y) {
        IntVector2D yTry = new IntVector2D(getGridPosition().getX(), getGridPosition().getY() - 1);
        if (getLevel().getLevelSize().getY() > getGridPosition().getY()) {
            if (getLevel().getTile(getGridPosition()).getBottom() == getLevel().getTile(yTry).getTop()){
                return true;
            }
        }
        return false;
        //no interrupting items then make the move
    }

    /**
     * Checks if the character can move right.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveRight(int x, int y) {
        IntVector2D xTry = new IntVector2D(getGridPosition().getX() + 1, getGridPosition().getY());
        if (getLevel().getLevelSize().getX() > getGridPosition().getX()) {
            if (getLevel().getTile(getGridPosition()).getRight() == getLevel().getTile(xTry).getRight()) {
                return true;
            }
        }
        return false;
        //if no interrupting items then make the move
    }

    /**
     * Checks if the character can move left.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false
     */
    protected boolean canMoveLeft(int x, int y) {
        IntVector2D xTry = new IntVector2D(getGridPosition().getX() - 1, getGridPosition().getY());
        if (getLevel().getLevelSize().getX() < getGridPosition().getX()) {
            if (getLevel().getTile(getGridPosition()).getLeft() == getLevel().getTile(xTry).getLeft()) {
                return true;
            }
        }
        return false;
        //if no interrupting items then make the move
    }

    /**
     * Method to collect item. If Character and Item are at the same tile, item will be collected.
     *
     * @param z //just for now.
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return True if an item is on the same tile as a character, else false.
     */
    protected boolean collectItem(boolean z, int x, int y) {
        // if item position = character position
        //pick up
        //else nothing
        return z;
    }

    /**
     * Method to see if a collision is occurring.
     *
     * @param z //just for now.
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return True if a collision is taking place on the tile the character is on.
     */
    protected boolean collision(boolean z, int x, int y) {
        return z;
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(int time) {

    }
}
