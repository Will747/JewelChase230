package com.example.jewelchase230;

import java.util.Scanner;

import com.example.jewelchase230.items.*;
import com.example.jewelchase230.vectors.IntVector2D;

import java.io.File;
import java.io.IOException;

/**
 * This class reads an ASCII file and converts the data into objects and
 * information needed to make the level.
 * @author Adam Smith.
 */
public class LevelFileReader {
    // The lists and variables needed to make the level.
    private static int xAxis;
    private static int yAxis;
    private static int levelTime;
    private static Level levelBuilt;


    /**
     * Method that is called to start the process of reading in the level ASCII file.
     * @param fileName the name / directory of the file being read in.
     */

    public static Level readInFile(String fileName){
           File levelFile = new File(fileName);
           lineReader(levelFile);
           return levelBuilt;
    }

    /**
     * Reads the information from the file and processes the values as there needed
     * to be.
     * 
     * @param file the file being read.
     */
    private static void lineReader(File levelFile) {
        // Tries to read the file and sends an error code if the file does not exist.
        try {
            // Sets the values for information about the level.
            Scanner fileScanner = new Scanner(levelFile);
            xAxis = fileScanner.nextInt();
            yAxis = fileScanner.nextInt();
            levelTime = fileScanner.nextInt();

            IntVector2D size = new IntVector2D(xAxis, yAxis);
            levelBuilt = new Level(size);

            // Changes the tokens in the text file to tile objects that are added to the level.
            for (int i = 0; i < yAxis; i++){
                 for (int j = 0; j < xAxis; j++){
                     String tempTileColour = fileScanner.next();
                     System.out.println(tempTileColour);
                     TileColour topLeft = TileColour.getTileColourType(tempTileColour.charAt(0));
                     TileColour topRight = TileColour.getTileColourType(tempTileColour.charAt(1));
                     TileColour bottomLeft = TileColour.getTileColourType(tempTileColour.charAt(2));
                     TileColour bottomRight = TileColour.getTileColourType(tempTileColour.charAt(3));
                     Tile tempTile = new Tile(topLeft, topRight, bottomLeft, bottomRight);
                     IntVector2D tempTilePos = new IntVector2D(j, i);
                     levelBuilt.addTile(tempTilePos, tempTile);
                 }
            }

             fileScanner.nextLine();       
            // Makes objects from the provided information.
            while (fileScanner.hasNextLine()) {
                levelBuilder(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Makes the objects from the passed information and adds them to an aray list.
     * 
     * @param value
     */
    private static void levelBuilder(String value) {
        Scanner lineScanner = new Scanner(value);
        System.out.println(value);
        int ID = lineScanner.nextInt();

        // Makes the appropriate object from the ID provided from the file.
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        IntVector2D tempPos = new IntVector2D(x, y);
        switch (ID) {
            case 1:{
                    Bomb tempBomb = new Bomb();
                    levelBuilt.addItem(tempPos, tempBomb);
                break;
            }
            case 2:{
                    int time = lineScanner.nextInt();
                    Clock tempClock = new Clock(time);
                    levelBuilt.addItem(tempPos, tempClock);
                break;
            }
            case 3:{
                    Door tempDoor = new Door();
                    levelBuilt.addItem(tempPos, tempDoor);
                break;
            }
            case 4:{
                    String colour = lineScanner.next();
                    Lever tempLever = new Lever(colour);
                    levelBuilt.addItem(tempPos, tempLever);
                break;
            }
            case 5:{
                    String colour = lineScanner.next();
                    Gate tempGate = new Gate(colour);
                    levelBuilt.addItem(tempPos, tempGate);
                break;
            }
            case 6:{
                    String directionString = lineScanner.next();
                    Direction direction = Direction.getDirectionType(directionString);
                    FloorFollowingThief tempThief = new FloorFollowingThief();
                    // levelBuilt.addNPC(tempItemPos, tempThief);
                break;
            }
            case 7:{
                    String directionString = lineScanner.next();
                    Direction direction = Direction.getDirectionType(directionString);
                    IntVector2D tempNPCPos = new IntVector2D(x, y);
                    FlyingAssassin tempAssassin = new FlyingAssassin(direction);
                    // LevelBuilt.addNPC(tempItemPos, tempAssassin);
                break;
            }
            case 8:{
                    int rarity = lineScanner.nextInt();
                    Loot tempLoot = new Loot();
                    levelBuilt.addItem(tempPos, tempLoot);
                break;
            }
            default:{
                System.out.println("Item ID does not exist!");
                break;
            }
        }

    }
}