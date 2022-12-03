package com.example.jewelchase230;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;

/**
 * A resizable canvas that resizes to fill the parent nodes size.
 * @author Will Kaye
 */
public class GameCanvas extends Canvas {
    /** Region to match size with. */
    private Region parentRegion;

    /**
     * Constructs a new instance of GameCanvas.
     *
     * @param width width used by canvas before scaling.
     * @param height height used by canvas before scaling.
     */
    public GameCanvas(final double width, final double height) {
        super(width, height);
        parentProperty().addListener(e -> setParentRegion());
    }

    /**
     * Triggered when the parent region changes.
     */
    private void setParentRegion() {
        Parent parent = getParent();

        if (parent instanceof Region region) {
            parentRegion = region;
            parentRegion.widthProperty().addListener(e -> updateSize());
            parentRegion.heightProperty().addListener(e -> updateSize());
        }
    }

    /**
     * Changes the size of the canvas so that it fills as much of
     * the parent region as possible.
     */
    private void updateSize() {
        setWidth(parentRegion.getWidth());
        setHeight(parentRegion.getHeight());
    }
}
