package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.input.KeyEvent;

/**
 * A class to control the Player character.
 *
 * @author Caroline Segestaal.
 *
 * Hi :) I added a currentLevel integer for me to use in the highScoreClass.
 * This should increment the integer by 1 each time a level is completed
 * Also added an activePlayerScore which will add score when loot is got, etc
 * These **May** need changed to private, not sure.
 *
 * To add in future once ready
 * upon Door, when level is completed, calls Profile to change currentLevel of
 * object Profile / or equivilant & other scores that may need updating
 * - Kiwi
 * I also added addToActiveScore in order to add points when collecting items
 * - Ben
 */
public class Player extends Character {

    /** The current level number. */
    private int playerCurrentLevel;

    /** The players current score. */
    private int playerActiveScore;

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
        IntVector2D gridPos = getGridPosition();

        
        switch (keyPress.getCode()) {
            //BUG: Multiple key inputs when pressing 1 key
            case UP:
                //System.out.println("moving up");
                setGridPosition(canMoveUp());
                break;
            case DOWN:
                //System.out.println("moving down");
                setGridPosition(canMoveDown());
                break;
            case RIGHT:
                //System.out.println("moving right");
                setGridPosition(canMoveRight());
                break;
            case LEFT:
                //System.out.println("moving left");   
                setGridPosition(canMoveLeft());
                break;
            default:
                break;
        }

        keyPress.consume();
    }

    /**
     * Adds score to the active current score of player.
     * @param score Score to be added to the active score.
     */
    public void addToActiveScore(final int score) {
        playerActiveScore += score;
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {

    }
}
