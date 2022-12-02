package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class FloorFollowingThief extends AICharacter {
    /**
     * Constructs a renderable component.
     */
    public FloorFollowingThief() {
        super();
    }

    protected IntVector2D getNextMoveFloorThief() {
        IntVector2D move = new IntVector2D();
        int x = this.getGridPosition().getX();
        int y = this.getGridPosition().getY();

        if (this.canMoveUp(x, y) == true) {
            y = y + 1;
        } else {
            if (this.canMoveRight(x, y) == true) {
                x = x + 1;
            } else {
                if (this.canMoveDown(x, y) == true) {
                    y = y - 1;
                } else {
                    if (this.canMoveLeft(x, y) == true) {
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
