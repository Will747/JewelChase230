package com.example.jewelchase230;

import java.util.Scanner;

import com.example.jewelchase230.characters.FloorFollowingThief;
import com.example.jewelchase230.characters.FlyingAssassin;
import com.example.jewelchase230.characters.Player;
import com.example.jewelchase230.characters.SmartThief;

import com.example.jewelchase230.items.Bomb;
import com.example.jewelchase230.items.Loot;
import com.example.jewelchase230.items.Clock;
import com.example.jewelchase230.items.Door;
import com.example.jewelchase230.items.Lever;
import com.example.jewelchase230.items.Gate;

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
    /** X Axis. */
    private static int xAxis;
    /** Y Axis. */
    private static int yAxis;
    /** Level time. */
    private static int levelTime;
    private static Level levelBuilt;


    /**
     * Method that is called to start the process of reading in
     * the level ASCII file.
     * @param fileName the name / directory of the file being read in.
     * @return Returns the built level.
     */
    public static Level readInFile(final String fileName, int levelNum) {
           File levelFile = new File(fileName);
           lineReader(levelFile, levelNum);
           return levelBuilt;
    }

    /**
     * Loads in a specific level based on a int passed in.
     * @param l The int that is passed to represent the level.
     */
    public static Level getLevel(int l) {
        switch (l) {
            case 1:
                return readInFile("Level_Files/Level1.txt", 1);
            case 2:
                 return readInFile("Level_Files/Level2.txt", 2);
            case 3:
                return readInFile("Level_Files/Level3.txt", 3);
            case 4:
                return readInFile("Level_Files/Level4.txt", 4);
            case 5:
                return readInFile("Level_Files/Level5.txt", 5);
            default:
                return readInFile("Level_Files/Level6.txt", 1);
        }
    }

    /**
     * Returns the number of levels the game has.
     * @return the number of levels.
     */
    public static int getMaxLevel(){
        File levelFolder = new File("Level_Files");
        int numLevels = levelFolder.list().length;
        return numLevels;
    }

    /**
     * Reads the information from the file and processes the values as
     * there needed to be.
     * @param levelFile the file being read.
     */
    private static void lineReader(final File levelFile, int levelNum) {
        // Tries to read the file and sends an error code if the file
        // does not exist.
        try {
            // Sets the values for information about the level.
            Scanner fileScanner = new Scanner(levelFile);
            xAxis = fileScanner.nextInt();
            yAxis = fileScanner.nextInt();
            levelTime = fileScanner.nextInt();
            System.out.println(levelTime);

            IntVector2D size = new IntVector2D(xAxis, yAxis);
            levelBuilt = new Level(size, levelNum);
            levelBuilt.setTimeLimit(levelTime);

            // Changes the tokens in the text file to tile objects
            // that are added to the level.
            for (int i = 0; i < yAxis; i++) {
                 for (int j = 0; j < xAxis; j++) {
                     String tempTileColour = fileScanner.next();
                     TileColour topLeft = TileColour.getTileColourType(
                             tempTileColour.charAt(0));
                     TileColour topRight = TileColour.getTileColourType(
                             tempTileColour.charAt(1));
                     TileColour bottomLeft = TileColour.getTileColourType(
                             tempTileColour.charAt(2));
                     TileColour bottomRight = TileColour.getTileColourType(
                             tempTileColour.charAt(3));
                     Tile tempTile = new
                             Tile(topLeft, topRight, bottomLeft, bottomRight);
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
     * Makes the objects from the passed information and
     * adds them to an array list.
     * @param value
     */
    private static void levelBuilder(final String value) {
        Scanner lineScanner = new Scanner(value);
        int id = lineScanner.nextInt();
        // Makes the appropriate object from the id provided from the file.
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        IntVector2D tempPos = new IntVector2D(x, y);
        switch (id) {
            case 1: { //Bomb
                    Bomb tempBomb = new Bomb();
                    levelBuilt.addItem(tempPos, tempBomb);
                break;
            }
            case 2: { //Clock
                    int time = lineScanner.nextInt();
                    Clock tempClock = new Clock(time);
                    levelBuilt.addItem(tempPos, tempClock);
                break;
            }
            case 3: { //Door
                    Door tempDoor = new Door();
                    levelBuilt.addItem(tempPos, tempDoor);
                break;
            }
            case 4: { //Lever
                    String colour = lineScanner.next();
                    Lever tempLever = new Lever(colour);
                    levelBuilt.addItem(tempPos, tempLever);
                break;
            }
            case 5: { //Gate
                    String colour = lineScanner.next();
                    Gate tempGate = new Gate(colour);
                    levelBuilt.addItem(tempPos, tempGate);
                break;
            }
            case 6: { //Floor Following Thief
                    String directionString = lineScanner.next();
                    String colourToFollow = lineScanner.next();
                    FloorFollowingThief tempThief = new FloorFollowingThief(
                            Direction.getDirectionType(directionString),
                            TileColour.getTileColourType(
                                    colourToFollow.charAt(0)));
                    //won't show as no image yet
                    levelBuilt.addCharacter(tempPos, tempThief);
                break;
            }
            case 7: { //Flying Assassin
                    String directionString = lineScanner.next();
                    FlyingAssassin tempAssassin = new FlyingAssassin(
                            Direction.getDirectionType(directionString));
                    levelBuilt.addCharacter(tempPos, tempAssassin);
                break;
            }
            case 8: { //Loot
                    int rarity = lineScanner.nextInt();
                    Loot tempLoot = new Loot(rarity);
                    levelBuilt.addItem(tempPos, tempLoot);
                break;
            }
            case 9: { //Player
                Player tempPlayer = new Player();
                levelBuilt.addCharacter(tempPos, tempPlayer);
            break;
            }
            case 10: { //Smart Thief
                String directionString = lineScanner.next();
                SmartThief tempAssassin = new
                        SmartThief(Direction.getDirectionType(directionString));
                levelBuilt.addCharacter(tempPos, tempAssassin);
            break;
        }
            default:
                System.out.println("Item id does not exist!");
                break;
        }
    }
}
