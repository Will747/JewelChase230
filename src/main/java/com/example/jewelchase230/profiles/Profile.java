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
	/** Unique ID of the profile. */
	private UUID uniquePlayerID;

	/** The name of the player. */
	private String playerName;

	/** The highest level reached by the player. */
	private Integer levelReached;

	/**
	 * Constructor of Profile.
	 * @param inPlayerName The name of the player.
	 */
	  public Profile(final String inPlayerName) {
		  uniquePlayerID = UUID.randomUUID();
		  playerName = inPlayerName;
		  levelReached = 0;
		}

	  /**
	   * Constructor of Profile.
	   * @param lineDataSplit Parameters for constructing a Profile.
	   */
	  public Profile(final String[] lineDataSplit) {
		  uniquePlayerID = UUID.fromString(lineDataSplit[0]);
		  playerName = lineDataSplit[1];
		  levelReached = Integer.parseInt(lineDataSplit[2]);
	  }

	  /**
	   * Method which takes a Profile object and returns it to
	   * a String format separating each variable with a '.'.
	   * This will be fed into the saveProfile() function.
	   * @return The profile in string form.
	   */
	  @Override
	  public String toString() {
		return getUniquePlayerID().toString()
				+ "." + getPlayerName()
				+ "." + getLevelReached();
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
	 * @param newLevelReached the levelReached to set
	 */
	public void setLevelReached(final Integer newLevelReached) {
		levelReached = newLevelReached;
	}
}
