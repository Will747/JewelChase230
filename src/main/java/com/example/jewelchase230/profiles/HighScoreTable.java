package com.example.jewelchase230.profiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

public class HighScoreTable {

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
	  public HighScoreTable(Integer uniquePlayerID, String playerName, Integer levelReached, Integer levelScore) {
		  this.uniquePlayerID = uniquePlayerID;
		  this.playerName = playerName; 
		  this.levelReached = levelReached;
		  this.levelScore = levelScore;  
		 
		  
	}
	  
	  /**
	   * Constructor of highScoreProfile
	   * @param lineDataSplit
	   */
	  public HighScoreTable(String[] lineDataSplit) { 
		  uniquePlayerID = Integer.parseInt(lineDataSplit[0]);
		  playerName = lineDataSplit[1]; 
		  levelReached = Integer.parseInt(lineDataSplit[2]);
		  levelScore = Integer.parseInt(lineDataSplit[3]);
		  
	  }
	
	
	
	/**
	 * Reads all data from highscoretable.txt and adds to Array Lists for parsing
	 * 
	 */
	public void readAllHighScoreFromFile() { 
		   try {
	            File myFile = new File("highscoretable.txt");
	            Scanner input = new Scanner(myFile);
	            //print statement for testing
	            System.out.println("readfile");
	            
	            while (input.hasNextLine()) {
	            	//lineCount++;
	                String data = input.nextLine();
	                highScoreLineByLineData.add(data); 
	              
	               String[] lineDataSplit = data.split("\\.",4); 
	               // uniqueIDFromFile = Integer.parseInt(lineDataSplit[0]);
	              
	               
	                
	            }
	            
	            input.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	}
	
	
	/**
	public static void saveScore(Profile profile) throws IOException { 
    	BufferedWriter pmWriter = new BufferedWriter (new FileWriter("Profiles.txt")); 

    	try
        {
    		pmWriter.write(Profile.profileToString(profile));
    		pmWriter.newLine();
    		 for (int i = 0; i < profilesLineByLineData.size(); i++) {
    			 pmWriter.write(profilesLineByLineData.get(i));
    			 
    			 if (i != profilesLineByLineData.size()) { 
    				 pmWriter.newLine();
    			 }
    		 }
    		
    		pmWriter.close();
    		
     
        } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
 	    } 	 
    }
    
    */
	
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
