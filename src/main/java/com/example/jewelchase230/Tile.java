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
    /** Top left side of tile. */
    private final TileColour topLeft;
    /** Bottom left side of tile. */
    private final TileColour bottomLeft;
    /** Top right side of tile. */
    private final TileColour topRight;
    /** Bottom right side of tile. */
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

    /**
     * Draws the sqaures based on the parameters passed.
     * @param gc   The graphic context.
     * @param img   The image being applied to the tile. 
     * @param pos   The position in which the tile is being rendered.
     * @param sideLength The length of the tile.
     */
    private void drawSquare(GraphicsContext gc, Image img,  DoubleVector2D pos, double sideLength){
        double upperX = pos.getX();
        double upperY = pos.getY();
        gc.drawImage(img, upperX, upperY, sideLength, sideLength);
    }

    /**
     * Draws the tile has a whole using the drawSquare method to do each quadrant.
     */
    @Override
    public void draw(final GraphicsContext gc){
        DoubleVector2D pos = getRenderPosition();
        double size = getCubeSize();
        Image img;

        double sideLength = size / 2;
        
        /**
         * Makes and passes the variables needed for the tile to be drawn for each quadrant.
         */
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

    @Override
    public void tick(final int time) {

    }
}
