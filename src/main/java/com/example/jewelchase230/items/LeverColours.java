package com.example.jewelchase230.items;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public enum LeverColours {
    /**
     * Red Colour.
     */
    Red(new Color(1, 0, 0, 1)),
    /**
     * Blue Colour.
     */
    Blue(new Color(0, 0, 1, 1)),
    /**
     * Green Colour.
     */
    Green("LEVER_GREEN.png"),
    /**
     * Yellow Colour.
     */
    Yellow(new Color(1, 1, 0, 1)),
    /**
     * Cyan colour.
     */
    Cyan(new Color(0, 0.7, 0.7, 1)),
    /**
     * Magenta colour.
     */
    Magenta(new Color(0.7, 0, 1, 1));

    /**
     * colour.
     */
    private Color colour;

    LeverColours(final Color inColour) {
        colour = inColour;
    }

    /** Lever image. */
    private Image image = null;

    LeverColours(final String imageFileName) {
        try {
            image = new Image(new FileInputStream(imageFileName));
        } catch (FileNotFoundException e) {
            System.out.println(imageFileName + " file not found");
        }
    }
    /**
     * Converts a character to colour.
     *
     * @param c The character.
     * @return Converted colour.
     */
    public static LeverColours leverColourInputConversion(final char c) {
        return switch (c) {
            case 'r' -> Red;
            case 'g' -> Green;
            case 'b' -> Blue;
            case 'm' -> Magenta;
            case 'c' -> Cyan;
            case 'y' -> Yellow;
            default -> Yellow;
        };
    }

}
