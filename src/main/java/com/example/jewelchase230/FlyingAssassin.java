package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Implements the Flying Assassin. A class to implement the move
 * patterns and events of the AICharater Flying Assassin.
 *
 * @author Caroline Segestaal.
 */
public class FlyingAssassin extends AICharacter {
    /** Left facing image. */
    static final String FACING_LEFT_IMAGE =
            "images/FLYING_ASSASSIN_LEFT_FACE.png";
    /** Right facing image. */
    static final String FACING_RIGHT_IMAGE =
            "images/FLYING_ASSASSIN_RIGHT_FACE.png";

    /**
     * Constructs a renderable component.
     * @param inDirection The inputted direction.
     */
    public FlyingAssassin(final Direction inDirection) {
        setDirection(inDirection);
        setImageFromFile(imageManager(inDirection));
    }

    /**
     * Controls the next move of the Flying Assassin.
     */
    @Override
    public void getNextMove() {
        IntVector2D currentPos = getGridPosition();
        IntVector2D newPos = getMoveDifference(currentDirection);
        int xDiff = newPos.getX();
        int yDiff = newPos.getY();
        IntVector2D potentialPosition = canMove(xDiff, yDiff, this, null);
        if (potentialPosition == currentPos) {
            Direction newDirection =
                    currentDirection.getOppositeDirection(currentDirection);
            currentDirection = newDirection;
            setGridPosition(canMove(0 - xDiff, 0 - yDiff, this, null));
            setImageFromFile(imageManager(newDirection));
        } else {
            setGridPosition(potentialPosition);
        }
    }

    /**
     * Flying assassin cannot be destroyed.
     */
    @Override
    public void doOnCollision() {

    }

    /**
     * Gets the correct image depending on the direction.
     * @param d new direction.
     * @return image corresponding with the direction.
     */
    private String imageManager(final Direction d) {
        return switch (d) {
            case LEFT -> FACING_LEFT_IMAGE;
            case RIGHT -> FACING_RIGHT_IMAGE;
            default -> FACING_LEFT_IMAGE;
        };
    }
}


//        If the Flying Assassin connects with (i.e. occupies
//        the same tile) the player, the player loses. If they
//        connect with another NPC, that NPC is removed
//        from the game.
