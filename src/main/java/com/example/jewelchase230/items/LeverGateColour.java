package com.example.jewelchase230.items;

/**
 * Lever and Gate colours.
 * @author Caroline Segestahl and Ben Stott.
 */
public enum LeverGateColour {
    /** Red Colour.*/
    Pink("images/LEVER_PINK.png",
    "images/GATE_PINK.png"),
    /** Blue Colour.*/
    Blue("images/LEVER_BLUE.png",
     "images/GATE_BLUE.png"),
    /** Green Colour.*/
    Green("images/LEVER_GREEN.png",
     "images/GATE_GREEN.png");

    /** The lever image. */
    private final String leverImage;

    /** The gate image. */
    private final String gateImage;

    /**  Lever and Gate colours.
     * @param gateImageFileName The gate image file.
     * @param leverImageFileName The lever image file.
     */
    LeverGateColour(final String leverImageFileName,
            final String gateImageFileName) {
        leverImage = leverImageFileName;
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
            case 'p' -> Pink;
            case 'g' -> Green;
            case 'b' -> Blue;
            default -> Pink;
        };
    }

    /**
     * Gets the lever image for this colour.
     * @return Lever image.
     */
    public String getLeverImage() {
        return leverImage;
    }

    /**
     * Gets the gate image for this colour.
     * @return Gate image.
     */
    public String getGateImage() {
        return gateImage;
    }
}
