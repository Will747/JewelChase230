package com.example.jewelchase230;

public class Bomb extends Item {

    /** The bomb image. */
    private static final String BOMB_IMAGE = "images/BOMB.png";

    /** The time until the bomb explodes. */
    private int time;

    /**
     * Constructs a new bomb.
     * @param inTime The time delay until the bomb explodes.
     */
    public Bomb(final int inTime) {
        super(BOMB_IMAGE);
        time = inTime;
    }

    /**
     * Sets the time until the bomb explodes.
     * @param newTime The time.
     */
    public void setTime(final int newTime) {
        this.time = newTime;
    }

    /**
     * @return The time until the bomb explodes.
     */
    public int getTime() {
        return this.time;
    }

    //psueod code for explode. waiting for getObjectArray and setObjectArray in level class (or similar)

    public void explode() {
        /*level currentLevel = main.getCurrentLevel();
        ArrayList<Object> objectArray = currentLevel.getObjectArray();
        for (int i=0; i < objectArray.size(); i++) {
            if (i.getX == this.getX) {
                i.remove()
            }
            if (i.getY == this.getY) {
                i.remove()
            }
        }
        main.currentLevel.setObjectArray(objectArray);  */
    }

    public void doOnCollision() {
        explode();
        remove();
    }
}
