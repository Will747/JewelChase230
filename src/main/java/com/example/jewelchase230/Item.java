package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class Item extends Sprite {

    public Item(int x, int y) {
        super(x, y);
    }

    public Item(String name, IntVector2D gridPos) {

    }

    private String name;
    private String fileName;

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
