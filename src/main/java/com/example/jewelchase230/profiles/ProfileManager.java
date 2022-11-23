package com.example.jewelchase230.profiles;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class manages the handling of Profiles, including the .txt files of which
 * Profiles will be written/read from during saving and loading.
 *
 * @author Kellie Robinson
 */

public class ProfileManager
{
	private String playerProfileSlot;
	private String playerName;
	private Integer levelReached;
	private Integer overallScore;
	private Integer uniquePlayerID;
	private static int lineCount;
	static int uniqueIDFromFile;
	

	// we may need another variable here Integer uniquePlayerID ? depends on how we want to uniquely identify users
	  public ProfileManager(Integer uniquePlayerID, String playerProfileSlot, String playerName, Integer levelReached, Integer overallScore) {
		  this.uniquePlayerID = uniquePlayerID;
		  this.playerProfileSlot = playerProfileSlot;
		  this.playerName = playerName; 
		  this.levelReached = levelReached;
		  this.overallScore = overallScore;  
		  
	}

	public static void main(final String[] args) throws IOException
	    {
		//tests to see if functions work 
		ProfileManager Nicole = new ProfileManager (1, "P1" , "Nicole", 4, 342);
		ProfileManager Kiwi = new ProfileManager (4, "P4", "FART", 5, 500); 
		
		readLines(); 
		saveProfile(Kiwi); 
		System.out.println("Hi"); 
	    }
	  
	  
	

	  
	  

    /*
    Opens a text file

    public void readProfile()
    {
        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            input.close();
        }
    
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
	    } 
    }
    */

    // Reads each line of the text file "Profile.txt"
	 /**
     * Reads content from file and stores them appropriately to be handled
     * in the makeProfile method
     * @return lineDataSplit
     * @throws FileNotFoundException
     */
    public static String[] readLines()
    {
    	 String[] lineDataSplit = null;
        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            System.out.println("readfile");
            while (input.hasNextLine()) {
            	lineCount++;
            	System.out.println(lineCount + " " + "hiii");
                String data = input.nextLine();
                lineDataSplit = data.split("."); 
                 uniqueIDFromFile = Integer.parseInt(lineDataSplit[0]);
                //temporary print statement
                System.out.println(data);
            }
            input.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return lineDataSplit;
    }
    /**
     * Constructs a profile object
     * 
     * @param String[] lineDataSplit
     * @return profile
     */
    
    public static ProfileManager makeProfile(String[] lineDataSplit) {
    	
    	ArrayList<Integer>profileManagerIntegers = new ArrayList<Integer>(); 
    	for (int i = 0; i < lineDataSplit.length; i++) { 
    		if (i == 2 || i == 3) { 
    			int addInt = Integer.parseInt(lineDataSplit[i]);
    			profileManagerIntegers.add(addInt); 
    		}
    		
    	}
    	ProfileManager profile = new ProfileManager((lineCount + 1), lineDataSplit[0],lineDataSplit[1],profileManagerIntegers.get(0), profileManagerIntegers.get(1));
    	return profile;
    }
    
    
    /**
     * Overwrites the Profiles.txt file with updated Profile information
     * 
     * @param ProfileManager profile
     * @throws FileNotFoundException
     */
    public static void saveProfile(ProfileManager profile) throws IOException { 
    	 try
         {
    		 FileWriter writeToPlayerFile = new FileWriter ("Profiles.txt");
    		 Scanner input = new Scanner(new File("Profiles.txt"));
    		 StringBuffer buffer = new StringBuffer();
    		 System.out.println("Before While");
    		 while (input.hasNextLine()) {
    			 System.out.println("While");
    			 buffer.append(input.nextLine()+System.lineSeparator());
    			 
    			 if (profile.getUniquePlayerID() == uniqueIDFromFile) { 
        			 System.out.println("If");

    				 String overwrittenData = input.nextLine();
    				 String overwritingData = (profile.getUniquePlayerID() + "." + profile.getPlayerProfileSlot() + "." + profile.getPlayerName() + "." + profile.getLevelReached() + "." +
    						 profile.getOverallScore()); 
    				 String fileContents = buffer.toString();
    				 fileContents = fileContents.replaceAll(overwrittenData, overwritingData);
    				 
    				 writeToPlayerFile.append(fileContents); 
    				 writeToPlayerFile.flush(); 
    				 
    			 }  
             }
    		 
             
             input.close();
         }
     
         catch (FileNotFoundException e)
         {
             System.out.println("An error occurred.");
             e.printStackTrace();
 	    } 
    	 
    }
    


	/**
	 * @return the playerProfileSlot
	 */
	public String getPlayerProfileSlot() {
		return playerProfileSlot;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return the levelReached
	 */
	public Integer getLevelReached() {
		return levelReached;
	}

	/**
	 * @return the overallScore
	 */
	public Integer getOverallScore() {
		return overallScore;
	}

	/**
	 * @param playerProfileSlot the playerProfileSlot to set
	 */
	public void setPlayerProfileSlot(String playerProfileSlot) {
		this.playerProfileSlot = playerProfileSlot;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @param levelReached the levelReached to set
	 */
	public void setLevelReached(Integer levelReached) {
		this.levelReached = levelReached;
	}

	/**
	 * @param overallScore the overallScore to set
	 */
	public void setOverallScore(Integer overallScore) {
		this.overallScore = overallScore;
	}

	/**
	 * @return the uniquePlayerID
	 */
	public Integer getUniquePlayerID() {
		return uniquePlayerID;
	}

	/**
	 * @param uniquePlayerID the uniquePlayerID to set
	 */
	public void setUniquePlayerID(Integer uniquePlayerID) {
		this.uniquePlayerID = uniquePlayerID;
	}
    
    
    

}