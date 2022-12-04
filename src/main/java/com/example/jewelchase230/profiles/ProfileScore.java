package com.example.jewelchase230.profiles;

import java.io.Serializable;

public class ProfileScore implements Serializable {
	/** int which holds the highest score of a player */
	private int highestScore;
	/** Integer which holds the player's unique ID */
	private int userUniqueID;

	public ProfileScore(int highestScore, int userUniqueID) {
		this.highestScore = highestScore; 
		this.userUniqueID = userUniqueID; 
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
