package com.example.jewelchase230.characters;

import javafx.scene.input.KeyEvent;
import com.example.jewelchase230.Direction;

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
        if (isAlive()) {
            switch (keyPress.getCode()) {
                case UP:
                    setGridPosition(canMove(0, -1));
                    break;
                case DOWN:
                    setGridPosition(canMove(0, 1));
                    break;
                case RIGHT:
                    setGridPosition(canMove(1, 0));
                    setImageFromFile(getImage(Direction.RIGHT));
                    break;
                case LEFT:
                    setGridPosition(canMove(-1, 0));
                    setImageFromFile(getImage(Direction.LEFT));
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
