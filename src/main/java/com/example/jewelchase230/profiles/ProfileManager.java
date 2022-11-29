package com.example.jewelchase230.profiles;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

	private static int lineCount;
	static ArrayList <String> profilesLineByLineData = new ArrayList<String>(); 
	static int uniqueIDFromFile;
	public static final int LINEBYLINEDATA_I = 4; 
	

	
    // Reads each line of the text file "Profile.txt"
	/**
    * Reads content from file and stores them appropriately to be handled
    * in the makeProfile method
    * @return lineDataSplit
    * @throws FileNotFoundException
    */

    public static void readLines() {
        try {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            //print statement for testing
            System.out.println("readfile");
            
            while (input.hasNextLine()) {
            	lineCount++;
                String data = input.nextLine();
                profilesLineByLineData.add(data); 
              
               String[] lineDataSplit = data.split("\\.",4); 
                uniqueIDFromFile = Integer.parseInt(lineDataSplit[0]);
                
                System.out.println(lineCount);
            }
            
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
   
    
    
    /**
     * Overwrites the Profiles.txt file with updated Profile information
     * 
     * @param ProfileManager profile
     * @throws FileNotFoundException
     */
       
    public static void saveProfile(Profile profile) throws IOException { 
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



	/**
	 * @return the profilesLineByLineData
	 */
	public static ArrayList<String> getProfilesLineByLineData() {
		return profilesLineByLineData;
	}



	/**
	 * @return the linebylinedataI
	 */
	public static int getLinebylinedataI() {
		return LINEBYLINEDATA_I;
	}
}
