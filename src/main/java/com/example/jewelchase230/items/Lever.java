package com.example.jewelchase230.items;
import com.example.jewelchase230.items.Gate;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;
import java.util.ArrayList;

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
        this.colour = newColour;
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
        Level currentLevel = Main.getCurrentLevel();
        ArrayList<Gate> gateArray = currentLevel.getAllItemsOfType(Gate.class);
        for (Gate gateInstance: gateArray) {
            if (gateInstance.getColour() == this.colour) {
                gateInstance.remove();
            }
        }
    }

    /**
     * When collided with, removes all gates
     */
    public void doOnCollision() {
        removeGates();
    }

}
