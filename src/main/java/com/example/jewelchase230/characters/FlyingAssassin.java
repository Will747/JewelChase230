package com.example.jewelchase230.characters;

import com.example.jewelchase230.Direction;
import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Implements the Flying Assassin. A class to implement the move
 * patterns and events of the AICharacter Flying Assassin.
 *
 * @author Caroline Segestaal.
 */
public class FlyingAssassin extends AICharacter {
    /**
     * Left facing image.
     */
    static final String FACING_LEFT_IMAGE =
            "images/FLYING_ASSASSIN_LEFT_FACE.png";
    /**
     * Right facing image.
     */
    static final String FACING_RIGHT_IMAGE =
            "images/FLYING_ASSASSIN_RIGHT_FACE.png";

    /**
     * Constructs a renderable component.
     *
     * @param inDirection The inputted direction.
     */
    public FlyingAssassin(final Direction inDirection) {
        setFacingLeftImage(FACING_LEFT_IMAGE);
        setFacingRightImage(FACING_RIGHT_IMAGE);
        setDirection(inDirection);
    }

    /**
     * Controls the next move of the Flying Assassin.
     */
    @Override
    public void makeNextMove() {
        Direction currentDirection = getDirection();
        IntVector2D currentPos = getGridPosition();
        IntVector2D newPos = getMoveDifference(currentDirection);
        int xDiff = newPos.getX();
        int yDiff = newPos.getY();
        IntVector2D potentialPosition = canMove(xDiff, yDiff);
        if (potentialPosition == currentPos) {
            Direction newDirection =
                    currentDirection.getOppositeDirection();
            setDirection(newDirection);
            setGridPosition(canMove(-xDiff, -yDiff));
        } else {
            setGridPosition(potentialPosition);
        }
    }

    /**
     * Checks if a character can move to a new tile.
     *
     * @param xChange Positive for moving right, negative for moving left.
     * @param yChange Positive for moving down, negative for moving up.
     * @return new tile position, or current position if invalid move.
     */
    @Override
    protected IntVector2D canMove(final int xChange, final int yChange) {
        IntVector2D currentPos = getGridPosition();
        IntVector2D newPos =
                currentPos.add(new IntVector2D(xChange, yChange));
        if (getLevel().checkTileExists(newPos)
                && canCharactersCollide(newPos)) {
            return newPos;
        } else {
            return currentPos;
        }
    }

    /**
     * @return The flying assassin can kill others.
     */
    @Override
    public boolean canKill() {
        return true;
    }

    /**
     * @return Other characters can collide with a flying assassin.
     */
    @Override
    public boolean isCollidable() {
        return true;
    }

    /**
     * The flying assassin is not a thief so doesn't collect/collide with items.
     *
     * @return False - As the assassin is flying.
     */
    @Override
    public boolean canInteractWithItems() {
        return false;
    }

    /**
     * Flying assassin cannot be destroyed.
     */
    @Override
    public void onCollision(final Character character) {
        // Kill character colliding with the assassin.
        if (character != null) {
            character.kill();
        }
    }
}

