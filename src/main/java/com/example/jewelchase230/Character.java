package com.example.jewelchase230;

/**
 * Renders the characters to the game.
 *
 * @author carolinesegestahl.
 */
public abstract class Character extends Sprite {
    /**
     * Constructs a renderable component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Character(int x, int y) {
        super(x, y);
    }

    /**
     * Checks if the character can move up.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveUp(int x, int y) {

        return Main.getCurrentLevel().getLevelSize().getY() < getGridPosition().getY();
        //if tile color is same and no interrupting items then make the move
    }

    /**
     *Checks if the character can move down.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveDown(int x, int y) {

        return Main.getCurrentLevel().getLevelSize().getY() > getGridPosition().getY();
        //if tile color is same and no interrupting items then make the move
    }

    /**
     * Checks if the character can move right.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false.
     */
    protected boolean canMoveRight(int x, int y) {

        return Main.getCurrentLevel().getLevelSize().getX() > getGridPosition().getX();
        //if tile color is same and no interrupting items then make the move
    }

    /**
     * Checks if the character can move left.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     * @return a boolean, true or false
     */
    protected boolean canMoveLeft(int x, int y) {
        return Main.getCurrentLevel().getLevelSize().getX() < getGridPosition().getX();
        //if tile color is same and no interrupting items then make the move
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
}
