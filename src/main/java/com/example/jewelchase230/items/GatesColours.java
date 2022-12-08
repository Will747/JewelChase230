package com.example.jewelchase230.items;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public enum GatesColours {
    /** Red Colour.*/
    Red(new Color(1, 0, 0, 1)),
    /** Blue Colour.*/
    Blue(new Color(0, 0, 1, 1)),
    /** Green Colour.*/
    Green(new Color(0, 1, 0, 1)),
    /** Yellow Colour. */
    Yellow(new Color(1, 1, 0, 1)),
    /** Cyan colour.*/
    Cyan(new Color(0, 0.7, 0.7, 1)),
    /** Magenta colour.*/
    Magenta(new Color(0.7, 0, 1, 1));

    /** colour. */
    private final Color colour;

    GatesColours(final Color inColour) {
        colour = inColour;
    }

    /**
     * Converts a character to colour.
     *
     * @param c The character.
     * @return Converted colour.
     */
    public static GatesColours gateColourInputConversion(final char c) {
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
