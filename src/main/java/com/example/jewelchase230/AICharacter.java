package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Class to control the AI characters.
 *
 * @author Caroline Segestaal.
 */
public abstract class AICharacter extends Character {
    /** Time since last tick. */
    private int timeSinceLastImageChange = 0;
    /** Time between moves. */
    protected static final int MILLISECONDS_PER_MOVE = 1000;
    /** Current Direction. */
    protected Direction currentDirection;

    /**
     * Constructs a renderable component.
     */
    public AICharacter() {
        super();
    }

    /**
     * Finds the x or y coordinate to change.
     * @param inDirection Direction to be faced.
     * @return x and y coordinates to change.
     */
    public IntVector2D getMoveDifference(Direction inDirection) {
        int xDiff = 0;
        int yDiff = 0;
        switch (inDirection) {
            case UP: yDiff = -1;
                break;
            case DOWN: yDiff = 1;
                break;
            case LEFT: xDiff = -1;
                break;
            case RIGHT: xDiff = 1;
                break;
            default: System.out.print("ERROR: No direction given to flying assassin!");
                break;
        }
        return (new IntVector2D(xDiff, yDiff));
    }
   

    /**
     * Constructs a renderable component.
     */
    public AICharacter(Direction inDirection) {
        super();
    }

    /** The default next move. */
    protected void getNextMove() {

    }

    /**
     * Gets the current direction.
     * @return Current direction.
     */
    protected Direction getDirection() {
        return currentDirection;
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
            getNextMove();
            timeSinceLastImageChange = 0;
        }
    }

    /**
     * Sets direction of the NPC.
     * @param inDirection the direction it is currently facing.
     */
    protected void setDirection(final Direction inDirection) {
        currentDirection = inDirection;
    }
}
