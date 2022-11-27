package com.example.jewelchase230;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads an ASCII file and converts the data into objects and
 * information needed to make the level.
 */
public class LevelFileReader {
    // The lists and variables needed to make the level.
    private static int xAxis;
    private static int yAxis;
    private static int levelTime;
    private static ArrayList<String> tileColours = new ArrayList<>();
    private static ArrayList<Object> objectArray = new ArrayList<>();

    public static void main(String[] args) {
        // Tests that the values are read in correcly.
        levelFileReader("Level_Files/Level1.txt");
        System.out.println(xAxis);
        System.out.println(yAxis);
        System.out.println(levelTime);
        System.out.println(tileColours.toString());
        System.out.println(objectArray.toString());
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

            // Adds tokens to an array list for the colours of the tiles.
            while (fileScanner.next().length() == 4) {
                tileColours.add(fileScanner.next());
            }

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
            case 1:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int time = lineScanner.nextInt();
                    Bomb tempBomb = new Bomb(x, y, name, fileName, time);
                    objectArray.add(tempBomb);
                }
                break;
            case 2:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int time = lineScanner.nextInt();
                    Clock tempClock = new Clock(x, y, name, fileName, time);
                    objectArray.add(tempClock);
                }
                break;
            case 3:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    Door tempDoor = new Door(x, y, name, fileName);
                    objectArray.add(tempDoor);
                }
                break;
            case 4:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    String colour = lineScanner.next();
                    Lever tempLever = new Lever(x, y, name, fileName, colour);
                    objectArray.add(tempLever);
                }
                break;
            case 5:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    String colour = lineScanner.next();
                    Gate tempGate = new Gate(x, y, name, fileName, colour);
                    objectArray.add(tempGate);
                }
                break;
            case 6:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    FloorFollowingThief tempThief = new FloorFollowingThief(x, y);
                    objectArray.add(tempThief);
                }
                break;
            case 7:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    FlyingAssassin tempAssassin = new FlyingAssassin(x, y);
                    objectArray.add(tempAssassin);
                }
                break;
            case 8:
                while (lineScanner.hasNext()) {
                    int x = lineScanner.nextInt();
                    int y = lineScanner.nextInt();
                    String name = lineScanner.next();
                    String fileName = lineScanner.next();
                    int rarity = lineScanner.nextInt();
                    Loot tempLoot = new Loot(x, y, name, fileName, rarity);
                    objectArray.add(tempLoot);
                }
                break;
            default:
                System.out.println("Item ID does not exist!");
                break;
        }

    }

    // Returns the x-axis.
    public static int getXAxis() {
        return xAxis;
    }

    // Returns the y-axis.
    public static int getYAxis() {
        return yAxis;
    }

    // Returns the time allowed for the level.
    public static int getLevelTime() {
        return levelTime;
    }

    // Returns the array list of the tile colours.
    public static ArrayList<String> getTileColours() {
        return tileColours;
    }

    // Returns the array list of objects needed for the level.
    public static ArrayList<Object> getObjectArray() {
        return objectArray;
    }
}
