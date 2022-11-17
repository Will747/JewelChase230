package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Represents a game level, including all tiles, items and characters.
 *
 * @author Will Kaye
 */
public class Level {
    /**
     * Gets the size of the level in terms of tiles.
     * @return The dimensions of the level.
     */
    public IntVector2D getLevelSize() {
        /* TODO: This should return the dimensions of the tile array. */
        return new IntVector2D(16,9);
    }

    /**
     * Anything in the level that needs rendering.
     * @return All renderable objects.
     */
    public Renderable[] getRenderables() {
        /* TODO: This should create an array of all tiles, items, characters. */

        /* Temp Test */
        Renderable[] demoResult = new Renderable[144];

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 9; y++) {
                demoResult[x+16*y] = new TestRenderable(x, y);
            }
        }

        return demoResult;
        /* End of Temp Test */
    }
}
