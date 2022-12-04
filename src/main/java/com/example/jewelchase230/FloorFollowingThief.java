package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
/**
 * Class to control the Floor Following Thiefs
 *
 * @author Ben Stott.
 */
public class FloorFollowingThief extends AICharacter {
    /** Colour for the FFT to follow. */
    private final TileColour colourToFollow;

    /**
     * Constructs a renderable component.
     */
    public FloorFollowingThief(Direction d, TileColour c) {
        super();
        setDirection(d);
        setImageFromFile("images/CAT_WHITE_SIT.png"); //TEMPORARY IMAGE
        colourToFollow = c;
    }

    /**
     * Get the left turn x and y difference.
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getLeftDiff(Direction d) {
        return getMoveDifference(d.getLeftDirection(d));
    }

    /**
     * Get the right turn x and y difference.
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getRightDiff(Direction d) {
        return getMoveDifference(d.getRightDirection(d));
    }

    /**
     * Get the behind turn x and y difference.
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getBehindtDiff(Direction d) {
        return getMoveDifference(d.getOppositeDirection(d));
    }

    /**
     * Gets the next move for the Floor Following Thief.
     */
    @Override
    protected void getNextMove() {
        IntVector2D currentPos = getGridPosition();

        IntVector2D potentialLeftTurnDiffVector = getLeftDiff(currentDirection);
        int leftXDiff = potentialLeftTurnDiffVector.getX();
        int leftYDiff = potentialLeftTurnDiffVector.getY();

        IntVector2D potentialForwardDiffVector = getMoveDifference(currentDirection);
        int forwardXDiff = potentialForwardDiffVector.getX();
        int forwardYDiff = potentialForwardDiffVector.getY();

        IntVector2D potentialRightDiffVector = getRightDiff(currentDirection);
        int rightXDiff = potentialRightDiffVector.getX();
        int rightYDiff = potentialRightDiffVector.getY();

        IntVector2D potentialBehindtDiffVector = getBehindtDiff(currentDirection);
        int behindXDiff = potentialBehindtDiffVector.getX();
        int behindYDiff = potentialBehindtDiffVector.getY();

        IntVector2D potentialLeftTurnPos = canMove(leftXDiff, leftYDiff, this, colourToFollow);
        IntVector2D potentialForwardPos = canMove(forwardXDiff, forwardYDiff, this, colourToFollow);
        IntVector2D potentialRightTurnPos = canMove(rightXDiff, rightYDiff, this, colourToFollow);
        IntVector2D potentialBehindPos = canMove(behindXDiff, behindYDiff, this, colourToFollow);
        if (!(potentialLeftTurnPos == currentPos)) {
            setGridPosition(potentialLeftTurnPos);
            setDirection(currentDirection.getLeftDirection(currentDirection));
        } else if (!(potentialForwardPos == currentPos)) {
            setGridPosition(potentialForwardPos);
        } else if (!(potentialRightTurnPos == currentPos)) {
            setGridPosition(potentialRightTurnPos);
            setDirection(currentDirection.getRightDirection(currentDirection));
        } else if (!(potentialBehindPos == currentPos)) {
            setGridPosition(potentialBehindPos);
            setDirection(currentDirection.getOppositeDirection(currentDirection));
        } 
    }
}
