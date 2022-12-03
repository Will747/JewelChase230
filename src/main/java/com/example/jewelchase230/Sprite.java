package com.example.jewelchase230;

import com.example.jewelchase230.vectors.DoubleVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Represents Sprites in the game.
 *
 * @author Caroline Segestaal and Will Kaye.
 */
public abstract class Sprite extends Renderable {
    /**
     * The current image being shown for this
     * item on the grid.
     */
    private Image image;

    /**
     * Constructs a sprite component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public Sprite(final int x, final int y) {
        super(x, y);
    }

    /**
     * Constructs a new sprite with an image.
     * @param inImage The image used by the sprite.
     */
    public Sprite(final Image inImage) {
        super();
        image = inImage;
    }

    /**
     * Constructs a new sprite not on the grid.
     */
    public Sprite() {
        super();
    }

    /**
     * Updates the image being rendered by this sprite.
     * @param inImage The image.
     */
    protected void setImage(final Image inImage) {
        image = inImage;
    }

    /**
     * Sets the image to render, from the file path to the image.
     * @param fileName File path of image.
     */
    protected void setImageFromFile(final String fileName) {
        try {
            setImage(getImageFromFile(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an image from a filename.
     * @param fileName The file path of the image.
     * @return The image.
     * @throws FileNotFoundException When the image cannot be loaded.
     */
    private static Image getImageFromFile(final String fileName)
            throws FileNotFoundException {
        return new Image(new FileInputStream(fileName));
    }    

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {
    }

    /**
     * Draws this item to the canvas.
     *
     * @param gc GraphicsContext for creating draw class.
     */
    @Override
    public void draw(final GraphicsContext gc) {
        if (image != null) {
            DoubleVector2D pos = getRenderPosition();
            double size = getCubeSize();

            gc.drawImage(image, pos.getX(), pos.getY(), size, size);
        }
    }
}
