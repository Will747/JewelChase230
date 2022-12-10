package com.example.jewelchase230.profiles;

import java.io.Serializable;
import java.util.UUID;

/**
 * This class manages the highest score of a Profile,
 * for the intent of it to be used to record the highest
 * score of a player per level X.
 * @author Kellie Robinson
 */
public class ProfileScore implements Serializable {
    /**
     * int which holds the highest score of a player.
     */
    private int highestScore;

    /**
     * Holds the player's unique ID.
     */
    private final UUID userUniqueID;

    /**
     * The name of the player.
     */
    private final String playerName;

    /**
     * Constructs a new ProfileScore.
     *
     * @param inHighestScore The highest score achieved.
     * @param profile        The profile responsible for the score.
     */
    public ProfileScore(final int inHighestScore, final Profile profile) {
        highestScore = inHighestScore;
        userUniqueID = profile.getUniquePlayerID();
        playerName = profile.getPlayerName();
    }

    /**
     * @return player name.
     */
    public String getName() {
        return playerName;
    }

    /**
     * @return the highestScore
     */
    public int getHighestScore() {
        return highestScore;
    }

    /**
     * @return the userName
     */
    public UUID getUserUniqueID() {
        return userUniqueID;
    }

    /**
     * @param inHighestScore the highestScore to set
     */
    public void setHighestScore(final int inHighestScore) {
        highestScore = inHighestScore;
    }
}
