package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Class to control the AI characters.
 *
 * @author Caroline Segestaal.
 */
public abstract class AICharacter extends Character{
    /**
     * Constructs a renderable component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public AICharacter(int x, int y) {
        super(x, y);
    }

    protected void getNextMove(IntVector2D move) {

    }
}