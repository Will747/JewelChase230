package com.example.jewelchase230.profiles;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Character / profile images.
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
     * Converts a character to a cat.
     *
     * @param catID The character.
     * @return The corresponding cat.
     */
    public static ProfileImage getCatFromChar(final char catID) {
        return switch (catID) {
            case 'b' -> Black;
            case 'o' -> Oreo;
            case 't' -> Tabby;
            case 'w' -> White;
            default -> Tabby;
        };
    }

    /**
     * Gets the cat id.
     *
     * @return The cat id.
     */
    public char getChar() {
        return (name().toLowerCase().charAt(0));
    }

    /**
     * @return The profile image facing left.
     */
    public Image getLeftImage() {
        try {
            return new Image(new FileInputStream(catImagePath + "_LEFT.png"));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load profile image!");
        }

        return null;
    }

    /**
     * @return The profile image facing right.
     */
    public Image getRightImage() {
        try {
            return new Image(new FileInputStream(catImagePath + "_RIGHT.png"));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load profile image!");
        }

        return null;
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
