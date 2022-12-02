package com.example.jewelchase230;

import com.example.jewelchase230.vectors.DoubleVector2D;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * A component that ticks and can be rendered onto the level
 * grid.
 *
 * @author Will Kaye
 */
public abstract class Renderable {
    /**
     * The percentage of the canvas that must be left blank
     * around the edges.
     */
    private static final double BORDER_PERCENTAGE = 0.05;

    /** Position in the level item should be rendered to. */
    private IntVector2D gridPosition;

    /** Position of a neighbouring bomb, null if no bomb. */
    private IntVector2D bombPosition;

    /**
     * Constructs a renderable component.
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Renderable(final int x, final int y) {
        gridPosition = new IntVector2D(x, y);
    }

    /**
     * Constructs a renderable component.
     * @param pos Position of component on grid.
     */
    public Renderable(final IntVector2D pos) {
        gridPosition = pos;
    }

    /**
     * Construct a renderable component that isn't on
     * the grid.
     */
    public Renderable() {
        gridPosition = new IntVector2D(-1, -1);
    }

    /**
     * Gets the current level.
     * @return The level.
     */
    protected Level getLevel() {
        return Main.getCurrentLevel();
    }

    /**
     * Returns whether the tile neighbours a bomb.
     * @return True if a bomb is on a neighbouring tile
     */
    public IntVector2D isNextToBomb() {
        return bombPosition;
    }

    /**
     * Takes in the bomb position if a bomb is on a neighbouring tile.
     * @param inBombPosition The position of the neighbouring bomb.
     */
    public void setNextToBomb(final IntVector2D inBombPosition) {
        bombPosition = inBombPosition;
    }

    /**
     * The top left position on the canvas that this item should
     * be rendered to.
     * @return Position of this item on the canvas.
     */
    protected DoubleVector2D getRenderPosition() {
        Level level = Main.getCurrentLevel();

        IntVector2D canvasSize = Main.getCanvasSize();
        IntVector2D levelSize = level.getLevelSize();

        double cubeSize = getCubeSize();
        DoubleVector2D gridSize = levelSize.toDouble().multiply(cubeSize);
        DoubleVector2D gridTopLeft = canvasSize.toDouble()
                .minus(gridSize).divide(2);

        return gridPosition.toDouble().multiply(cubeSize).add(gridTopLeft);
    }

    /**
     * The maximum side length that the item should take up on the grid.
     * @return Size of this section.
     */
    protected static double getCubeSize() {
        Level level = Main.getCurrentLevel();

        IntVector2D levelSize = level.getLevelSize();
        IntVector2D canvasSize = Main.getCanvasSize();

        // Take 20% from canvas so there is a border
        DoubleVector2D gridSize = canvasSize.toDouble()
                .multiply(1 - BORDER_PERCENTAGE);

        DoubleVector2D potentialSize = gridSize.divide(levelSize);
        return Math.min(potentialSize.getX(), potentialSize.getY());
    }

    /**
     * The position of this item on the grid.
     * @return Coordinates of this.
     */
    public IntVector2D getGridPosition() {
        return gridPosition;
    }

    /**
     * Changes the position of this on the grid.
     * @param inGridPosition New position on the grid.
     */
    public void setGridPosition(final IntVector2D inGridPosition) {
        gridPosition = inGridPosition;
    }

    /**
     * Called just before the grid gets re-rendered.
     * @param time Time since last frame in milliseconds.
     */
    public abstract void tick(int time);

    /**
     * Draws this item to the canvas.
     * @param gc GraphicsContext for creating draw class.
     */
    public abstract void draw(GraphicsContext gc);
}
