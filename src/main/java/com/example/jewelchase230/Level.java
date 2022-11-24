package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye
 */
public class Level {
    /** Tiles on the grid. */
    private Tile[][] tiles;

    /**
     * Constructs a new level.
     * @param size The size of the level (Num of tiles).
     */
    public Level(final IntVector2D size) {
        tiles = new Tile[size.getX()][size.getY()];

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

                tiles[x][y] =
                        new Tile(new IntVector2D(x,y), colours[0], colours[1], colours[2], colours[3]);
            }
        }


        /* End of Temp random tile creator. */
    }

    /**
     * Gets the size of the level in terms of tiles.
     * @return The dimensions of the level.
     */
    public IntVector2D getLevelSize() {
        return new IntVector2D(tiles.length, tiles[0].length);
    }

    /**
     * Gets a tile a specific coordinate on grid.
     * @param pos Position of tile
     * @return The tile.
     */
    public Tile getTile(final IntVector2D pos) {
        return tiles[pos.getX()][pos.getY()];
    }

    /**
     * Anything in the level that needs rendering.
     * @return All renderable objects.
     */
    public Renderable[] getRenderables() {
        int numOfRenderables = tiles.length * tiles[0].length;
        Renderable[] result = new Renderable[numOfRenderables];

        int count = 0;

        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                result[count] = tiles[x][y];
                count++;
            }
        }

        return result;
    }
}
