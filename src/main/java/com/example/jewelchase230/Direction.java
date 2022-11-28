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
}
