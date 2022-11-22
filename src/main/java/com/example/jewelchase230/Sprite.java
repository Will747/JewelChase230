package com.example.jewelchase230;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents Sprites in the game.
 *
 * @author carolinesegestahl
 */
public abstract class Sprite extends Renderable {
    /**
     * Constructs a renderable component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Sprite(int x, int y) {
        super(x, y);
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(int time) {

    }

    /**
     * Draws this item to the canvas.
     *
     * @param gc GraphicsContext for creating draw class.
     */
    @Override
    public void draw(GraphicsContext gc) {

    }
}
