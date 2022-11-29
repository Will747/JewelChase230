package com.example.jewelchase230;

/**
 * Direction the AICharacter is facing and moving.
 *
 * @author Caroline Segestaal.
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    /**
     * Changes the direction the AICharacter is facing by 180 degrees.
     *
     * @param d The direction the AICharacter is facing.
     * @return Returns the new direction the AICharacter is facing.
     */
    public Direction getOppositeDirection(Direction d) {
        switch (d) {
            case UP -> d = DOWN;
            case DOWN -> d = UP;
            case LEFT -> d = RIGHT;
            case RIGHT -> d = LEFT;
        }
        return d;
    }

    /**
     * Allows for a string parameter to be passed and a enum to be returned for object creation.
     * @param directionString
     * @return The wanted enum from the passed string.
     */
    public static Direction getDirectionType(String directionString){
        switch(directionString){
            case "UP":
                return UP;
            case "DOWN":
                return DOWN;
            case "LEFT":
                return LEFT;
            case "RIGHT":
                return RIGHT;
        }
        return UP;
    }
}
