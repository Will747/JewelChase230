package com.example.jewelchase230;

public class Bomb extends Item{

private int time;

    public Bomb(int x, int y, String name, String fileName, int time) {
        super(x, y, name, fileName);
        this.time = time;
    }

    public void setTime(int newTime) {
        this.time = newTime;
    }

    public int getTime() {
        return this.time;
    }

    public void explode() {
        //Gets grid position and wipes out all items on that row and column
    }
}
