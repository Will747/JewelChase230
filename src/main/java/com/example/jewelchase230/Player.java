package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

/**
 * A class to control the Player character.
 *
 * @author Caroline Segestaal.
 */



/** Hi :) I added a currentLevel integer for me to use in the highScoreClass. This should increment the integer by 1 each time a level is completed
*Also added an activePlayerScore which will add score when loot is got, etc 
*These **May** need changed to private, not sure. 
*
*To add in future once branches merged: 
*upon Door, when level is completed, calls Profile to change currentLevel of object Profile
* - Kiwi
*I also added addToActiveScore in order to add points when collecting items
* - Ben
*/

public class Player extends Character{
	
	public int playerCurrentLevel;
	public int playerActiveScore; 
	
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
     * Adds score to the active current score of player.
     * @param score Score to be added to the active score.
     */
    public void addToActiveScore(int score) {
        playerActiveScore += score;
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
        gc.drawImage(new Image("images/CAT_TABBY_SIT.png"), 3, 1);
    }

}
