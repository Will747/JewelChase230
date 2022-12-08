package com.example.jewelchase230.profiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * This class will manage player High Scores for a specific level.
 *
 * @author Kellie Robinson
 *
 */
public class LevelHighScores implements Serializable {
	/** ArrayList holds scores of all players from all levels. */
	private ArrayList<ProfileScore> scoreList = new ArrayList<>();

	/** The number of the level this holds scores for. */
	private int levelNumber;

	/** final integer defining the amount of top players. */
	private static final int LEGAL_HIGH_SCORE_NUM = 10;

	/**
	 * Constructs a new LevelHighScores.
	 * @param inLevelNumber The level number.
	 */
	public LevelHighScores(final int inLevelNumber) {
		levelNumber = inLevelNumber;
	}

	/**
	 * Method which searches the ArrayList of profiles scores and checks
	 * alongside Profile and PlayerScore to check if the player's current
	 * level score is a new high score. If the high score is beaten, the
	 * profileScore is updated. If no high score exists for this profile
	 * on this level, it is recorded.
	 *
	 * @param profile The profile that achieved the high score.
	 * @param score   The high score.
	 */
	public void updatePlayerScore(final Profile profile, final int score) {
		boolean profileScoreExists = false;

		for (int i = 0; i < scoreList.size(); i++) {
			ProfileScore playerScore = scoreList.get(i);
			if (playerScore.getUserUniqueID()
					== profile.getUniquePlayerID()) {
				profileScoreExists = true;
				if (score > playerScore.getHighestScore()) {
					playerScore.setHighestScore(score);
					scoreList.set(i, playerScore);
				}
			}
		}

		if (!profileScoreExists) {
			ProfileScore profileScore =
					new ProfileScore(score, profile);
			scoreList.add(profileScore);
		}
	}

	/**
	 * @return the levelScoreList
	 */
	public ArrayList<ProfileScore> getScoreList() {
		return scoreList;
	}

	/**
	 * @return the topTenHighScores
	 */
	public ProfileScore[] getTopTenHighScores() {
		scoreList.sort(
			(x, y) ->
			x.getHighestScore() > y.getHighestScore() ? 1 : 0);

		ProfileScore[] scores = new ProfileScore[LEGAL_HIGH_SCORE_NUM];
		for (int i = 0; i < LEGAL_HIGH_SCORE_NUM; i++) {
			scores[i] = scoreList.get(i);
		}

		return scores;
	}

	/**
	 * @return The level that the scores are from.
	 */
	public int getLevelNumber() {
		return levelNumber;
	}
}
