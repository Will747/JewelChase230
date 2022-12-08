package com.example.jewelchase230.profiles;

import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Kellie Robinson
 * 
 * High score table per level. Each time level is complete, profile name is recorded
 * for that level along with their score
 * only top 10 
 * 
 * high score table, will  appear at the end of each level and should be navigatable from menu(?)
 * 
 * upon level exit, save user ID, name & score of that level in text file
 * 
 * 
 *
 */

public class HighScoreTable implements Serializable {

	/** The file name of the file that stores all high scores. */
	private static final String FILE_NAME = "HighScores.bin";

	LevelHighScores[] highScores;
	//this should be changed upon the completion of a level in a different class (?) or somehow changed depending on when it is being called
	public int levelNumberCompleted;
	public ArrayList<Integer> highScoresPerLevelx = new ArrayList<Integer>(); 
	public ArrayList<String> highScoreLineByLineData = new ArrayList<String>();
	private Integer uniquePlayerID;
	private String playerName;
	private Integer levelReached;
	private Integer levelScore; 

	/**
	* Constructor of highScoreProfile
	*
	*/
	public HighScoreTable() {
		// Temp until the number of level is decided
		highScores = new LevelHighScores[10];
		//highScores[0] = new LevelHighScores(); <-- commented out as it is throwing an error (?) 
		// Temp until the number of level is decided
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
	 * Adds a new score to the table if it's in the top 10 highest.
	 * @param levelNumber The level number the score was achieved on.
	 * @param profile The profile that achived the score.
	 * @param score The score.
	 */
	public void addScore(int levelNumber, Profile profile, int score) {
		LevelHighScores scores = getLevelHighScores(levelNumber);
		scores.updatePlayerScore(profile, score, levelNumber);
	}

	/**
	 * Gets the scores for a specific level.
	 * @param levelNumber The level number.
	 * @return The highest scores for that level.
	 */
	public LevelHighScores getLevelHighScores(final int levelNumber) {
		if (levelNumber < highScores.length) {
			return highScores[levelNumber];
		}

		return null;
	}

	public void groupHighScoresPerLevelX(int levelNumberCompleted) {
		
		
	}

	/**
	 * @return the highScores
	 */
	public LevelHighScores[] getHighScores() {
		return highScores;
	}

	/**
	 * @param highScores the highScores to set
	 */
	public void setHighScores(LevelHighScores[] highScores) {
		this.highScores = highScores;
	}
}
