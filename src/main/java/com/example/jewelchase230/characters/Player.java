package com.example.jewelchase230.characters;

import com.example.jewelchase230.Main;
import javafx.scene.input.KeyEvent;
import com.example.jewelchase230.Direction;

/**
 * A class to control the Player character.
 *
 * @author Caroline Segestaal.
 */
public class Player extends Character {
    /**
     * Time since kill check.
     * Checks if player is still alive every second.
     */
    private int timeSinceLastKillCheck = 0;

    /**
     * Constructs a renderable component.
     */
    public Player() {
        super();
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {
        super.tick(time);

        timeSinceLastKillCheck += time;
        if (timeSinceLastKillCheck > Main.MILLISECONDS_IN_A_SECOND) {
            if (!isAlive()) {
                getLevel().gameOver();
            }
            timeSinceLastKillCheck = 0;
        }
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
                case W:
                    setGridPosition(canMove(0, -1));
                    break;
                case DOWN:
                case S:
                    setGridPosition(canMove(0, 1));
                    break;
                case RIGHT:
                case D:
                    setGridPosition(canMove(1, 0));
                    setImageFromFile(getImage(Direction.RIGHT));
                    break;
                case LEFT:
                case A:
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
