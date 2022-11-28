package com.example.jewelchase230;

public class Loot extends Item{

    private int rarity;
    private int counter;

    public Loot(int x, int y, String name, String fileName, int rarity) {
        super(x, y, name, fileName);
        this.rarity = rarity;
    }
    
}


// will need a switch statement which assigns each case of rarity to a loot value
// lootCoin = 100; lootBagofCoins = 250; lootBeer = 500; lootCocktail = 750; 
// these should then change the variable playerActiveScore in Player upon collision
// feel free to change item image names to match
// - Kiwi
