package com.example.jewelchase230.characters;

import com.example.jewelchase230.Direction;
import com.example.jewelchase230.Tile;
import com.example.jewelchase230.TileColour;
import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Class to control the Floor Following Thief.
 *
 * @author Ben Stott.
 */
public class FloorFollowingThief extends AICharacter {
    /** Colour for the FFT to follow. */
    private final TileColour colourToFollow;

    /**
     * Constructs a renderable component.
     * @param d The direction.
     * @param c The tile colour.
     */
    public FloorFollowingThief(final Direction d, final TileColour c) {
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
    private IntVector2D getLeftDiff(final Direction d) {
        return getMoveDifference(d.getLeftDirection(d));
    }

    /**
     * Get the right turn x and y difference.
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getRightDiff(final Direction d) {
        return getMoveDifference(d.getRightDirection(d));
    }

    /**
     * Get the behind turn x and y difference.
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getBehindDiff(final Direction d) {
        return getMoveDifference(d.getOppositeDirection(d));
    }

    /**
     * Checks that the next move is a valid move.
     * @param nextMoveTile The tile to be moved to.
     * @return True if valid move, false if not.
     */
    @Override
    protected boolean validNextTile(final Tile nextMoveTile) {
        return super.validNextTile(nextMoveTile, colourToFollow);
    }

    /**
     * Gets the next move for the Floor Following Thief.
     */
    @Override
    protected void makeNextMove() {
        IntVector2D currentPos = getGridPosition();
        Direction currentDirection = getDirection();

        IntVector2D potentialLeftTurnDiffVector = getLeftDiff(currentDirection);
        int leftXDiff = potentialLeftTurnDiffVector.getX();
        int leftYDiff = potentialLeftTurnDiffVector.getY();

        IntVector2D potentialForwardDiffVector =
                getMoveDifference(currentDirection);
        int forwardXDiff = potentialForwardDiffVector.getX();
        int forwardYDiff = potentialForwardDiffVector.getY();

        IntVector2D potentialRightDiffVector = getRightDiff(currentDirection);
        int rightXDiff = potentialRightDiffVector.getX();
        int rightYDiff = potentialRightDiffVector.getY();

        IntVector2D potentialBehindDiffVector =
                getBehindDiff(currentDirection);
        int behindXDiff = potentialBehindDiffVector.getX();
        int behindYDiff = potentialBehindDiffVector.getY();

        IntVector2D potentialLeftTurnPos =
                canMove(leftXDiff, leftYDiff);
        IntVector2D potentialForwardPos =
                canMove(forwardXDiff, forwardYDiff);
        IntVector2D potentialRightTurnPos =
                canMove(rightXDiff, rightYDiff);
        IntVector2D potentialBehindPos =
                canMove(behindXDiff, behindYDiff);
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
            setDirection(currentDirection.getOppositeDirection(
                    currentDirection));
        }
    }
}