package com.example.jewelchase230.items;

import java.util.ArrayList;

/**
 * A class to implement bombs and provide function when interacted with.
 *
 * @author Ben Stott
 */
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
    private Boolean checkValidRemove(Item item) {
        if (item instanceof Gate || item instanceof Door) {
            return false;
        }
        return true;
    }

    /**
     * Explosion removing all items on the same row and column, expect gates and doors.
     */
    public void explode() {
        ArrayList<Item> itemArray = getLevel().getAllItems();
        final int currentXCoordinate = getGridPosition().getX();
        final int currentYCoordinate = getGridPosition().getY();
        for (Item itemInstance : itemArray) {
            int itemInstanceX = itemInstance.getGridPosition().getX();
            int itemInstanceY = itemInstance.getGridPosition().getX();
            if (itemInstanceX == currentXCoordinate || itemInstanceY == currentYCoordinate) {
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
    @Override
    public void doOnCollision() {
        //Countdown needs to be implemented
        explode();
        remove();
    }
}
