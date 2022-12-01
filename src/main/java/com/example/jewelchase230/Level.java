package com.example.jewelchase230;
import com.example.jewelchase230.items.*;
import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye and Adam Smith
 */
public class Level {
    /** Tiles on the grid. */
    private Tile[][] tiles;

    /** All characters in the level. */
    private ArrayList<Character> characters;

    /** The time limit on the level. */
    private int timeLimit;

    /**
     * Constructs a new level.
     * @param size The size of the level (Num of tiles).
     */
    public Level(final IntVector2D size) {
        tiles = new Tile[size.getX()][size.getY()];
        characters = new ArrayList<>();

        /* Temp random tile creator. */
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {

                // Randomly pick a colours
                TileColour[] colours = new TileColour[4];
                for (int i = 0; i < 4; i++) {
                    Random random = new Random();
                    colours[i] = switch (random.nextInt(4)) {
                        case 1 -> TileColour.Red;
                        case 2 -> TileColour.Green;
                        case 3 -> TileColour.Blue;
                        default -> TileColour.Yellow;
                    };
                }

                Tile randomTile = new Tile(
                        colours[0], colours[1], colours[2], colours[3]);
                addTile(new IntVector2D(x, y), randomTile);
            }
        }

        addCharacter(new IntVector2D(3, 0), new Player());
        addCharacter(new IntVector2D(4,0), new FlyingAssassin(Direction.RIGHT));

        addItem(new IntVector2D(0, 0), new Bomb(1));
        addItem(new IntVector2D(1, 0), new Clock(1));
        addItem(new IntVector2D(2, 0), new Lever("Red"));

        // Fill remaining tiles with loot to test randomness.
        for (int i = 4; i < size.getX(); i++) {
            addItem(new IntVector2D(i, 0), new Loot());
        }
        /* End of Temp random tile creator. */

    }

    /**
     * Set the time limit for the level.
     * @param inTimeLimit The new time limit for the level.
     */
    public void setTimeLimit(int inTimeLimit) {
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
    public void addTime(int additionalTime) {
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
     * @param character the character being added.
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
    public Character getSpecificCharacter(int x, int y) {
        Character wantedCharacter = null;
        for (Character c: characters) {
            if (c.getGridPosition().getX() == x && c.getGridPosition().getY() == y) {
                wantedCharacter =  c;
            }
        }
        return wantedCharacter;
    }
}
