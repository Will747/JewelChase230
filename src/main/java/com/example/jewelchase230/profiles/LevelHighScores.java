package com.example.jewelchase230.profiles;

import java.util.ArrayList;
/** 
 * This class will manage player High Scores. 
 * This class will save high scores to a file, read this file where needed to be used in HighScoreTable class.
 * @author Kellie Robinson
 *
 */



public class LevelHighScores {

	private int playerCurrentLevel; 
	private ProfileScore[] playerScores;
	private int playerLevelScore;
	
	public LevelHighScores (int playerLevelScore, Profile profile ) { 
		this.playerLevelScore = playerLevelScore;
		Profile thisProfile = (Profile)profile.clone(); 
		
	}
	
	ArrayList<Integer> levelScores = new ArrayList<Integer>(); 
	ArrayList<Integer> orderedLevelHighScores = new ArrayList<Integer>();
	// vv should we change this to an Array, as it should be fixed to 10 scores? 
	ArrayList<Integer> topTenHighScores = new ArrayList<Integer>();

	
	/**
	 * This method will search for the relevent level high scores in the highscoretperlevel text file using the playerCurrentLevel parameter
	 * and load the relevent scores into the ArrayList
	 * @param playerCurrentLevel
	 * @return levelScores
	 * 
	 */
	public ArrayList<Integer> loadLevelHighScoresToList(int playerCurrentLevel) { 
		
		
		
		
		return levelScores;
	}
	
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
