package com.example.jewelchase230.profiles;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ProfileManager
{
	
	  public static void main(final String[] args)
	    {
	        readLines();
	    }
	  
	  
	  
	  //temporary profile object
	  ProfileManager profile = new ProfileManager(); 
	  
	  

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
    
    public static ProfileManager makeProfile(String[] lineDataSplit) {
    	ArrayList<Integer>profileManagerIntegers = new ArrayList<Integer>(); 
    	for (int i = 0; i < lineDataSplit.length; i++) { 
    		if (i == 2 || i == 3) { 
    			int addInt = Integer.parseInt(lineDataSplit[i]);
    			profileManagerIntegers.add(addInt); 
    		}
    		
    	}
    	ProfileManager profile = new ProfileManager()
    }
    

  
}