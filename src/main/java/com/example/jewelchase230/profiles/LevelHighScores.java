package com.example.jewelchase230.profiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

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
	/**final integer defining the amount of top players*/ 
	private final int LEGAL_HIGH_SCORE_NUM = 10;
	/** Linked List which holds the top 10 high scores */
	LinkedList<Integer> topTenHighScores = new LinkedList<Integer>();

	
	
	
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

	

	/**
	 * This method will the ArrayList of scores per level X and sorts it, then takes
	 * top 10 and add to Linked List topTenHighScores
	 * 
	 * @param orderedLevelHighScores
	 * @return
	 */
	public LinkedList<Integer> cullTopTenHighScores(ArrayList<Integer> levelScoreList) {
		Collections.sort(levelScoreList);
		Collections.reverse(levelScoreList);
			for (int i = 0; i < LEGAL_HIGH_SCORE_NUM; i++) { 
				topTenHighScores.addLast(levelScoreList.get(i));
			}
		
	
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
	 * @return the topTenHighScores
	 */
	public LinkedList<Integer> getTopTenHighScores() {
		return topTenHighScores;
	}

}
