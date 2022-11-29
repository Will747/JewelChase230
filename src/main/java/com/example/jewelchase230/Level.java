package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye
 */
public class Level {
    /** Tiles on the grid. */
    private Tile[][] tiles;
    private ArrayList<Character> characters;

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

        addItem(new IntVector2D(0, 0), new Bomb(1));
        /* End of Temp random tile creator. */

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
        int numOfRenderables = numOfTiles + allItems.size();
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

        return result;
    }

    /**
     * Adds characters to the level.
     * @param character the character being added.
     */
    public void addCharacter(Character character){
        characters.add(character);
    }

    public ArrayList<Character> getAllCharacters(){
        return characters;
    }

}
