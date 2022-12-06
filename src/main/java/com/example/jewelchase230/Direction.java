package com.example.jewelchase230;

/**
 * Direction the AICharacter is facing and moving.
 *
 * @author Caroline Segestaal.
 */
public enum Direction {
    /** The four directions. */
    UP, DOWN, LEFT, RIGHT;

    /**
     * Changes the direction the AICharacter is facing by 180 degrees.
     *
     * @param d The direction the AICharacter is facing.
     * @return Returns the new direction the AICharacter is facing.
     */
    public Direction getOppositeDirection(final Direction d) {
        return switch (d) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }

    /**
     * Finds the direction after a left turn.
     * @param d Direction in.
     * @return New direction.
     */
    public Direction getLeftDirection(final Direction d) {
        return switch (d) {
            case UP -> LEFT;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
            case RIGHT -> UP;
        };
    }

    /**
     * Finds the direction after a right turn.
     * @param d Direction in.
     * @return New Direction.
     */
    public Direction getRightDirection(final Direction d) {
        return switch (d) {
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
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
            default -> UP;
        };
    }
}
