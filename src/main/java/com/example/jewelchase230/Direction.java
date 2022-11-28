package com.example.jewelchase230;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

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
