package com.example.jewelchase230;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.DoubleVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;

/**
 * A tile is one square on the grid that can have a different colour for
 * each side.
 */
public final class Tile extends Renderable {
    /** Top side of tile. */
    private final TileColour topLeft;
    /** Bottom side of tile. */
    private final TileColour bottomLeft;
    /** Left side of tile. */
    private final TileColour topRight;

    /** Right side of tile. */
    private final TileColour bottomRight;

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
    public Tile(final TileColour topLeft,
                final TileColour topRight,
                final TileColour bottomLeft,
                final TileColour bottomRight) {
        super();
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
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

    public TileColour getTopLeft(){
        return topLeft;
    }

    public TileColour getTopRight(){
        return topRight;
    }

    public TileColour getBottomLeft(){
        return bottomLeft;
    }

    public TileColour getBottomRight(){
        return bottomRight;
    }

    private void drawSquare(GraphicsContext gc, Image img,  DoubleVector2D pos, double sideLength){
        double upperX = pos.getX();
        double upperY = pos.getY();
        gc.drawImage(img, upperX, upperY, sideLength, sideLength);
    }

    @Override
    public void draw(final GraphicsContext gc){
        DoubleVector2D pos = getRenderPosition();
        double size = getCubeSize();
        Image img;

        double sideLength = size / 2;
        
        DoubleVector2D topLeft = new DoubleVector2D(0, size);
        switch(getTopLeft()){
            case Red:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_RED.png"));
                    drawSquare(gc, img, topLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_RED.png file not found");
                }
                break;
            case Blue:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_BLUE.png"));
                    drawSquare(gc, img, topLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_BLUE.png file not found");
                }
                break;
            case Green:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_GREEN.png"));
                    drawSquare(gc, img, topLeft, sideLength);
                }catch (FileNotFoundException e){
                    System.out.println("WOODFLOOR_GREEN.png file not found");
                }
                break;
            case Yellow:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_PINK.png"));
                    drawSquare(gc, img, topLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_PINK.png file not found");
                }
                break;
        }

        DoubleVector2D topRight = new DoubleVector2D(sideLength, size);
        switch(getTopRight()){
            case Red:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_RED.png"));
                    drawSquare(gc, img, topRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_RED.png file not found");
                }
                break;
            case Blue:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_BLUE.png"));
                    drawSquare(gc, img, topRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_BLUE.png file not found");
                }
                break;
            case Green:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_GREEN.png"));
                    drawSquare(gc, img, topRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_GREEN.png file not found");
                }
                break;
            case Yellow:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_PINK.png"));
                    drawSquare(gc, img, topRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_PINK.png file not found");
                }
                break;
        }

        DoubleVector2D bottomLeft = new DoubleVector2D(0, sideLength);
        switch(getBottomLeft()){
            case Red:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_RED.png"));
                    drawSquare(gc, img, bottomLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_RED.png file not found");
                }
                break;
            case Blue:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_BLUE.png"));
                    drawSquare(gc, img, bottomLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_BLUE.png file not found");
                }
                break;
            case Green:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_GREEN.png"));
                    drawSquare(gc, img, bottomLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_GREEN.png file not found");
                }
                break;
            case Yellow:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_PINK.png"));
                    drawSquare(gc, img, bottomLeft, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_PINK.png file not found");
                }
                break;
        }

        DoubleVector2D bottomRight = new DoubleVector2D(sideLength, sideLength);
        switch(getBottomRight()){
            case Red:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_RED.png"));
                    drawSquare(gc, img, bottomRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_RED.png file not found");
                }
                break;
            case Blue:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_BLUE.png"));
                    drawSquare(gc, img, bottomRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_BLUE.png file not found");
                }
                break;
            case Green:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_GREEN.png"));
                    drawSquare(gc, img, bottomRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_GREEN.png file not found");
                }
                break;
            case Yellow:
                try{
                    img = new Image(new FileInputStream("images/WOODFLOOR_PINK.png"));
                    drawSquare(gc, img, bottomRight, sideLength);
                }catch(FileNotFoundException e){
                    System.out.println("WOODFLOOR_PINK.png file not found");
                }
                break;
        }
    }

    /*
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

    */

    @Override
    public void tick(final int time) {

    }
}
