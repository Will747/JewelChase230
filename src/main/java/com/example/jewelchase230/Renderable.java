package com.example.jewelchase230;

import com.example.jewelchase230.vectors.DoubleVector2D;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

/**
 * A component that ticks and can be rendered onto the level
 * grid.
 *
 * @author Will Kaye
 */
public abstract class Renderable implements Serializable {
    /**
     * The percentage of the canvas that must be left blank
     * around the edges.
     */
    private static final double BORDER_PERCENTAGE = 0.05;

    /**
     * Additional offset at the top for text.
     */
    private static final double TOP_OFFSET = 0.25;

    /** Position in the level item should be rendered to. */
    private IntVector2D gridPosition;

    /**
     * Constructs a renderable component.
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Renderable(final int x, final int y) {
        gridPosition = new IntVector2D(x, y);
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
                .minus(gridSize).divide(2)
                .add(new DoubleVector2D(0, cubeSize * TOP_OFFSET));

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

        // Includes an extra row at the top for text
        IntVector2D gridSize = levelSize.add(new IntVector2D(0, 1));

        // Take 20% from canvas so there is a border
        DoubleVector2D playableSize = canvasSize.toDouble()
                .multiply(1 - BORDER_PERCENTAGE);

        DoubleVector2D potentialSize = playableSize.divide(gridSize);
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
    public void tick(final int time) {
    }

    /**
     * Draws this item to the canvas.
     * @param gc GraphicsContext for creating draw class.
     */
    public abstract void draw(GraphicsContext gc);
}
