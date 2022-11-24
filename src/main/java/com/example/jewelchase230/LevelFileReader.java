package com.example.jewelchase230;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads an ASCII file and converts the data into objects and information needed to make the level.
 */
public class LevelFileReader 
{
    // The lists and variables needed to make the level.
    private static int xAxis;
    private static int yAxis;
    private static int levelTime;
    private static ArrayList<String> tileColours = new ArrayList<>();
    private static ArrayList<Object> objectArray = new ArrayList<>();

    public static void main(String[] args)
    {
        // return values and array lists for them to be placed into the level.
    }
    
    /**
     * Reads the information from the file and processes the values as there needed to be.
     * @param file the file being read.
     */
    private static void lineReader(String file)
    {
        // Tries to read the file and sends an error code if the file does not exist.
        try
        {
            // Sets the values for information about the level.
            File levelFile = new File(file);
            Scanner fileScanner = new Scanner(levelFile);
            xAxis = fileScanner.nextInt();
            yAxis = fileScanner.nextInt();
            levelTime = fileScanner.nextInt();

            // Adds tokens to an array list for the colours of the tiles.
            while (fileScanner.next().length() == 4)
            {
                tileColours.add(fileScanner.next());
            }

            // Makes objects from the provided information.
            while (fileScanner.hasNextLine())
            {
                levelBuilder(fileScanner.nextLine());
            }
        }
        catch (IOException e)
        {
            System.out.println("File not found.");
        }
    }

    /**
     * Makes the objects from the passed information and adds them to an aray list.
     * @param value
     */
    private static void levelBuilder(String value)
    {
        Scanner lineScanner = new Scanner(value);        
        int ID = lineScanner.nextInt();

        // Makes the appropriate object from the ID provided from the file.
        switch(ID)
        {   
            case 1:
                while (lineScanner.next() != "/n")
                {
                    // to-do:
                    // Call Method to create object and add it to the array list.
                    // assign temp variables values to pass as parameters.
                }
                break;
            // to-do:
            // Add future cases when other classes are done.
        }
        
    }

    // Returns the x-axis.
    public static int getXAxis()
    {
        return xAxis;
    }

    // Returns the y-axis.
    public static int getYAxis()
    {
        return yAxis;
    }

    // Returns the time allowed for the level.
    public static int getLevelTime()
    {
        return levelTime;
    }

    // Returns the array list of the tile colours.
    public static ArrayList<String> getTileColours()
    {
        return tileColours;
    }

    // Returns the array list of objects needed for the level.
    public static ArrayList<Object> getObjectArray()
    {
        return objectArray;
    }
}
