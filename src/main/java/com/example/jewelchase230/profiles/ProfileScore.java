package com.example.jewelchase230.profiles;

import java.io.Serializable;

public class ProfileScore implements Serializable {
	/** int which holds the highest score of a player */
	private int highestScore;
	/** Integer which holds the player's unique ID */
	private int userUniqueID;
	/**Integer which holds the player's current level*/
	private int currentLevel;
	private String name;
	
	
	public ProfileScore(int highestScore, int currentLevel, String name, int userUniqueID) {
		this.highestScore = highestScore; 
		this.userUniqueID = userUniqueID; 
		this.currentLevel = currentLevel;
		this.name = name;
	}

	
/**
 * @return player name.
 */
	public String getName() { 
		return name;
	}
	
	/**
	 * @return the highestScore
	 */
	public int getHighestScore() {
		return highestScore;
	}
	
	/**
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}


	/**
	 * @return the userName
	 */
	public int getUserUniqueID() {
		return userUniqueID;
	}

	/**
	 * @param highestScore the highestScore to set
	 */
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserUniqueID(int userUniqueID) {
		this.userUniqueID = userUniqueID;
	}

}
