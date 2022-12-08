package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Direction the AICharacter is facing and moving.
 *
 * @author Caroline Segestaal.
 */
public enum Direction {
    /** The four directions. */
    UP, DOWN, LEFT, RIGHT, NONE;

    /**
     * Changes the direction the AICharacter is facing by 180 degrees.
     *
     * @return Returns the new direction the AICharacter is facing.
     */
    public Direction getOppositeDirection() {
        return switch (this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            default -> NONE;
        };
    }

    /**
     * Finds the direction after a left turn.
     * @return New direction.
     */
    public Direction getLeftDirection() {
        return switch (this) {
            case UP -> LEFT;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
            case RIGHT -> UP;
            default -> NONE;
        };
    }

    /**
     * Finds the direction after a right turn.
     * @return New Direction.
     */
    public Direction getRightDirection() {
        return switch (this) {
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
            default -> NONE;
        };
    }

    /**
     * Allows for a string parameter to be passed and an enum to be returned
     * for object creation.
     * @param directionString The inputted direction from the level file.
     * @return The wanted enum from the passed string.
     */
    public static Direction getDirectionType(final String directionString) {
        return switch (directionString) {
            case "u" -> UP;
            case "d" -> DOWN;
            case "l" -> LEFT;
            case "r" -> RIGHT;
            default -> NONE;
        };
    }

    /**
     * Generates a unit vector based on direction.
     * @return The unit vector.
     */
    public IntVector2D getDirectionVector() {
        int xDiff = 0;
        int yDiff = 0;
        switch (this) {
            case UP: yDiff = -1;
                break;
            case DOWN: yDiff = 1;
                break;
            case LEFT: xDiff = -1;
                break;
            case RIGHT: xDiff = 1;
                break;
            default:
                System.out.print("ERROR: No direction for flying assassin!");
                break;
        }
        return new IntVector2D(xDiff, yDiff);
    }
}
