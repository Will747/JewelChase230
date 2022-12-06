package com.example.jewelchase230;

import javafx.scene.input.KeyEvent;

/**
 * A class to control the Player character.
 *
 * @author Caroline Segestaal.
 */
public class Player extends Character {
    /**
     * Constructs a renderable component.
     */
    public Player() {
        super();

        setImageFromFile("images/CAT_TABBY_SIT.png");
    }

    /**
     * Handles the key press from the player and executes the appropriate event.
     *
     * @param keyPress Reads the keypress from the user.
     */
    public void processKeyEvent(final KeyEvent keyPress) {
        if (isAlive) {
            switch (keyPress.getCode()) {
                case UP:
                    setGridPosition(canMove(0, -1, this, null));
                    break;
                case DOWN:
                    setGridPosition(canMove(0, 1, this, null));
                    break;
                case RIGHT:
                    setGridPosition(canMove(1, 0, this, null));
                    break;
                case LEFT:
                    setGridPosition(canMove(-1, 0, this, null));
                    break;
                default:
                    break;
            }

            keyPress.consume();
        } else {
            getLevel().gameOver();
        }
    }
}
