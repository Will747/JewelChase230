package com.example.jewelchase230;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;

/**
 * Scene that scales its contents to fit the window size.
 *
 * @author Will Kaye
 */
public class ScalingScene extends Scene {
    /**
     * If true the root nodes gets scaled from its
     * preferred size to fit the scene.
     */
    private boolean scaleRoot;

    /**
     * Creates a scene for a specific root node.
     *
     * @param parent root node.
     */
    public ScalingScene(final Parent parent) {
        super(parent);

        scaleRoot = true;
        widthProperty().addListener(e -> updateScale());
        heightProperty().addListener(e -> updateScale());
    }

    /**
     * Sets the scene to scale the root node when the
     * window size is changed.
     *
     * @param value Activates or deactivates scaling.
     */
    public void setScaleRoot(final boolean value) {
        scaleRoot = value;

        if (scaleRoot) {
            updateScale();
        }
    }

    /**
     * Changes the scale of the root so that it stretches to
     * fit the window.
     */
    private void updateScale() {
        if (scaleRoot) {
            double width = getWidth();
            double height = getHeight();

            Parent root = getRoot();

            double heightScale = height / root.prefHeight(-1);
            double widthScale = width / root.prefWidth(-1);

            if (root instanceof Region region) {
                if (heightScale < widthScale) {
                    region.setScaleX(heightScale);
                    region.setScaleY(heightScale);
                } else {
                    region.setScaleX(widthScale);
                    region.setScaleY(widthScale);
                }
            }
        }
    }
}
