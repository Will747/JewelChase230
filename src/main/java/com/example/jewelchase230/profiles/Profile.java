package com.example.jewelchase230.profiles;

import java.util.UUID;

/**
 * This class manages the Profiles. Includes various constructor
 * methods of Profiles, some functions to handle said objects,
 * and getters and setters.
 *
 * @author Kellie Robinson
 */
public class Profile {
    /**
     * Unique ID of the profile.
     */
    private final UUID uniquePlayerID;

    /**
     * The name of the player.
     */
    private final String playerName;

    /**
     * The highest level reached by the player.
     */
    private Integer levelReached;

    /**
     * The cat character for this profile.
     */
    private final ProfileImage catCharacter;

    /**
     * Constructor of Profile.
     *
     * @param inPlayerName The name of the player.
     * @param catID The cat assigned to the player.
     */
    public Profile(final String inPlayerName, final char catID) {
        uniquePlayerID = UUID.randomUUID();
        playerName = inPlayerName;
        levelReached = 1;
        catCharacter = ProfileImage.getCatFromChar(catID);
    }

    /**
     * Constructor of Profile.
     *
     * @param lineDataSplit Parameters for constructing a Profile.
     */
    public Profile(final String[] lineDataSplit) {
        int i = 0;
        uniquePlayerID = UUID.fromString(lineDataSplit[i++]);
        playerName = lineDataSplit[i++];
        levelReached = Integer.parseInt(lineDataSplit[i++]);
        char catID = lineDataSplit[i].charAt(0);
        catCharacter = ProfileImage.getCatFromChar(catID);
    }

    /**
     * Method which takes a Profile object and returns it to
     * a String format separating each variable with a '.'.
     * This will be fed into the saveProfile() function.
     *
     * @return The profile in string form.
     */
    @Override
    public String toString() {
        return getUniquePlayerID().toString()
                + "." + getPlayerName()
                + "." + getLevelReached()
                + "." + catCharacter.getChar();
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return the levelReached
     */
    public Integer getLevelReached() {
        return levelReached;
    }

    /**
     * @return the uniquePlayerID
     */
    public UUID getUniquePlayerID() {
        return uniquePlayerID;
    }

    /**
     * @return The cat character image.
     */
    public ProfileImage getCatCharacter() {
        return catCharacter;
    }

    /**
     * @return The file path to this profiles last saved game.
     */
    public String getSaveGamePath() {
        return "SaveGames/" + uniquePlayerID.toString() + ".sav";
    }

    /**
     * @param newLevelReached the levelReached to set
     */
    public void setLevelReached(final Integer newLevelReached) {
        System.out.println("updating max level");
        if (newLevelReached > levelReached) {
            levelReached = newLevelReached;
        }
    }
}
