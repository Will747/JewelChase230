package com.example.jewelchase230.profiles;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ProfileManager
{
    public void readProfile()
    {
        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
        }

        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
	    } 
    }

    public static void readLines()
    {
        try
        {
            File myFile = new File("Profiles.txt");
            Scanner input = new Scanner(myFile);
            while (input.hasNextLine())
            {
                String data = input.nextLine();
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
    public static void main(final String[] args)
    {
        readLines();
    }
}