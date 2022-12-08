package com.example.jewelchase230.items;

/**
 * Lever and Gate colours.
 * @author Caroline Segestahl and Ben Stott.
 */
public enum LeverGateColour {
    /** Red Colour.*/
    Red("images/LEVER_GREEN.png", "images/GATE.png"),
    /** Blue Colour.*/
    Blue("images/LEVER_GREEN.png", "images/GATE.png"),
    /** Green Colour.*/
    Green("images/LEVER_GREEN.png", "images/GATE.png");

    private String leverImage;

    private String gateImage;

    LeverGateColour(final String LeverImageFileName, final String gateImageFileName) {
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

    public String getLeverImage() {
        return leverImage;
    }

    public String getGateImage() {
        return gateImage;
    }
}
