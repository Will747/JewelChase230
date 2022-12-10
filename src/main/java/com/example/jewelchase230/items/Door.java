package com.example.jewelchase230.items;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.characters.Player;

/**
 * A class to implement doors and end the level if the door is open.
 *
 * @author Ben Stott
 */
public class Door extends Item {
    /**
     * Is the door open or closed.
     */
    private boolean isDoorOpen = false;
    /**
     * The closed door image.
     */
    private static final String DOOR_CLOSED_IMAGE = "images/DOOR_CLOSED.png";
    /**
     * The open door image.
     */
    private static final String DOOR_OPEN_IMAGE = "images/DOOR_OPEN.png";

    /**
     * Constructs a new door.
     */
    public Door() {
        super(DOOR_CLOSED_IMAGE);
    }

    /**
     * Returns whether the door is open or not.
     *
     * @return True if open, false if closed.
     */
    public boolean getIsDoorOpen() {
        return isDoorOpen;
    }

    /**
     * Change if the door is open or closed.
     *
     * @param openOrClose True if open, false if closed.
     */
    public void openDoor() {
        isDoorOpen = true;
        setImageFromFile(DOOR_OPEN_IMAGE);
    }

    /**
     * Ends the level with winning situation if it is the player
     * and the door is open.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        Level level = getLevel();
        if (isDoorOpen && collidingCharacter instanceof Player) {
            level.addTimeLeftScore();

            Main.switchRoot(Menu.getLevelComplete());
            Menu.getLevelCompleteController().setLevelCompleted(level);
        } else if (isDoorOpen) {
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
