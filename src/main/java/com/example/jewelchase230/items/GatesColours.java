package com.example.jewelchase230.items;

//import javafx.scene.image.Image;
import javafx.scene.paint.Color;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

/**
 * Gates colours.
 * @author Caroline Segestahl.
 */
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

//    /** Gate image. */
//    private Image image = null;
//
//    GatesColours(final String imageFileName) {
//        try {
//            image = new Image(new FileInputStream(imageFileName));
//        } catch (FileNotFoundException e) {
//            System.out.println(imageFileName + " file not found");
//        }
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

//        /** Returns the image.
//         * @return The gate image. */
//        public Image getImage() {
//            return image;
//        }

}
