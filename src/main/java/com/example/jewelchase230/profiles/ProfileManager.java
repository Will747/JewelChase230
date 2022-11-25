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

	private static int lineCount;
	static ArrayList <String> profilesLineByLineData; 
	static int uniqueIDFromFile;
	

	// we may need another variable here Integer uniquePlayerID ? depends on how we want to uniquely identify users
	
	public static void main(final String[] args) throws IOException
	{
		//tests to see if functions work

		//fix PM -> Profile
		Profile Nicole = new Profile (1, "P1" , "Nicole", 4, 342);
		Profile Kiwi = new Profile (4, "P4", "FART", 5, 500); 
		
        saveProfile(Kiwi); 
		readLines(); 
		
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

    public static void readLines()
    {
    	String[] lineDataSplit = new String[6];

        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            System.out.println("readfile");
            
            while (input.hasNextLine()) {
            	lineCount++;
            	System.out.println(lineCount + " hiii");
                String data = input.nextLine();
                //profilesLineByLineData.add(data); 
                //lineDataSplit = data.split("."); 
                //uniqueIDFromFile = Integer.parseInt(lineDataSplit[0]);
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
    /**
    * Constructs a profile object
    * 
    * @param String[] lineDataSplit
    * @return profile
    */
    
    public static Profile makeProfile(String[] lineDataSplit) {
    
 
    	Profile profile = new Profile(lineDataSplit);
    	return profile;
    }
    
    
    /**
     * Overwrites the Profiles.txt file with updated Profile information
     * 
     * @param ProfileManager profile
     * @throws FileNotFoundException
     */
    
    //rewrite entire textFile -- delete this +++4 lines max 
    
    public static void saveProfile(Profile profile) throws IOException { 
    	FileWriter pmWriter = new FileWriter ("Profiles.txt"); 
    	try
        {
    		for (int i = 0; i <= profilesLineByLineData.size(); i++) { 
    		pmWriter.write(profilesLineByLineData.get(i)); 
    		pmWriter.write(System.lineSeparator());
    		pmWriter.close();
    		}
     
        } catch (FileNotFoundException e)
        {
             System.out.println("An error occurred.");
             e.printStackTrace();
 	    } 	 
    }
}