package com.example.jewelchase230.profiles;

import java.util.ArrayList;

/**
 * This class will manage player High Scores. This class will save high scores
 * to a file, read this file where needed to be used in HighScoreTable class.
 * 
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

	public LevelHighScores() {

	}

	/**
	 * Method which searches the ArrayList of profiles scores and checks alongside
	 * Profile and PlayerScore to check if the player's current level score is a new
	 * high score. If the high score is beaten, the profileScore is updated. If no
	 * high score exists for this profile on this level, it is recorded.
	 * 
	 * @param profile
	 * @param playerCurrentLevel
	 * @param input
	 */
	// seperate function : updatePlayerScore. when function gets called it has
	// profile as paramater and playerLevelScore, search and if current score
	// is higher, overwrite and if doesnt exist make

	public void updatePlayerScore(Profile profile, int playerCurrentLevel, ProfileScore input) {
		for (int i = 0; i <= levelScoreList.size(); i++) {
			if (input.getUserUniqueID() == profile.getUniquePlayerID()) {
				if (playerLevelScore > input.getHighestScore()) {
					input.setHighestScore(playerLevelScore);
					levelScoreList.set(i, playerLevelScore);
				}
			} else {
				ProfileScore profileScore = new ProfileScore(profile.getUniquePlayerID(), playerLevelScore);
				levelScoreList.add(playerLevelScore);

			}

		}

	}

	ArrayList<Integer> orderedLevelHighScores = new ArrayList<Integer>();
	// vv should we change this to an Array, as it should be fixed to 10 scores?
	ArrayList<Integer> topTenHighScores = new ArrayList<Integer>();

	// note: will need serializable to load in these values

	/**
	 * This method will take the levelScore array and sort them from highest to
	 * lowest
	 * 
	 * @param levelScores
	 * @return
	 */
	public ArrayList<Integer> orderHighScores(ArrayList<Integer> levelScores) {

		return orderedLevelHighScores;
	}

	/**
	 * This method will take the sorted ArrayList of scores per level X and take the
	 * top 10 and add to Array topTenHighScores
	 * 
	 * @param orderedLevelHighScores
	 * @return
	 */
	public ArrayList<Integer> cullTopTenHighScores(ArrayList<Integer> orderedLevelHighScores) {

		return topTenHighScores;
	}
	
	
	
	
	

	/**
	 * @return the levelID
	 */
	public int getLevelID() {
		return playerCurrentLevel;
	}

	/**
	 * @return the levelScoreList
	 */
	public ArrayList<Integer> getLevelScoreList() {
		return levelScoreList;
	}

	/**
	 * @return the playerCurrentLevel
	 */
	public int getPlayerCurrentLevel() {
		return playerCurrentLevel;
	}

	/**
	 * @return the playerLevelScore
	 */
	public int getPlayerLevelScore() {
		return playerLevelScore;
	}

	/**
	 * @return the orderedLevelHighScores
	 */
	public ArrayList<Integer> getOrderedLevelHighScores() {
		return orderedLevelHighScores;
	}

	/**
	 * @return the topTenHighScores
	 */
	public ArrayList<Integer> getTopTenHighScores() {
		return topTenHighScores;
	}

}
