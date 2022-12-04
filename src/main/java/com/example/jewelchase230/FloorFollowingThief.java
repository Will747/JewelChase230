package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class FloorFollowingThief extends AICharacter {
    /**
     * Constructs a renderable component.
     */
    public FloorFollowingThief(Direction d) {
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

        /*if (canMoveUp()) {
            y = y + 1;
        } else {
            if (canMoveRight()) {
                x = x + 1;
            } else {
                if (canMoveDown()) {
                    y = y - 1;
                } else {
                    if (canMoveLeft()) {
                        x = x - 1;
                    }
                }
            }
        } */

        move.setX(x);
        move.setY(y);
        this.setGridPosition(move);
        return move;

    }
}
