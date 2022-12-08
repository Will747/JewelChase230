package com.example.jewelchase230.items;

/**
 * Lever and Gate colours.
 * @author Caroline Segestahl and Ben Stott.
 */
public enum LeverGateColour {
    /** Red Colour.*/
    Red("images/LEVER_GREEN.png",
    "images/GATE.png"),
    /** Blue Colour.*/
    Blue("images/LEVER_GREEN.png",
     "images/GATE.png"),
    /** Green Colour.*/
    Green("images/LEVER_GREEN.png",
     "images/GATE.png");

    /** The lever image. */
    private final String leverImage;

    /** The gate image. */
    private final String gateImage;

    /**  Lever and Gate colours. */
    LeverGateColour(final String LeverImageFileName, 
            final String gateImageFileName) {
        leverImage = LeverImageFileName;
        gateImage = gateImageFileName;
    }
    /**
     * Converts a character to colour.
     *
     * @param c The character.
     * @return Converted colour.
     */
    public static LeverGateColour colourInputConversion(final char c) {
        return switch (c) {
            case 'r' -> Red;
            case 'g' -> Green;
            case 'b' -> Blue;
            default -> Red;
        };
    }

    /**
     * Gets the lever image for this colour.
     * @return
     */
    public String getLeverImage() {
        return leverImage;
    }

    /**
     * gets the gate image for this colour.
     * @return
     */
    public String getGateImage() {
        return gateImage;
    }
}
