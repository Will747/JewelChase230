package com.example.jewelchase230;
import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.characters.Player;
import com.example.jewelchase230.items.Bomb;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.items.Loot;
import com.example.jewelchase230.items.Lever;
import com.example.jewelchase230.items.Door;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileImage;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.Parent;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye, Adam Smith and Ben Stott.
 */
public class Level implements Serializable {
    /** Tiles on the grid. */
    private final Tile[][] tiles;

    /** All characters in the level. */
    private final ArrayList<Character> characters;

    /** The level number. */
    private final int levelNumber;

    /** The time limit on the level. */
    private int timeLeftInMilliseconds;

    /** The current score. */
    private int playerScore;

    /** The profile of the player playing the game. */
    private transient Profile currentProfile;

    /** Time left score multiplyer when level is complete. */
    private static final int TIME_LEFT_SCORE_MULTIPLYER = 5;

    /**
     * Constructs a new level.
     * @param size The size of the level (Num of tiles).
     * @param inLevelNumber The level number.
     */
    public Level(final IntVector2D size, final int inLevelNumber) {
        tiles = new Tile[size.getX()][size.getY()];
        characters = new ArrayList<>();
        levelNumber = inLevelNumber;
    }

    /**
     * Set the time limit for the level.
     * @param inTimeLimit The new time limit for the level.
     */
    public void setTimeLimit(final int inTimeLimit) {
        timeLeftInMilliseconds = inTimeLimit * Main.MILLISECONDS_IN_A_SECOND;
    }

    /**
     * Gets the time limit for the level.
     * @return The time limit for the level.
     */
    public int getTime() {
        return timeLeftInMilliseconds;
    }

    /**
     * Adds more time to the time limit.
     * @param additionalTime The time to be added to the time limit.
     */
    public void addTime(final int additionalTime) {
        timeLeftInMilliseconds += additionalTime;
    }

    /**
     * When level is complete, additional score added for time left.
     */
    public void addTimeLeftScore() {
        incrementPlayerScore(
            (timeLeftInMilliseconds / Main.MILLISECONDS_IN_A_SECOND)
                * TIME_LEFT_SCORE_MULTIPLYER);
        System.out.println("Final score: " + playerScore); //temporary
    }

    /**
     * Adds a new tile to the level, replacing any existing tile
     * in same position.
     * @param pos Position of tile on grid.
     * @param tile The tile.
     */
    public void addTile(final IntVector2D pos, final Tile tile) {
        tile.setGridPosition(pos);
        tiles[pos.getX()][pos.getY()] = tile;
    }

    /**
     * Should be called whenever a character is moved so that
     * the tile can be checked for collisions with items or
     * other characters.
     * @param movingCharacter The character moving to a new position.
     * @param newPos The position the character is moving to.
     */
    public void onCharacterMove(final Character movingCharacter,
                                final IntVector2D newPos) {
        Tile tile = getTile(newPos);
        Character collidingCharacter = getSpecificCharacter(newPos);

        tile.onCollision(movingCharacter);

        if (collidingCharacter != null) {
            collidingCharacter.onCollision(movingCharacter);
        }
    }

    /**
     * Checks if all loot and levers have been collected and opens the
     * door if they have.
     */
    public void checkIfDoorOpen() {
        ArrayList<Lever> leverArray = getAllItemsOfType(Lever.class);
        ArrayList<Loot> lootArray = getAllItemsOfType(Loot.class);
        for (Lever leverInstance : leverArray) {
            if (!(leverInstance.hasExploded())) {
                return;
            }
        }
        for (Loot lootInstance : lootArray) {
            if (!(lootInstance.hasExploded())) {
                return;
            }
        }
        ArrayList<Door> doorArray =
        getAllItemsOfType(Door.class);
        for (Door doorInstance : doorArray) {
             doorInstance.openDoor();
        }
    }

    /**
     * Adds an item to a tile on the level.
     * @param pos Position of tile.
     * @param item The item.
     */
    public void addItem(final IntVector2D pos, final Item item) {
        item.setGridPosition(pos);
        getTile(pos).setItem(item);
        if (item instanceof Bomb) {
            ArrayList<Tile> neighbouringTiles =
                    getNeighbouringTiles(item.getGridPosition());
            for (Tile neighbouringTile : neighbouringTiles) {
                neighbouringTile.setBombTrigger(pos);
            }
        }
    }

    /**
     * Finds all tiles around a certain position.
     * @param position The centre tile.
     * @return ArrayList of the tiles around the centre tile.
     */
    public ArrayList<Tile> getNeighbouringTiles(final IntVector2D position) {
        ArrayList<Tile> tileArray = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!(x == 0 && y == 0)) {
                    IntVector2D tempVtr = position.add(new IntVector2D(x, y));
                    if (checkTileExists(tempVtr)) {
                        tileArray.add(getTile(tempVtr));
                    }
                }
            }
        }
        return tileArray;
    }

    /**
     * Removes an item from a tile.
     * @param pos The tile position to have item removed from.
     */
    public void removeItem(final IntVector2D pos) {
        Item item = getItem(pos);
        if (item instanceof Bomb) {
            ArrayList<Tile> neighbouringTiles =
                    getNeighbouringTiles(item.getGridPosition());
            for (Tile tileInstance: neighbouringTiles) {
                tileInstance.removeBombTrigger(pos);
            }
        }
        getTile(pos).setItem(null);
        if (item instanceof Loot || item instanceof Lever) {
            checkIfDoorOpen();
        }
    }

    /**
     * Gets a tile a specific coordinate on grid.
     * @param pos Position of tile.
     * @return The tile.
     */
    public Tile getTile(final IntVector2D pos) {
        return tiles[pos.getX()][pos.getY()];
    }

    /**
     * Checks that a position is a valid tile in the current level.
     * @param posToCheck The tile position to check is valid.
     * @return True if valid, false if not.
     */
    public boolean checkTileExists(final IntVector2D posToCheck) {
        IntVector2D maxSize = getLevelSize();
        return posToCheck.getX() < maxSize.getX()
                && posToCheck.getY() < maxSize.getY()
                && posToCheck.getX() >= 0
                && posToCheck.getY() >= 0;
    }

    /**
     * Gets the item at a position on the grid.
     * @param pos Position on the grid.
     * @return The item or null if none exist.
     */
    public Item getItem(final IntVector2D pos) {
        return tiles[pos.getX()][pos.getY()].getItem();
    }

    /**
     * Gets all items of a particular type on the grid.
     * @param type The class type.
     * @return List of items.
     * @param <T> The type of items to return.
     */
    public <T extends Item> ArrayList<T> getAllItemsOfType(
            final Class<T> type) {
        ArrayList<T> items = new ArrayList<>();

        for (Tile[] tileRow : tiles) {
            for (Tile tile : tileRow) {
                Item item = tile.getItem();
                if (type.isInstance(item)) {
                    items.add(type.cast(item));
                }
            }
        }

        return items;
    }

    /**
     * @return All items on the grid.
     */
    public ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();

        for (Tile[] tileRow : tiles) {
            for (Tile tile : tileRow) {
                if (tile.getItem() != null) {
                    items.add(tile.getItem());
                }
            }
        }

        return items;
    }

    /**
     * Gets the size of the level in terms of tiles.
     * @return The dimensions of the level.
     */
    public IntVector2D getLevelSize() {
        return new IntVector2D(tiles.length, tiles[0].length);
    }

    /**
     * Anything in the level that needs rendering.
     * @return All renderable objects.
     */
    public Renderable[] getRenderables() {
        ArrayList<Item> allItems = getAllItems();

        int numOfTiles = tiles.length * tiles[0].length;
        int numOfRenderables = numOfTiles + allItems.size() + characters.size();
        Renderable[] result = new Renderable[numOfRenderables];
        int count = 0;

        // Add tiles
        for (Tile[] tileRow : tiles) {
            for (Tile tile : tileRow) {
                result[count] = tile;
                count++;
            }
        }

        // Add items
        for (Item item : allItems) {
            result[count] = item;
            count++;
        }

        //add characters
        for (Character character : characters) {
            result[count] = character;
            count++;
        }

        return result;
    }

    /**
     * Adds characters to the level.
     * @param pos The position of the character.
     * @param character The character being added.
     */
    public void addCharacter(final IntVector2D pos, final Character character) {
        character.setGridPosition(pos);
        characters.add(character);
    }

    /**
     * Returns the array list of characters in the level.
     * @return the array list of characters.
     */
    public ArrayList<Character> getAllCharacters() {
        return characters;
    }

    /**
     * Gets the current player in the level.
     * @return The current player.
     */
    public Player getPlayer() {
        for (Character characterInstance : characters) {
            if (characterInstance instanceof Player) {
                return ((Player) characterInstance);
            }
        }
        return null;
    }

    /**
     * Gets a specific character in the level.
     * @param pos The position of the character on the grid.
     * @return The wanted character or null if the character doesn't exist.
     */
    public Character getSpecificCharacter(final IntVector2D pos) {
        Character wantedCharacter = null;
        for (Character c: characters) {
            IntVector2D cPos = c.getGridPosition();
            if (cPos.equals(pos)) {
                wantedCharacter =  c;
            }
        }
        return wantedCharacter;
    }

    /**
     * Removes a specific Character from the game.
     * @param pos The position on the grid the character is on.
     */
    public void removeSpecificNPC(final IntVector2D pos) {
        Character character = getSpecificCharacter(pos);
        characters.remove(character);
    }

    /**
     * Called just before the grid gets re-rendered.
     * @param time Time in milliseconds since last frame.
     */
    public void tick(final int time) {
        timeLeftInMilliseconds -= time;
        if (timeLeftInMilliseconds <= 0) {
            gameOver();
        }
    }

    /**
     * Method to end the game if the player loses.
     */
    public void gameOver() {
        Parent gameOverMenu = Menu.getGameOverMenu();
        Main.switchRoot(gameOverMenu);
        Menu.getGameOverMenuController().setLevelLost(this);
    }

    /**
     * @return The level number.
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * @return The current player score.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Increases the players score.
     * @param value Amount to increase by.
     */
    public void incrementPlayerScore(final int value) {
        playerScore += value;
    }

    /**
     * Sets the profile playing this level.
     * @param inCurrentProfile The player's profile.
     */
    public void setProfile(final Profile inCurrentProfile) {
        currentProfile = inCurrentProfile;
        ProfileImage catCharacter = currentProfile.getCatCharacter();
        Player player = getPlayer();
        player.setImageFromFile(catCharacter.getRight());
        player.setFacingLeftImage(catCharacter.getLeft());
        player.setFacingRightImage(catCharacter.getRight());
    }

    /**
     * @return The profile of the player playing this level.
     */
    public Profile getCurrentProfile() {
        return currentProfile;
    }

    /**
     * Saves the current state of the level to a file.
     */
    public void saveGame() {
        String saveFile = currentProfile.getSaveGamePath();
        try {
            FileOutputStream fileOutputStream = new
                    FileOutputStream(saveFile);
            ObjectOutputStream objectOutputStream = new
                    ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to save game, couldn't write to file!");
        } catch (IOException e) {
            System.out.println("Failed to save game!");
        }
    }
}
