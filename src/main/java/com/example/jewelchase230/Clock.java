package com.example.jewelchase230;

public class Clock extends Item{

    private int time;

    public Clock(int x, int y, String name, String fileName, int time) {
        super(x, y, name, fileName);
        this.time = time;
    }

    public void setTime(int newTime) {
        this.time = newTime;
    }

    public int getTime() {
        return this.time;
    }
}