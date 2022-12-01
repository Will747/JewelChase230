package com.example.jewelchase230.items;

public class Gate extends Item {

    private boolean visible;
    private String colour;

    public Gate(final String colour) {
        super(null);
        this.colour = colour;
    }


//    public Gate(int x, int y) {
//        super(x, y);
//    }

    /*public Gate(String colour){
        this.colour = colour;
    }*/

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public boolean getVisible(){
        return visible;
    }

    public String getColour(){
        return colour;
    }

    

}