package com.example.jewelchase230.profiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kellie Robinson
 *
 * High score table per level. Each time level is complete,
 * profile name is recorded
 * for that level along with their score
 * only top 10
 *
 * high score table, will  appear at the end of each level and should
 * be navigatable from menu(?)
 *
 * upon level exit, save user ID, name & score of that level in text file
 */

public class HighScoreTable implements Serializable {

	/** The file name of the file that stores all high scores. */
	private static final String FILE_NAME = "HighScores.bin";

	/** Scores for each level. */
	private ArrayList<LevelHighScores> highScores;

	/**
	* Constructor of HighScoreTable.
	*/
	public HighScoreTable() {
		read();
	}

	/**
	 * Constructs a high score table with data from the
	 * high score file.
	 * @return The high score table.
	 */
	public static HighScoreTable read() {
		try {
			FileInputStream fileInputStream = new
					FileInputStream(FILE_NAME);
			ObjectInputStream objectInputStream = new
					ObjectInputStream(fileInputStream);

			HighScoreTable result = (HighScoreTable)
					objectInputStream.readObject();

			objectInputStream.close();
			fileInputStream.close();

			return result;
		} catch (Exception e) {
			System.out.println("Failed to load high scores table");
			System.out.println("Created new blank one instead");
		}

		return new HighScoreTable();
	}

	/**
	 * Overwrites the existing high score file with the
	 * state of this object.
	 * @return True if successful
	 */
	public boolean save() {
		try {
			FileOutputStream fileOutputStream = new
					FileOutputStream(FILE_NAME);
			ObjectOutputStream objectOutputStream = new
					ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(this);

			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("Failed to save high scores!");
			return false;
		}

		return true;
	}

	/**
	 * Adds a new score to the table.
	 * @param levelNumber The level number the score was achieved on.
	 * @param profile The profile that achieved the score.
	 * @param score The score.
	 */
	public void addScore(
			final int levelNumber,
			final Profile profile,
			final int score) {
		LevelHighScores scores = getLevelHighScores(levelNumber);
		scores.updatePlayerScore(profile, score);
	}

	/**
	 * Gets the scores for a specific level.
	 * @param levelNumber The level number.
	 * @return The highest scores for that level.
	 */
	public LevelHighScores getLevelHighScores(final int levelNumber) {
		// Search for existing high scores for this level.
		for (LevelHighScores level : highScores) {
			if (level.getLevelNumber() == levelNumber) {
				return level;
			}
		}

		// If none exist create new LevelHighScores
		LevelHighScores levelHighScores =
				new LevelHighScores(levelNumber);
		highScores.add(levelHighScores);
		return levelHighScores;
	}

	/**
	 * @return All highScores.
	 */
	public ArrayList<LevelHighScores> getHighScores() {
		return highScores;
	}
}
