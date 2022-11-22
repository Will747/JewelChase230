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
        IntVector2D canvasSize = Main.getCanvasSize();

        // Calculate the 10% size of the canvas that is used as a border
        DoubleVector2D borderOffset = canvasSize.toDouble().multiply(0.025);

        DoubleVector2D cubeSize = getCubeSize();
        return cubeSize.multiply(gridPosition).add(borderOffset);
    }

    /**
     * The maximum size the item should take up on the grid.
     * @return Size of this section.
     */
    protected static DoubleVector2D getCubeSize() {
        Level level = Main.getCurrentLevel();

        IntVector2D levelSize = level.getLevelSize();
        IntVector2D canvasSize = Main.getCanvasSize();

        // Take 20% from canvas so there is a border
        DoubleVector2D gridSize = canvasSize.toDouble().multiply(0.95);
        return gridSize.divide(levelSize);
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
