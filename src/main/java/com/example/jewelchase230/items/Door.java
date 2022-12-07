package com.example.jewelchase230.items;

import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.characters.Player;

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
    public void setIsDoorOpen(final boolean openOrClose) {
        isDoorOpen = openOrClose;
        setCollidable(true);
    }

    /**
     * Ends the level with winning situation if it is the player
     * and the door is open.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        if (isDoorOpen && collidingCharacter instanceof Player) {
            //winning end level situation
        } else {
            getLevel().gameOver();
        }
    }

    /**
     * Shouldn't be removed when hit by explosion.
     */
    @Override
    public void doOnExplosionCollision() {

    }
}
