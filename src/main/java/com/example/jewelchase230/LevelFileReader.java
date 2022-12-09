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
import com.example.jewelchase230.items.LeverGateColour;
import com.example.jewelchase230.items.LootType;

import com.example.jewelchase230.vectors.IntVector2D;

import java.io.File;
import java.io.IOException;

/**
 * This class reads an ASCII file and converts the data into objects and
 * information needed to make the level.
 *
 * @author Adam Smith.
 */
public final class LevelFileReader {
    /**
     * All types of sprite that can be read from
     * the level file.
     */
    private enum SpriteCode {
        /**
         * Bomb.
         */
        Bomb,
        /**
         * Clock.
         */
        Clock,
        /**
         * Door.
         */
        Door,
        /**
         * Lever.
         */
        Lever,
        /**
         * Gate.
         */
        Gate,
        /**
         * Floor Following Thief.
         */
        FfThief,
        /**
         * Flying Assassin.
         */
        FAssassin,
        /**
         * Loot.
         */
        Loot,
        /**
         * Player.
         */
        Player,
        /**
         * Smart Thief.
         */
        SmartThief;
    }

    /**
     * The level being built.
     */
    private static Level levelBuilt;

    private LevelFileReader() {
    }

    /**
     * Method that is called to start the process of reading in
     * the level ASCII file.
     *
     * @param fileName The name / directory of the file being read in.
     * @param levelNum The number of this level.
     * @return Returns the built level.
     */
    public static Level readInFile(final String fileName, final int levelNum) {
        File levelFile = new File(fileName);
        lineReader(levelFile, levelNum);
        return levelBuilt;
    }

    /**
     * Loads in a specific level based on the level number passed in.
     *
     * @param levelNum The int that is passed to represent the level.
     * @return The level being returned.
     */
    public static Level getLevel(final int levelNum) {
        return readInFile("Level_Files/Level" + levelNum + ".txt", levelNum);
    }

    /**
     * Returns the number of levels the game has.
     *
     * @return the number of levels.
     */
    public static int getMaxLevel() {
        File levelFolder = new File("Level_Files");
        int numLevels = levelFolder.list().length;
        return numLevels;
    }

    /**
     * Reads the information from the file and processes the values as
     * there needed to be.
     *
     * @param levelFile The file being read.
     * @param levelNum  The level number.
     */
    private static void lineReader(final File levelFile, final int levelNum) {
        // Tries to read the file and sends an error code if the file
        // does not exist.
        try {
            // Sets the values for information about the level.
            Scanner fileScanner = new Scanner(levelFile);
            int xAxis = fileScanner.nextInt();
            int yAxis = fileScanner.nextInt();
            int levelTime = fileScanner.nextInt();

            IntVector2D size = new IntVector2D(xAxis, yAxis);
            levelBuilt = new Level(size, levelNum);
            levelBuilt.setTimeLimit(levelTime);

            // Changes the tokens in the text file to tile objects
            // that are added to the level.
            for (int i = 0; i < yAxis; i++) {
                for (int j = 0; j < xAxis; j++) {
                    String tempTileColour = fileScanner.next();

                    int charIdx = 0;
                    TileColour topLeft = TileColour.getTileColourType(
                            tempTileColour.charAt(charIdx));
                    charIdx++;

                    TileColour topRight = TileColour.getTileColourType(
                            tempTileColour.charAt(charIdx));
                    charIdx++;

                    TileColour bottomLeft = TileColour.getTileColourType(
                            tempTileColour.charAt(charIdx));
                    charIdx++;

                    TileColour bottomRight = TileColour.getTileColourType(
                            tempTileColour.charAt(charIdx));

                    Tile tempTile = new
                            Tile(topLeft, topRight, bottomLeft, bottomRight);
                    IntVector2D tempTilePos = new IntVector2D(j, i);
                    levelBuilt.addTile(tempTilePos, tempTile);
                }
            }

            fileScanner.nextLine();
            // Makes objects from the provided information.
            while (fileScanner.hasNextLine()) {
                spriteBuilder(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Makes the objects from the passed information and
     * adds them to an array list.
     *
     * @param value The serialized data.
     */
    private static void spriteBuilder(final String value) {
        Scanner lineScanner = new Scanner(value);
        int id = lineScanner.nextInt();
        // Makes the appropriate object from the id provided from the file.
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        IntVector2D tempPos = new IntVector2D(x, y);
        SpriteCode spriteCode = SpriteCode.values()[id - 1];
        switch (spriteCode) {
            case Bomb -> {
                Bomb tempBomb = new Bomb();
                levelBuilt.addItem(tempPos, tempBomb);
            }
            case Clock -> {
                int time = lineScanner.nextInt();
                Clock tempClock = new Clock(time);
                levelBuilt.addItem(tempPos, tempClock);
            }
            case Door -> {
                Door tempDoor = new Door();
                levelBuilt.addItem(tempPos, tempDoor);
            }
            case Lever -> {
                String colour = lineScanner.next();
                LeverGateColour leverColour =
                        LeverGateColour.colourInputConversion(
                                colour.charAt(0));
                Lever tempLever = new Lever(leverColour);
                levelBuilt.addItem(tempPos, tempLever);
                break;
            }
            case Gate -> {
                String colour = lineScanner.next();
                LeverGateColour gateColour =
                        LeverGateColour.colourInputConversion(
                                colour.charAt(0));
                Gate tempGate = new Gate(gateColour);
                levelBuilt.addItem(tempPos, tempGate);
                break;
            }
            case FfThief -> {
                String directionString = lineScanner.next();
                String colourToFollow = lineScanner.next();
                FloorFollowingThief tempThief = new FloorFollowingThief(
                        Direction.getDirectionType(directionString),
                        TileColour.getTileColourType(
                                colourToFollow.charAt(0)));
                //won't show as no image yet
                levelBuilt.addCharacter(tempPos, tempThief);
            }
            case FAssassin -> {
                String directionString = lineScanner.next();
                FlyingAssassin tempAssassin = new FlyingAssassin(
                        Direction.getDirectionType(directionString));
                levelBuilt.addCharacter(tempPos, tempAssassin);
            }
            case Loot -> {
                int rarity = lineScanner.nextInt();
                Loot tempLoot = new Loot(LootType.getTypeFromInput(rarity));
                levelBuilt.addItem(tempPos, tempLoot);
            }
            case Player -> {
                Player tempPlayer = new Player();
                levelBuilt.addCharacter(tempPos, tempPlayer);
            }
            case SmartThief -> {
                String directionString = lineScanner.next();
                SmartThief tempAssassin = new
                        SmartThief(Direction.getDirectionType(directionString));
                levelBuilt.addCharacter(tempPos, tempAssassin);
            }
            default -> System.out.println("Item id does not exist!");
        }
    }
}
