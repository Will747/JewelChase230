package com.example.jewelchase230.items;

/**
 * A class to implement doors and end the level if the door is open.
 *
 * @author Ben Stott
 */
public class Door extends Item {
    /** Is the door open or closed. */
    private boolean isDoorOpen = false;
    /** The Door image. */
    private static final String DOOR_IMAGE = "images/DOOR.png";
   

    /**
     * Constructs a new door.
     */
    public Door() {
        super(DOOR_IMAGE);
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
        setCollidable(true);
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

    /**
     * Shouldn't be removed when hit by explosion.
     */
    @Override
    public void doOnExplosionCollision() {

    }
}
