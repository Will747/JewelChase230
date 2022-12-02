package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class FloorFollowingThief extends AICharacter {
    /**
     * Constructs a renderable component.
     */
    public FloorFollowingThief() {
        super();
    }

    /**
     * getNextMoveFloorThief.
     * @return Position after making move.
     */
    protected IntVector2D getNextMoveFloorThief() {
        IntVector2D move = new IntVector2D();
        int x = this.getGridPosition().getX();
        int y = this.getGridPosition().getY();

        if (canMoveUp(x, y)) {
            y = y + 1;
        } else {
            if (canMoveRight(x, y)) {
                x = x + 1;
            } else {
                if (canMoveDown(x, y)) {
                    y = y - 1;
                } else {
                    if (canMoveLeft(x, y)) {
                        x = x - 1;
                    }
                }
            }
        }

        move.setX(x);
        move.setY(y);
        this.setGridPosition(move);
        return move;

    }
}
