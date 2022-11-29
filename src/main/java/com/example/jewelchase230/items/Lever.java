package com.example.jewelchase230.items;

public class Lever extends Item {
    /** The lever image. */
    private static final String LEVER_IMAGE = "images/LEVER.png";

    private String colour;

    public Lever(final String inColour) {
        super(LEVER_IMAGE);
        colour = inColour;
    }

    public void setColour(String newColour){
        this.colour = newColour;
    }

    public String getColour(){
        return colour;
    }

    //pseudo code for removing gates. waiting for getObjectArray and setObjectArray in level class (or similar)
    
    public void removeGates() {
        /*Level currentLevel = Main.getCurrentLevel();
        ArrayList<Object> objectArray = currentLevel.getObjectArray();
        for (Object itemInstance: objectArray) {
            if (itemInstance instanceof Gate) {
                if (itemInstance.getColour == this.colour) {
                    itemInstance.remove();
                }
            }
        }
        Main.setObjectArray(objectArray); */
    }

    public void doOnCollision() {
        removeGates();
    }

}
