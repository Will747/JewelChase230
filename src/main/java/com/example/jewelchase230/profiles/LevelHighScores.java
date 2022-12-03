package com.example.jewelchase230.profiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * This class will manage player High Scores. This class will save high scores
 * to a file, read this file where needed to be used in HighScoreTable class.
 * 
 * @author Kellie Robinson
 *
 */
public class LevelHighScores implements Serializable {
	

	/** ArrayList holds scores of all players from this Level */
	private ArrayList<ProfileScore> levelScoreList = new ArrayList<>();

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
	 * @param profile The profile that achieved the high score.
	 * @param score The high score.
	 */
	public void updatePlayerScore(Profile profile, int score) {
		boolean profileScoreExists = false;

		for (int i = 0; i < levelScoreList.size(); i++) {
			ProfileScore playerScore = levelScoreList.get(i);
			if (playerScore.getUserUniqueID() == profile.getUniquePlayerID()) {
				profileScoreExists = true;
				if (score > playerScore.getHighestScore()) {
					playerScore.setHighestScore(score);
					levelScoreList.set(i, playerScore);
				}
			}
		}

		if (!profileScoreExists) {
			// Need to check if score is in the top 10 before adding it.
			ProfileScore profileScore = new ProfileScore(score, profile.getUniquePlayerID());
			levelScoreList.add(profileScore);
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
	 * @return the levelScoreList
	 */
	public ArrayList<ProfileScore> getLevelScoreList() {
		return levelScoreList;
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
