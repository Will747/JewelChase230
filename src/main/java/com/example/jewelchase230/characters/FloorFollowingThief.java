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
    /**
     * Colour for the FFT to follow.
     */
    private final TileColour colourToFollow;
    /**
     * Left facing image.
     */
    static final String FACING_LEFT_IMAGE =
            "images/FLOOR_FOLLOWING_THIEF_LEFT.png";
    /**
     * Right facing image.
     */
    static final String FACING_RIGHT_IMAGE =
            "images/FLOOR_FOLLOWING_THIEF_RIGHT.png";

    /**
     * Constructs a renderable component.
     *
     * @param d The direction.
     * @param c The tile colour.
     */
    public FloorFollowingThief(final Direction d, final TileColour c) {
        super();
        setFacingLeftImage(FACING_LEFT_IMAGE);
        setFacingRightImage(FACING_RIGHT_IMAGE);
        setDirection(d);
        colourToFollow = c;
    }

    /**
     * Get the left turn x and y difference.
     *
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getLeftDiff(final Direction d) {
        return getMoveDifference(d.getLeftDirection());
    }

    /**
     * Get the right turn x and y difference.
     *
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getRightDiff(final Direction d) {
        return getMoveDifference(d.getRightDirection());
    }

    /**
     * Get the behind turn x and y difference.
     *
     * @param d Current direction.
     * @return x and y difference values to check next move
     */
    private IntVector2D getBehindDiff(final Direction d) {
        return getMoveDifference(d.getOppositeDirection());
    }

    /**
     * Compares two tiles and decides if it is possible to move between them.
     * Ignoring the current positions of other characters.
     *
     * @param nextMoveTile    The tile to be moved to.
     * @param colourFollow    The specific colour the next tile must be.
     * @param currentPos      The current position.
     * @param checkCharacters True if other characters should be
     *                        considered.
     * @return True if valid move, false if not.
     */
    @Override
    protected boolean validNextTile(final Tile nextMoveTile,
                                    final TileColour colourFollow,
                                    final IntVector2D currentPos,
                                    final boolean checkCharacters) {
        return super.validNextTile(
                nextMoveTile, colourToFollow, currentPos, checkCharacters);
    }

    /**
     * Makes the next move for the Floor Following Thief.
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
            setDirection(currentDirection.getLeftDirection());
        } else if (!(potentialForwardPos == currentPos)) {
            setGridPosition(potentialForwardPos);
        } else if (!(potentialRightTurnPos == currentPos)) {
            setGridPosition(potentialRightTurnPos);
            setDirection(currentDirection.getRightDirection());
        } else if (!(potentialBehindPos == currentPos)) {
            setGridPosition(potentialBehindPos);
            setDirection(currentDirection.getOppositeDirection());
        }
    }
}
