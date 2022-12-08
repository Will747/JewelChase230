package com.example.jewelchase230.items;

import com.example.jewelchase230.characters.Character;

/**
 * A class to implement gates of a certain colour.
 *
 * @author Ben Stott and Scott Williams
 */
public class Gate extends Item {

    /** The gate colour. */
    private final LeverGateColour colour;

    /**
     * Constructs a new gate.
     * @param inColour defines the gate colour.
     */
    public Gate(final LeverGateColour inColour) {
        super(inColour.getGateImage());
        setCollidable(false);
        colour = inColour;
    }

    /**
     * Returns the colour of the gate.
     * @return colour of the gate.
     */
    public LeverGateColour getColour() {
        return colour;
    }

    /**
     * Shouldn't be collidable and if it is collided nothing should happen.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
    }

    /**
     * Shouldn't be removed when hit by an explosion.
     */
    @Override
    public void doOnExplosionCollision() {

    }
}
