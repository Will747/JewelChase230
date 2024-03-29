package com.example.jewelchase230.items;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.vectors.IntVector2D;

/**
 * A class to implement bombs and provide function when interacted with.
 *
 * @author Ben Stott
 */
public class Bomb extends Item {
    /**
     * Time since the image last changed.
     */
    private int timeSinceLastImageChange = 0;
    /**
     * The index for currently displayed image in countdownArray.
     */
    private int currentImageInCountdown = 0;
    /**
     * Whether the bomb has collided with a character.
     */
    private boolean hasCollided = false;
    /**
     * Whether the bomb has collided with an explosion.
     */
    private boolean fastExplode = false;
    /**
     * The bomb image.
     */
    private static final String BOMB_IMAGE = "images/BOMB.png";
    /**
     * The explosion image.
     */
    private static final String EXPLOSION_IMAGE = "images/BOMB_EXPLOSION.png";
    /**
     * The bomb countdown images.
     */
    private final String[] countdownArray = {"images/BOMB_3.png",
            "images/BOMB_2.png", "images/BOMB_1.png"};

    /**
     * Constructs a new bomb.
     */
    public Bomb() {
        super(BOMB_IMAGE);
        setCollidable(false);
    }

    /**
     * Every game tick checks bomb status.
     *
     * @param time Time since the last frame.
     */
    @Override
    public void tick(final int time) {
        if (hasExploded()) {
            timeSinceLastImageChange += time;
            if (timeSinceLastImageChange >= Main.MILLISECONDS_IN_A_SECOND) {
                countdown();
            }
        } else if (fastExplode) {
            timeSinceLastImageChange += time;
            countdown();
        } else if (hasCollided) {
            timeSinceLastImageChange += time;
            if (timeSinceLastImageChange >= Main.MILLISECONDS_IN_A_SECOND) {
                countdown();
            }
        }
    }

    /**
     * Counts down from 3 and changes the bomb image.
     */
    public void countdown() {
        timeSinceLastImageChange = 0;
        if (currentImageInCountdown < countdownArray.length
                && (hasCollided || fastExplode)) {
            setImageFromFile(countdownArray[currentImageInCountdown]);
            currentImageInCountdown++;
        } else if (!(hasExploded())) {
            setImageFromFile(EXPLOSION_IMAGE);
            explode();
            setHasExploded();
        } else {
            super.doOnExplosionCollision();
        }

    }

    /**
     * Produces an explosion on a tile.
     *
     * @param posToExplode Tile to produce explosion on.
     */
    public void explodePosition(final IntVector2D posToExplode) {
        Level currentLevel = getLevel();
        Item currentItem = currentLevel.getItem(posToExplode);
        Character currentCharacter =
                currentLevel.getSpecificCharacter(posToExplode);
        if (currentItem != null) {
            currentItem.doOnExplosionCollision();
        }
        if (currentCharacter != null) {
            currentCharacter.onCollision(null);
        }
    }

    /**
     * Explosion removing all items on the same row and column, expect gates and
     * doors.
     */
    public void explode() {
        setImageFromFile(EXPLOSION_IMAGE);
        boolean continueExplosionUp = true;
        boolean continueExplosionDown = true;
        boolean continueExplosionLeft = true;
        boolean continueExplosionRight = true;
        int explodeUp = 0;
        int explodeDown = 0;
        int explodeLeft = 0;
        int explodeRight = 0;
        final IntVector2D currentPos = getGridPosition();
        while (continueExplosionUp || continueExplosionDown
                || continueExplosionLeft || continueExplosionRight) {
            if (continueExplosionUp) {
                explodeUp += 1;
                IntVector2D newPos =
                        currentPos.add(new IntVector2D(0, explodeUp));
                if (getLevel().checkTileExists(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionUp = false;
                }
            }
            if (continueExplosionDown) {
                explodeDown -= 1;
                IntVector2D newPos =
                        currentPos.add(new IntVector2D(0, explodeDown));
                if (getLevel().checkTileExists(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionDown = false;
                }
            }
            if (continueExplosionLeft) {
                explodeLeft -= 1;
                IntVector2D newPos =
                        currentPos.add(new IntVector2D(explodeLeft, 0));
                if (getLevel().checkTileExists(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionLeft = false;
                }
            }
            if (continueExplosionRight) {
                explodeRight += 1;
                IntVector2D newPos =
                        currentPos.add(new IntVector2D(explodeRight, 0));
                if (getLevel().checkTileExists(newPos)) {
                    explodePosition(newPos);
                } else {
                    continueExplosionRight = false;
                }
            }
        }
        getLevel().checkIfDoorOpen();
    }

    /**
     * Counts down from 3 then explodes.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        hasCollided = true;
    }

    /**
     * Collision with an explosion.
     */
    @Override
    public void doOnExplosionCollision() {
        fastExplode = true;
    }
}
