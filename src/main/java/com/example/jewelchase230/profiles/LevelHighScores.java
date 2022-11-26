package com.example.jewelchase230.profiles;

public class LevelHighScores {

	private int levelID; 
	private ProfileScore[] playerScores;
	
	
	
	
	/**
	 * @return the levelID
	 */
	public int getLevelID() {
		return levelID;
	}
	/**
	 * @return the playerScores
	 */
	public ProfileScore[] getPlayerScores() {
		return playerScores;
	}
	/**
	 * @param levelID the levelID to set
	 */
	public void setLevelID(int levelID) {
		this.levelID = levelID;
	}
	/**
	 * @param playerScores the playerScores to set
	 */
	public void setPlayerScores(ProfileScore[] playerScores) {
		this.playerScores = playerScores;
	} 
	
}
