package com.example.jewelchase230.items;

/**
 * A class to implement clocks which add additional time to the level.
 *
 * @author Ben Stott
 */
public class Clock extends Item {
    /** The clock image. */
    private static final String CLOCK_IMAGE = "images/CLOCK.png";

    /** Additional time clock provides to player. */
    private int timeFromClock;

    /**
     * Constructs a clock.
     * @param inTime Additional time clock provides to player.
     */
    public Clock(final int inTime) {
        super(CLOCK_IMAGE);
        timeFromClock = inTime;
    }

    /**
     * Changes the current additional time value.
     * @param newTime The new additional time value.
     */
    public void setTime(int newTime) {
        timeFromClock = newTime;
    }

    /**
     * Get the additional time value.
     * @return The additional time value.
     */
    public int getTime() {
        return timeFromClock;
    }

    /**
     * Adds time to the remaining time of the level.
     */
    @Override
    public void doOnCollision() {
        getLevel().addTime(timeFromClock);
        remove();
    }
}
