package com.example.jewelchase230;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Tile colour - Holds the image for a colour on a section of a tile.
 *
 * @author Will Kaye
 */
public enum TileColour {
    /** Red Colour. */
    Red("images/WOODFLOOR_RED.png"),
    /** Blue Colour. */
    Blue("images/WOODFLOOR_BLUE.png"),
    /** Green Colour. */
    Green("images/WOODFLOOR_GREEN.png"),
    /** Yellow Colour. */
    Yellow("images/WOODFLOOR_YELLOW.png"),
    /** Magenta Colour.*/
    Magenta("images/WOODFLOOR_MAGENTA.png"),
    /** Cyan Colour. */
    Cyan("images/WOODFLOOR_CYAN.png");

    /** The colour of a section of a tile. */
    private Image image = null;

    TileColour(final String imageFileName) {
        try {
            image = new Image(new FileInputStream(imageFileName));
        } catch (FileNotFoundException e) {
            System.out.println(imageFileName + " file not found");
        }
    }

    /**
     * Converts a character to tile.
     * @param c The character.
     * @return Converted colour.
     */
    public static TileColour getTileColourType(final char c) {
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

    /**
     * @return The javaFX color.
     */
    public Image getImage() {
        return image;
    }
}
