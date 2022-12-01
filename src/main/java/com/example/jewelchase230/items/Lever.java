package com.example.jewelchase230.items;

import java.util.ArrayList;

/**
 * A class to implement levers and provide function when interacted with.
 *
 * @author Ben Stott and Scott Williams
 */
public class Lever extends Item {
    /** The lever image. */
    private static final String LEVER_IMAGE = "images/LEVER.png";

    /** The colour of the gate */ 
    private String colour;

    /**
     * Constructs a new lever
     * @param inColour Settings the lever colour
     */
    public Lever(final String inColour) {
        super(LEVER_IMAGE);
        colour = inColour;
    }

    /**
     * Setting a new colour
     * @param newColour Changing the current lever colour
     */
    public void setColour(String newColour){
        colour = newColour;
    }

    /**
    * Get the lever colour
    * @return The lever colour
    */
    public String getColour(){
        return colour;
    }
    
    /**
     * Finds all gates of the same colour as this lever and removes them
     */
    public void removeGates() {
        ArrayList<Gate> gateArray = getLevel().getAllItemsOfType(Gate.class);
        for (Gate gateInstance: gateArray) {
            if (gateInstance.getColour() == colour) {
                gateInstance.remove();
            }
        }
    }

    /**
     * When collided with, removes all gates then remove the level itself
     */
    @Override
    public void doOnCollision() {
        removeGates();
        remove();
        checkIfDoorOpen();
    }

    /**
     * Thief collision is the same as player collision for levers.
     */
    @Override
    public void doOnThiefCollision() {
        doOnCollision();
    }

}
