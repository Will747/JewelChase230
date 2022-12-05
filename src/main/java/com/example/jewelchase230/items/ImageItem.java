package com.example.jewelchase230.items;

/**
 * A class to implement gates of a certain colour.
 *
 * @author Ben Stott.
 */
public class ImageItem extends Item {
    /** Time to display the image. */
    private int displayTime;

    private boolean canBeRemoved = false;

    /**
     * Constructs a new gate.
     * @param colour defines the gate colour.
     */
    public ImageItem(final String displayImage) {
        super();
        setImageFromFile(displayImage);
        System.out.println(displayImage + "set at " + getGridPosition().getX() + getGridPosition().getY());
    }

    /**
     * Set the time for the image to be displayed.
     * @param time
     */
    public void setDisplayTime(int time) {
        displayTime = time;
        canBeRemoved = true;
    }

    /**
     * Player collisions should have no effect
     */
    @Override
    public void doOnCollision() {
        
    }

    /**
     * Thief collisions should have no effect
     */
    @Override
    public void doOnThiefCollision() {

    }

    /**
     * Explosion collisions should have no effect
     */
    @Override
    public void doOnExplosionCollision() {

    }

    @Override
    public void tick(int time) {
        if (getLevel().checkValidTile(getGridPosition())) {
            if (displayTime > 0) {
                displayTime -= time;
            } else if (displayTime <= 0 && canBeRemoved) {
                remove();
            }
        }
    }
}
