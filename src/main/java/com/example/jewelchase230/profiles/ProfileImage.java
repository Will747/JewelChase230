package com.example.jewelchase230.profiles;

import java.util.Random;

/**
 * Character / profile image.
 *
 * @author Ben Stott.
 */
public enum ProfileImage {
    /**
     * Black cat.
     */
    Black("images/CAT_BLACK_SIT"),

    /**
     * Black and white cat.
     */
    Oreo("images/CAT_OREO_SIT"),

    /**
     * Ginger cat.
     */
    Tabby("images/CAT_TABBY_SIT"),

    /**
     * White cat.
     */
    White("images/CAT_WHITE_SIT");

    /**
     * The file path for the image.
     */
    private String catImagePath;

    ProfileImage(final String imagePath) {
        catImagePath = imagePath;
    }

    /**
     * Gets the file path for the left facing image.
     * 
     * @return The file path for the left facing image.
     */
    public String getLeft() {
        return (catImagePath + "_LEFT.png");
    }

    /**
     * Gets the file path for the right facing image.
     * 
     * @return The file path for the right facing image.
     */
    public String getRight() {
        return (catImagePath + "_RIGHT.png");
    }

    /**
     * Gets a random cat character.
     * 
     * @return A randomly picked cat image.
     */
    public static ProfileImage getRandomCat() {
        Random random = new Random();
        int randomNum = random.nextInt(values().length);
        return values()[randomNum];
    }
}
