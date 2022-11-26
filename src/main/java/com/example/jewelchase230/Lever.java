package com.example.jewelchase230;

public class Lever extends Item{

    private String colour;

    public Lever(int x, int y, String name, String fileName, String colour) {
        super(x, y, name, fileName);
        this.colour = colour;
    }

    public void setColour(String newColour){
        this.colour = newColour;
    }

    public String getColour(){
        return colour;
    }

    public void removeGates() {
        //Removes all gates with the same colour
    }

}
