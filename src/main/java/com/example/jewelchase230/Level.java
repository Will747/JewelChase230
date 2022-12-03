package com.example.jewelchase230;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye and Adam Smith
 */
public class Level {
    /** Tiles on the grid. */
    private final Tile[][] tiles;

    /** All characters in the level. */
    private final ArrayList<Character> characters;

    /** The time limit on the level. */
    private int timeLimit;

    /**
     * Constructs a new level.
     * @param size The size of the level (Num of tiles).
     */
    public Level(final IntVector2D size) {
        tiles = new Tile[size.getX()][size.getY()];
        characters = new ArrayList<>();
    }

    /**
     * Set the time limit for the level.
     * @param inTimeLimit The new time limit for the level.
     */
    public void setTimeLimit(final int inTimeLimit) {
        timeLimit = inTimeLimit;
    }

    /**
     * Gets the time limit for the level.
     * @return The time limit for the level.
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * Adds more time to the time limit.
     * @param additionalTime The time to be added to the time limit.
     */
    public void addTime(final int additionalTime) {
        timeLimit += additionalTime;
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
     * Adds an item to a tile on the level.
     * @param pos Position of tile.
     * @param item The item.
     */
    public void addItem(final IntVector2D pos, final Item item) {
        item.setGridPosition(pos);
        getTile(pos).setItem(item);
    }

    /**
     * Removes an item from a tile.
     * @param pos The tile position to have item removed from.
     */
    public void removeItem(final IntVector2D pos) {
        getTile(pos).setItem(null);
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
     * @param x the x-axis coordinate.
     * @param y the y-axis coordinate.
     * @return The wanted character or null if the character doesn't exist.
     */
    public Character getSpecificCharacter(final int x, final int y) {
        Character wantedCharacter = null;
        for (Character c: characters) {
            IntVector2D cPos = c.getGridPosition();
            if (cPos.getX() == x && cPos.getY() == y) {
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
        Character character = getSpecificCharacter(pos.getX(), pos.getY());
        characters.remove(character);
    }

    /**
     * Method to end the game if the player loses.
     */
    public void gameOver() {
        Main.switchRoot(Menu.getMainMenu());
    }
}
