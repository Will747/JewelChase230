package com.example.jewelchase230.items;

public class Clock extends Item {
    /** The clock image. */
    private static final String CLOCK_IMAGE = "images/CLOCK.png";

    /** Additional time clock provides to player. */
    private int time;

    /**
     * Constructs a clock.
     * @param inTime Additional time clock provides to player.
     */
    public Clock(final int inTime) {
        super(CLOCK_IMAGE);
        this.time = inTime;
    }

    public void setTime(int newTime) {
        this.time = newTime;
    }

    public int getTime() {
        return this.time;
    }
}
