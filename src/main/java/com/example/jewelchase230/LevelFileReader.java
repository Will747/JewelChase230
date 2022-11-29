package com.example.jewelchase230;

import java.util.Scanner;

import com.example.jewelchase230.vectors.IntVector2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        // Tests that the values are read in correcly.
        levelFileReader("Level_Files/Level1.txt");
        System.out.println(xAxis);
        System.out.println(yAxis);
        System.out.println(levelTime);
        System.out.println(levelBuilt.getAllItems().toString());
    }

    /**
     * Method that is called to start the process of reading in the level ASCII file.
     * @param fileName the name / directory of the file being read in.
     */
    public static void levelFileReader(String fileName){
           File levelFile = new File(fileName);
           lineReader(levelFile);
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
            while (!fileScanner.hasNextInt()) {
                for (int i = 0; i < yAxis - 1; i++){
                    for (int j = 0; j < xAxis - 1; i ++){
                        String tempTileColour = fileScanner.next();
                        TileColour topLeft = TileColour.getTileColourType(tempTileColour.charAt(1));
                        TileColour topRight = TileColour.getTileColourType(tempTileColour.charAt(1));
                        TileColour bottomLeft = TileColour.getTileColourType(tempTileColour.charAt(1));
                        TileColour bottomRight = TileColour.getTileColourType(tempTileColour.charAt(1));
                        Tile tempTile = new Tile(topLeft, topRight, bottomLeft, bottomRight);
                        IntVector2D tempTilePos = new IntVector2D(j, i);
                        levelBuilt.addTile(tempTilePos, tempTile);
                    }
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
        int ID = lineScanner.nextInt();

        // Makes the appropriate object from the ID provided from the file.
        switch (ID) {
            case 1:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int time = lineScanner.nextInt();
                    Bomb tempBomb = new Bomb(x, y, name, fileName, time);
                    levelBuilt.addItem(tempItemPos, tempBomb);
                }
                break;
            }
            case 2:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int time = lineScanner.nextInt();
                    Clock tempClock = new Clock(x, y, name, fileName, time);
                    levelBuilt.addItem(tempItemPos, tempClock);
                }
                break;
            }
            case 3:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    Door tempDoor = new Door(x, y, name, fileName);
                    levelBuilt.addItem(tempItemPos, tempDoor);
                }
                break;
            }
            case 4:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    String colour = lineScanner.next();
                    Lever tempLever = new Lever(x, y, name, fileName, colour);
                    levelBuilt.addItem(tempItemPos, tempLever);
                }
                break;
            }
            case 5:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    String colour = lineScanner.next();
                    Gate tempGate = new Gate(x, y, name, fileName, colour);
                    levelBuilt.addItem(tempItemPos, tempGate);
                }
                break;
            }
            case 6:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String directionString = lineScanner.next();
                    Direction direction = Direction.getDirectionType(directionString);
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    FloorFollowingThief tempThief = new FloorFollowingThief(x, y);
                    // levelBuilt.addNPC(tempItemPos, tempThief);
                }
                break;
            }
            case 7:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String directionString = lineScanner.next();
                    Direction direction = Direction.getDirectionType(directionString);
                    IntVector2D tempNPCPos = new IntVector2D(x, y);
                    FlyingAssassin tempAssassin = new FlyingAssassin(x, y, direction);
                    // LevelBuilt.addNPC(tempItemPos, tempAssassin);
                }
                break;
            }
            case 8:{
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    IntVector2D tempItemPos = new IntVector2D(x, y);
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int rarity = lineScanner.nextInt();
                    Loot tempLoot = new Loot(x, y, name, fileName, rarity);
                    levelBuilt.addItem(tempItemPos, tempLoot);
                }
                break;
            }
            default:{
                System.out.println("Item ID does not exist!");
                break;
            }
        }

    }
}