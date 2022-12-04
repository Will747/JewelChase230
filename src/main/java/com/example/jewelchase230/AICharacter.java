package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Class to control the AI characters.
 *
 * @author Caroline Segestaal.
 */
public abstract class AICharacter extends Character {

    /** Time between moves. */
    private static final int MILLISECONDS_PER_MOVE = 1000;
    /** Direction. */
    private Direction d;
    /** Time since last tick. */
    private int timeSinceLastImageChange = 0;
    /**
     * Constructs a renderable component.
     */
    public AICharacter() {
        super();
    }

    protected void getNextMove(final IntVector2D move, final Direction d) {

    }

    protected void getNextMove(final Direction d) {
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {
        timeSinceLastImageChange += time;
        if (timeSinceLastImageChange > MILLISECONDS_PER_MOVE) {
            getNextMove(d);
            timeSinceLastImageChange = 0;
        }
    }

    /**
     * Sets direction of the NPC.
     * @param inDirection the direction it is currently facing.
     */
    protected void setDirection(final Direction inDirection) {
        d = inDirection;
    }
}
