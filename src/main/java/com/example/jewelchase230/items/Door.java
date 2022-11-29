package com.example.jewelchase230.items;

/**
 * A class to implement doors and end the level if the door is open.
 *
 * @author Ben Stott
 */
public class Door extends Item {
    /** Is the door open or closed. */
    private boolean isDoorOpen = false;

    /**
     * Constructs a new door.
     */
    public Door() {
        super(null);
    }

    /**
     * Returns whether the door is open or not.
     * @return True if open, false if closed.
     */
    public boolean getIsDoorOpen() {
        return isDoorOpen;
    }

    /**
     * Change if the door is open or closed.
     * @param openOrClose True if open, false if closed.
     */
    public void setIsDoorOpen(boolean openOrClose) {
        isDoorOpen = openOrClose;
    }

    /**
     * Ends the level with winning situation if door is open.
     */
    @Override
    public void doOnCollision() {
        if (isDoorOpen) {
            //winning end level situation
        }
    }

    /**
     * Ends the level with losing situation if door is open.
     */
    @Override
    public void doOnThiefCollision() {
        if (isDoorOpen) {
            //losing end level situation
        }
    }
}
