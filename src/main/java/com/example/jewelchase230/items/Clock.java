package com.example.jewelchase230.items;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.characters.Player;

/**
 * A class to implement clocks which add additional time to the level.
 *
 * @author Ben Stott
 */
public class Clock extends Item {
    /**
     * The clock image.
     */
    private static final String CLOCK_IMAGE = "images/CLOCK.png";

    /**
     * Additional time clock provides to player.
     */
    private int timeFromClock;

    /**
     * Constructs a clock.
     *
     * @param inTime Additional time clock provides to player.
     */
    public Clock(final int inTime) {
        super(CLOCK_IMAGE);
        timeFromClock = inTime * Main.MILLISECONDS_IN_A_SECOND;
    }

    /**
     * Changes the current additional time value.
     *
     * @param newTime The new additional time value.
     */
    public void setTime(final int newTime) {
        timeFromClock = newTime;
    }

    /**
     * Get the additional time value.
     *
     * @return The additional time value.
     */
    public int getTime() {
        return timeFromClock;
    }

    /**
     * Adds time to the remaining time of the level.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        if (collidingCharacter instanceof Player) {
            getLevel().addTime(timeFromClock);
        }
        remove();
    }
}
