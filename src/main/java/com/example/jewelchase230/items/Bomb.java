package com.example.jewelchase230.items;

import com.example.jewelchase230.Tile;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

/**
 * A class to implement bombs and provide function when interacted with.
 *
 * @author Ben Stott
 */
public class Bomb extends Item {
    /** Time since the image last changed. */
    private int timeSinceLastImageChange = 0;
    /** The game frame rate. */
    private static final int FRAME_RATE = 10;
    /** Milliseconds in a second. */
    private static final int MILLISECONDS_IN_A_SECOND = 1000;
    /** Time between image change when a fast explode occours. */
    private static final int FAST_EXPLODE_COUNTDOWN_RATE = 100;
    /** The index for currently displayed image in countdownArray. */
    private int currentImageInCountdown = 0;
    /** Whether the bomb has collided with a character. */
    private boolean hasCollided = false;
    /**  Whether the bomb has collided with an explosion. */
    private boolean fastExplode = false;
    /** The bomb image. */
    private static final String BOMB_IMAGE = "images/BOMB.png";
    /** The bomb countdown images. */
    final String[] countdownArray = { "images/BOMB_3.png", "images/BOMB_2.png", "images/BOMB_1.png" };

    /**
     * Constructs a new bomb.
     *
     */
    public Bomb() {
        super();
        setImageFromFile(BOMB_IMAGE);
        setCollidable(false);
    }

    // May not be in a level at the time of construction
    // setTriggers(getGridPosition());

    /**
     * Every game tick checks bomb status.
     * @param time Time since the last frame.
     */
    @Override
    public void tick(int time) {
        if (fastExplode) {
            timeSinceLastImageChange += time;
            if (timeSinceLastImageChange > FAST_EXPLODE_COUNTDOWN_RATE) {
                countdown();
                timeSinceLastImageChange = 0;
            }
        } else if (hasCollided) {
            timeSinceLastImageChange += time;
            if (timeSinceLastImageChange > MILLISECONDS_IN_A_SECOND) {
                countdown();
                timeSinceLastImageChange = 0;
            }
        }

    }

    /**
     * Fast explosion when this bomb gets hit by an explosion.
     */
    /*public void fastExplode() {
        fastExplode = true;
    } */

    /**
     * Counts down from 3 and changes the bomb image.
     */
    public void countdown() {
        if (currentImageInCountdown < countdownArray.length-1 && (hasCollided || fastExplode)) {
            currentImageInCountdown++;
            setImageFromFile(countdownArray[currentImageInCountdown]);
        } else {
            explode();
            remove();
        }

    }

    /**
     * Produces an explosion on a tile.
     * @param posToExplode Tile to produce explosion on.
     */
    public void explodePosition(IntVector2D posToExplode) {
        Level currentLevel = getLevel();
        Item currentItem = currentLevel.getItem(posToExplode);
        if (currentItem != null) {
            currentItem.doOnExplosionCollision();
        } else {
            // Here is where an explosion image/animation should be added to the tile
        }
    }

    /**
     * Explosion removing all items on the same row and column, expect gates and
     * doors.
     */
    public void explode() {
        //setTriggers(null);
        boolean continueExplosionUp = true;
        boolean continueExplosionDown = true;
        boolean continueExplosionLeft = true;
        boolean continueExplosionRight = true;
        int explodeUp = 0;
        int explodeDown = 0;
        int explodeLeft = 0;
        int explodeRight = 0;
        final IntVector2D currentPos = getGridPosition();
        while (continueExplosionUp || continueExplosionDown || 
        continueExplosionLeft || continueExplosionRight) {
            if (continueExplosionUp) {
                explodeUp += 1;
                IntVector2D newPos = currentPos.add(new IntVector2D(0, explodeUp));
                if (getLevel().checkValidTile(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionUp = false;
                }
            }
            if (continueExplosionDown) {
                explodeDown -= 1;
                IntVector2D newPos = currentPos.add(new IntVector2D(0, explodeDown));
                if (getLevel().checkValidTile(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionDown = false;
                }
            }
            if (continueExplosionLeft) {
                explodeLeft -= 1;
                IntVector2D newPos = currentPos.add(new IntVector2D(explodeLeft, 0));
                if (getLevel().checkValidTile(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionLeft = false;
                }
            }
            if (continueExplosionRight) {
                explodeRight += 1;
                IntVector2D newPos = currentPos.add(new IntVector2D(explodeRight, 0));
                if (getLevel().checkValidTile(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionRight = false;
                }
            }
        }
    }

    /**
     * Counts down from 3 then explodes.
     */
    @Override
    public void doOnCollision() {
        hasCollided = true;
    }

    /**
     * Thief collision is the same as player collision for bombs.
     */
    @Override
    public void doOnThiefCollision() {
        doOnCollision();
    }

    /**
     * Collision with an explosion.
     */
    @Override
    public void doOnExplosionCollision() {
        fastExplode = true;
    }
}
