package com.example.jewelchase230.profiles;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ProfileManager
{
	private String playerProfileSlot;
	private String playerName;
	private Integer levelReached;
	private Integer overallScore;
	

	// we may need another variable here Integer uniquePlayerID ? depends on how we want to uniquely identify users
	  public ProfileManager(String playerProfileSlot, String playerName, Integer levelReached, Integer overallScore) {
		  this.playerProfileSlot = playerProfileSlot;
		  this.playerName = playerName; 
		  this.levelReached = levelReached;
		  this.overallScore = overallScore;  
		  
	}

	public static void main(final String[] args)
	    {
	        readLines();
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
    public static void readLines()
    {
        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            while (input.hasNextLine())
            {
                String data = input.nextLine();
                String[] lineDataSplit = data.split("."); 
                
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
    }
    
    //makes a profile from the lineDataSplit array
    public static ProfileManager makeProfile(String[] lineDataSplit) {
    	ArrayList<Integer>profileManagerIntegers = new ArrayList<Integer>(); 
    	for (int i = 0; i < lineDataSplit.length; i++) { 
    		if (i == 2 || i == 3) { 
    			int addInt = Integer.parseInt(lineDataSplit[i]);
    			profileManagerIntegers.add(addInt); 
    		}
    		
    	}
    	ProfileManager profile = new ProfileManager(lineDataSplit[0],lineDataSplit[1],profileManagerIntegers.get(0), profileManagerIntegers.get(1));
    	return profile;
    }
    
    public void saveProfile(ProfileManager profile) { 
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
    
    public String getplayerProfileSlot(ProfileManager profile) {
    	return this.playerProfileSlot; 
    }
    
    
    public String getPlayerName(ProfileManager profile) {
    	return this.playerName;
    }
    
    public Integer getLevelReacher(ProfileManager profile) {
    	return this.levelReached;
    }
    
    public Integer getOverallScore(ProfileManager profile) { 
    	return this.overallScore;
    }
    
    
    
/// Kiwi: Add setters

}