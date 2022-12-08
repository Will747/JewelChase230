package com.example.jewelchase230.items;

import com.example.jewelchase230.characters.Character;

import java.util.ArrayList;

/**
 * A class to implement levers and provide function when interacted with.
 *
 * @author Ben Stott and Scott Williams
 */
public class Lever extends Item {

    /** The colour of the gate. */
    private LeverGateColour colour;

    /**
     * Constructs a new lever.
     * @param inColour Settings the lever colour.
     */
    public Lever(final LeverGateColour inputColour) {
        super(inputColour.getLeverImage());
        colour = inputColour;
    }

    /**
    * Get the lever colour.
    * @return The lever colour.
    */
    public LeverGateColour getColour() {
        return colour;
    }

    /**
     * Finds all gates of the same colour as this lever and removes them.
     */
    public void removeGates() {
        ArrayList<Gate> gateArray = getLevel().getAllItemsOfType(Gate.class);
        for (Gate gateInstance: gateArray) {
            if (gateInstance.getColour().equals(colour)) {
                gateInstance.remove();
            }
        }
    }

    /**
     * When collided with, removes all gates then remove the lever itself.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        removeGates();
        remove();
    }
}
