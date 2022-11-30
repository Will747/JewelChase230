package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Class to control the AI characters.
 *
 * @author Caroline Segestaal.
 */
public abstract class AICharacter extends Character {
    /**
     * Constructs a renderable component.
     */
    public AICharacter() {
        super();
    }

    protected void getNextMove(IntVector2D move) {

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
