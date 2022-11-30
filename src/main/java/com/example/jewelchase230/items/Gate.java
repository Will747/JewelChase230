package com.example.jewelchase230.items;

/**
 * A class to implement gates of a certain colour.
 *
 * @author Ben Stott and Scott Williams
 */
public class Gate extends Item {

    /** The gate colour. */
    final private String colour;

    /**
     * Constructs a new gate.
     * @param colour defines the gate colour.
     */
    public Gate(final String colour) {
        super(null);
        setCollidable(false);
        this.colour = colour;
    }

    /**
     * Returns the colour of the gate.
     * @return colour of the gate.
     */
    public String getColour(){
        return colour;
    }

    /**
     * Shouldn't be collidable and if it is collided nothing should happen.
     */
    @Override
    public void doOnCollision() {
        
    }

    /**
     * Shouldn't be collidable and if it is collided nothing should happen
     */
    @Override
    public void doOnThiefCollision() {

    }
}
