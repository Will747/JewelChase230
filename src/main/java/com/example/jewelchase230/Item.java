package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class Item extends Sprite {

    public Item(int x, int y, String name, String fileName) {
        super(x, y);
        this.name = name;
        this.fileName = fileName;
    }

    /*public Item(String name, IntVector2D gridPos) {
        super(gridPos.getX(), gridPos.getY());

    }*/

    public String name;
    public String fileName;

    public void remove(Item item){
        item.setGridPosition(new IntVector2D(-1,-1));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return fileName;
    }

    public void doOnCollision() {

    }
}
