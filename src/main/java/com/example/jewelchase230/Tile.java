package com.example.jewelchase230;

import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.DoubleVector2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * A tile is one square on the grid that can have a different colour for
 * each side.
 */
public final class Tile extends Renderable {
    /** Number of corners in a triangle. */
    private static final int CORNERS_IN_A_TRIANGLE = 3;
    /** Top side of tile. */
    private final TileColour top;
    /** Bottom side of tile. */
    private final TileColour bottom;
    /** Left side of tile. */
    private final TileColour left;

    /** Right side of tile. */
    private final TileColour right;
    public Character character;

    /**
     * Item currently on this tile.
     * null when no item is on this tile.
     */
    private Item item;

    /**
     * Constructs a new tile.
     * @param inTop Top colour
     * @param inBottom Bottom colour
     * @param inLeft Left colour
     * @param inRight Right colour
     */
    public Tile(final TileColour inTop,
                final TileColour inBottom,
                final TileColour inLeft,
                final TileColour inRight) {
        super();
        top = inTop;
        bottom = inBottom;
        left = inLeft;
        right = inRight;
    }

    /**
     * @return The item on this tile or null if there isn't one.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Adds an item to this tile.
     * @param inItem Item on this tile.
     */
    public void setItem(final Item inItem) {
        item = inItem;
    }

    /**
     * @return Top side of tile
     */
    public TileColour getTop() {
        return top;
    }

    /**
     * @return Left side of tile
     */
    public TileColour getLeft() {
        return left;
    }

    /**
     * @return Right side of tile
     */
    public TileColour getRight() {
        return right;
    }

    /**
     * @return Bottom side of tile
     */
    public TileColour getBottom() {
        return bottom;
    }

    private void drawTriangle(
            final GraphicsContext gc,
            final DoubleVector2D[] points,
            final TileColour colour) {
        if (points.length == CORNERS_IN_A_TRIANGLE) {
            double[] xVtx = new double[CORNERS_IN_A_TRIANGLE];
            double[] yVtx = new double[CORNERS_IN_A_TRIANGLE];

            // Left
            xVtx[0] = points[0].getX();
            yVtx[0] = points[0].getY();

            xVtx[1] = points[1].getX();
            yVtx[1] = points[1].getY();

            xVtx[2] = points[2].getX();
            yVtx[2] = points[2].getY();

            gc.setFill(colour.getColour());
            gc.fillPolygon(xVtx, yVtx, CORNERS_IN_A_TRIANGLE);
        }
    }

    @Override
    public void draw(final GraphicsContext gc) {

        DoubleVector2D pos = getRenderPosition();
        double size = getCubeSize();

        DoubleVector2D topRightCorner = pos.add(
                new DoubleVector2D(size, 0));
        DoubleVector2D bottomLeft = pos.add(
                new DoubleVector2D(0, size)
        );
        DoubleVector2D bottomRight = pos.add(size);
        DoubleVector2D center = pos.add(size / 2);

        DoubleVector2D[] points = new DoubleVector2D[CORNERS_IN_A_TRIANGLE];

        // Left
        points[0] = pos;
        points[1] = center;
        points[2] = bottomLeft;
        drawTriangle(gc, points, left);

        // Top
        points[2] = topRightCorner;
        drawTriangle(gc, points, top);

        // Right
        points[0] = bottomRight;
        drawTriangle(gc, points, right);

        // Bottom
        points[0] = bottomLeft;
        points[2] = bottomRight;
        drawTriangle(gc, points, bottom);
    }

    @Override
    public void tick(final int time) {

    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(final Character inCharacter) {
        character = inCharacter;
    }
}
