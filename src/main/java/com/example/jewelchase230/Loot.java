package com.example.jewelchase230;

public class Loot extends Item{

    private int rarity;
    private int counter;

    public Loot(int x, int y, String name, String fileName, int rarity) {
        super(x, y, name, fileName);
        this.rarity = rarity;
    }
    
}
