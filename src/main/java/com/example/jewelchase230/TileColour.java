package com.example.jewelchase230;

import javafx.scene.paint.Color;

/**
 * Tile colour - This could probably be changed to hold an image in the future.
 */
public enum TileColour {
    /** Red Colour. */
    Red(new Color(1, 0, 0, 1)),
    /** Blue Colour. */
    Blue(new Color(0, 0, 1, 1)),
    /** Green Colour. */
    Green(new Color(0, 1, 0, 1)),
    /** Yellow Colour. */
    Yellow(new Color(0, 0.5, 0.5, 1));

    /** The colour of a section of a tile. */
    private final Color colour;

    TileColour(final Color inColour) {
        colour = inColour;
    }

    /**
     * Converts a character to tile.
     * @param c The character.
     * @return Converted colour.
     */
    public static TileColour getTileColourType(char c) {
        switch (c) {
            case 'r':
                return Red;
            case 'g':
                return Green;
            case 'b':
                return Blue;
            default:
                return Yellow;
        }
    }

    /**
     * @return The javaFX color.
     */
    public Color getColour() {
        return colour;
    }
}
