package com.example.jewelchase230.profiles;

import java.util.ArrayList;
/** 
 * This class will manage player High Scores. 
 * This class will save high scores to a file, read this file where needed to be used in HighScoreTable class.
 * @author Kellie Robinson
 *
 */



public class LevelHighScores {
	  /** integer which holds the player's current level */
	private int playerCurrentLevel; 
	  /** ArrayList holds scores of all players from each Level */
	ArrayList<Integer> levelScoreList = new ArrayList<Integer>();
	/** Integer which specifies the player's score for this level */
	private int playerLevelScore;
	
	public LevelHighScores () { 
		
	}
	
	//seperate function : updatePlayerScore. when function gets called it has profile as paramater and playerLevelScore, search and if current score
	// is higher, overwrite and if doesnt exist make
	
	public void updatePlayerScore(Profile profile, int playerCurrentLevel) { 
		for(int i = 0; i <= levelScoreList.size(); i++) { 
			/** if the ProfileScore.getuniquePlayerID == profile.getID
			 * if playerLevelScore > levelScoreList.get(i) { 
			 * playerScore.set(highestScore) = playerLevelScore
			 * levelScoreList(i) = playerScore.get(highestScore);
			 * 		else if (profile.getID not exists in  ProfileScore.uniquePlayerID)
			 * 				profileUniqueID as Profile.getID
			 * 				profile highest score as playerLevelScore
			 */
			
			
			
		}
		
	}
	
	ArrayList<Integer> levelScores = new ArrayList<Integer>(); 
	ArrayList<Integer> orderedLevelHighScores = new ArrayList<Integer>();
	// vv should we change this to an Array, as it should be fixed to 10 scores? 
	ArrayList<Integer> topTenHighScores = new ArrayList<Integer>();

	
	//note: will need serializable to load in these values
	
	
	/**
	 * This method will take the levelScore array and sort them from highest to lowest
	 * @param levelScores
	 * @return
	 */
	public ArrayList <Integer> orderHighScores(ArrayList<Integer>levelScores){
		
		
		
		return orderedLevelHighScores;
	}
	
	
	/**
	 * This method will take the sorted ArrayList of scores per level X and take the top 10 and add to Array topTenHighScores
	 * @param orderedLevelHighScores
	 * @return
	 */
	public ArrayList <Integer> cullTopTenHighScores(ArrayList<Integer> orderedLevelHighScores) { 
		
		return topTenHighScores;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @return the levelID
	 */
	public int getLevelID() {
		return playerCurrentLevel;
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
		this.playerCurrentLevel = levelID;
	}
	/**
	 * @param playerScores the playerScores to set
	 */
	public void setPlayerScores(ProfileScore[] playerScores) {
		this.playerScores = playerScores;
	} 
	
}
