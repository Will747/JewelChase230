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
	

	// we may need another variable here Integer uniquePlayerID ? depends on how we want to uniquely identify users
	
	public static void main(final String[] args) throws IOException
	{
		//tests to see if functions work

		Profile Nicole = new Profile (1, "P1" , "Nicole", 4, 342);
		Profile Kiwi = new Profile (4, "P4", "FART", 5, 500); 
		
         
		readLines(); 
		System.out.println(profilesLineByLineData);
		saveProfile(Nicole);		
		
		System.out.println("Hi"); 
	}

    

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
              
               String[] lineDataSplit = data.split("\\.",5); 
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
}
