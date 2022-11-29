package com.example.jewelchase230.items;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

public class Bomb extends Item {

    /** The bomb image. */
    private static final String BOMB_IMAGE = "images/BOMB.png";

    /** The time until the bomb explodes. */
    private int time;

    /**
     * Constructs a new bomb.
     * @param inTime The time delay until the bomb explodes.
     */
    public Bomb(final int inTime) {
        super(BOMB_IMAGE);
        time = inTime;
    }

    /**
     * Sets the time until the bomb explodes.
     * @param newTime The time.
     */
    public void setTime(final int newTime) {
        this.time = newTime;
    }

    /**
     * @return The time until the bomb explodes.
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Check if item type is valid to be removed.
     * @param item Item to have type checked if it's valid to be removed.
     * @return
     */
    public Boolean checkValidRemove(Item item) {
        if (item instanceof Gate || item instanceof Door) {
            return false;
        }
        return true;
    }

    /**
     * Explosion removing all items, except Doors and Gates, from the level.
     */
    public void explode() {
        Level currentLevel = Main.getCurrentLevel();
        ArrayList<Item> itemArray = currentLevel.getAllItems();
        final int currentXCoordinate = this.getGridPosition().getX();
        final int currentYCoordinate = this.getGridPosition().getY();
        for (Item itemInstance : itemArray) {
            IntVector2D itemInstanceGridPosition = itemInstance.getGridPosition();
            int itemInstanceX = itemInstanceGridPosition.getX();
            int itemInstanceY = itemInstanceGridPosition.getY();
            if (itemInstanceX == currentXCoordinate) { //removes all items on the same row
                if (itemInstance instanceof Bomb) {
                    Bomb newBomb = (Bomb) itemInstance;
                    newBomb.explode();
                }
                if (checkValidRemove(itemInstance)) {
                    itemInstance.remove();
                }
            }
            if (itemInstanceY == currentYCoordinate) { //removes all items on the same column
                if (itemInstance instanceof Bomb) {
                    Bomb newBomb = (Bomb) itemInstance;
                    newBomb.explode();
                }
                if (checkValidRemove(itemInstance)) {
                    itemInstance.remove();
                }
            }
        }
    }

    /**
     * Counts down from 3 then explodes.
     */
    public void doOnCollision() {
        //Countdown needs to be implemented
        explode();
        remove();
    }
}
