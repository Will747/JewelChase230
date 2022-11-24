package com.example.jewelchase230;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LevelFileReader 
{
    private static int xAxis;
    private static int yAxis;
    private static int levelTime;
    private static ArrayList<String> tileColours = new ArrayList<>();

    public static void main(String[] args)
    {
        // return values needed
    }
    
    private static void lineReader(String file)
    {
        try
        {
            File levelFile = new File(file);
            Scanner fileScanner = new Scanner(levelFile);
            xAxis = fileScanner.nextInt();
            yAxis = fileScanner.nextInt();
            levelTime = fileScanner.nextInt();

            while (fileScanner.next().length() == 4)
            {
                tileColours.add(fileScanner.next());
            }

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

    private static void levelBuilder(String value)
    {
        Scanner lineScanner = new Scanner(value);
        ArrayList<Object> objectArray = new ArrayList<>();
        
        int ID = lineScanner.nextInt();

        switch(ID)
        {   
            case 1:
                // Call Method to create object and add it to the array list.
                break;
            // Add future cases when other classes are done.
        }
        
    }
}
