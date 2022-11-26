package com.example.jewelchase230;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;

/**
 * A canvas that scales to the parent nodes size. But keeps the original
 * aspect ratio and dimensions internally. This prevents items drawn to
 * the canvas being in the incorrect places after the canvas has been resized.
 * @author Will Kaye
 */



public class GameCanvas extends Canvas {
    /** Region to match size with. */
    private Region parent;

    /**
     * Constructs a new instance of GameCanvas.
     *
     * @param root the region to match in size.
     * @param width width used by canvas before scaling.
     * @param height height used by canvas before scaling.
     */
    public GameCanvas(
            final Region root, final double width, final double height) {
        super(width, height);

        setParentRegion(root);
    }

    /**
     * Sets the canvas to scale to the size of this region.
     * @param inParent Parent/root region of this canvas.
     */
    public void setParentRegion(final Region inParent) {
        parent = inParent;
        parent.widthProperty().addListener(e -> updateScale());
        parent.heightProperty().addListener(e -> updateScale());
    }

    /**
     * Changes the scale of the canvas so that it fills as much of
     * the parent region as possible.
     */
    private void updateScale() {
        double externalWidth = parent.getWidth();
        double externalHeight = parent.getHeight();

        double heightScale = externalHeight / getHeight();
        double widthScale = externalWidth / getWidth();

        // Ensures the whole canvas stays on the screen without
        // affecting the aspect ratio
        if (heightScale < widthScale) {
            setScaleX(heightScale);
            setScaleY(heightScale);
        } else {
            setScaleX(widthScale);
            setScaleY(widthScale);
        }
    }
}
