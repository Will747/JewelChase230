package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/**
 * A class to control the Player character.
 *
 * @author Caroline Segestaal.
 */
public class Player extends Character{
    /**
     * Constructs a renderable component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Player(int x, int y) {
        super(x, y);
    }

    /**
     * Handles the key press from the player and executes the appropriate event.
     *
     * @param keyPress Reads the keypress from the user.
     */
    public void processKeyEvent (KeyEvent keyPress) {
        switch (keyPress.getCode()) {
            case UP:
                if (canMoveUp(getGridPosition().getX(), getGridPosition().getY()))
                    setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() + 1));
            case DOWN:
                if (canMoveDown(getGridPosition().getX(), getGridPosition().getY()))
                    setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() - 1));
            case RIGHT:
                if (canMoveRight(getGridPosition().getX(), getGridPosition().getY()))
                    setGridPosition(new IntVector2D(getGridPosition().getX() + 1, getGridPosition().getY()));
            case LEFT:
                if (canMoveLeft(getGridPosition().getX(), getGridPosition().getY()))
                    setGridPosition(new IntVector2D(getGridPosition().getX() -1, getGridPosition().getY()));
            default:
                break;
        }

        //redraw game

        keyPress.consume();
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
