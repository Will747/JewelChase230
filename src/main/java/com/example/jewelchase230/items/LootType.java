package com.example.jewelchase230.items;

import java.util.Random;

/**
 * A type of loot, each with a different reward if collected.
 *
 * @author Will Kaye
 */
public enum LootType {
    /**
     * Pile of coins.
     */
    Coins(100, "images/COINS.png"),
    /**
     * Bag of coins.
     */
    Bag(250, "images/BAG.png"),
    /**
     * Beer.
     */
    Beer(500, "images/Beer.png"),
    /**
     * Cocktail.
     */
    Cocktail(750, "images/COCKTAIL.png");

    /**
     * Number of points received when collected.
     */
    private final int value;

    /**
     * Path to image file.
     */
    private final String image;

    LootType(final int inValue, final String imagePath) {
        value = inValue;
        image = imagePath;
    }

    /**
     * Random picks a type of loot with weighting based on value.
     *
     * @return A randomly picked type of loot.
     */
    public static LootType getRandomType() {
        Random random = new Random();
        int randomNumber = random.nextInt(Cocktail.getValue());

        if (randomNumber < Coins.getValue()) {
            return Coins;
        }

        if (randomNumber < Bag.getValue()) {
            return Bag;
        }

        if (randomNumber < Beer.getValue()) {
            return Beer;
        }
        return Cocktail;
    }

    /**
     * Converts the input value to a loot type.
     *
     * @param value input value.
     * @return Corresponding loot value.
     */
    public static LootType getTypeFromInput(final int value) {
        return values()[value - 1];
    }

    /**
     * @return Number of points received when collected.
     */
    public int getValue() {
        return value;
    }

    /**
     * @return Path to the image which should be rendered for
     * this type of loot.
     */
    public String getImage() {
        return image;
    }
}
