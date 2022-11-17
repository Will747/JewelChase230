package com.example.jewelchase230;

import com.example.jewelchase230.vectors.DoubleVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Temporary renderable as an example and for testing.
 *
 * @author Will Kaye
 */
public class TestRenderable extends Renderable {

    /**
     * Constructs a test renderable component.
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public TestRenderable(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        DoubleVector2D pos = getRenderPosition();
        DoubleVector2D size = getCubeSize();

        // Randomly pick a colour
        Random random = new Random();
        Color colour = switch (random.nextInt(4)) {
            case 1 -> Color.RED;
            case 2 -> Color.BLUE;
            case 3 -> Color.GREEN;
            default -> Color.YELLOW;
        };

        gc.setFill(colour);
        gc.fillRect(pos.getX(), pos.getY(), size.getX(), size.getY());
    }

    @Override
    public void tick(int time) {

    }
}
