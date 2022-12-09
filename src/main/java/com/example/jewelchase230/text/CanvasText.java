package com.example.jewelchase230.text;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Renderable;
import com.example.jewelchase230.vectors.DoubleVector2D;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Text displayed above the grid.
 *
 * @author Will Kaye
 */
public abstract class CanvasText extends Renderable {
    /**
     * Font name.
     */
    private static final String FONT_NAME = "Silkscreen";

    /**
     * Distance from other things on the grid.
     */
    private static final int PADDING = 8;

    /**
     * The position of text above the grid.
     */
    private final TextPosition position;

    /**
     * Constructs a new CanvasText and gives it
     * a position above the grid.
     *
     * @param pos The horizontal position on the window.
     */
    protected CanvasText(final TextPosition pos) {
        super(0, -1);
        position = pos;
    }

    /**
     * @return Text to display on canvas.
     */
    protected abstract String getText();

    private double getStringWidth(final Font font, final String text) {
        //Based on - https://bit.ly/3HfCMlB
        Text textNode = new Text(text);
        textNode.setFont(font);
        return textNode.getBoundsInLocal().getWidth();
    }

    /**
     * Draws this item to the canvas.
     *
     * @param gc GraphicsContext for creating draw class.
     */
    @Override
    public void draw(final GraphicsContext gc) {
        String text = getText();
        DoubleVector2D renderPos = getRenderPosition();
        IntVector2D canvasSize = Main.getCanvasSize();
        IntVector2D levelSize = getLevel().getLevelSize();
        double cubeSize = getCubeSize();
        double border = cubeSize / PADDING;

        // Can only take up a third of the total top of the grid.
        double maxWidth = levelSize.getX() * cubeSize
                / TextPosition.values().length - border;

        double fontSize = cubeSize / 2;
        Font font = new Font(FONT_NAME, fontSize);
        double width = getStringWidth(font, text);

        // Shrink font size until it is below the maxWidth
        while (width > maxWidth) {
            fontSize--;
            font = new Font(FONT_NAME, fontSize);
            width = getStringWidth(font, text);
        }

        double xPos = renderPos.getX();

        if (position == TextPosition.Middle) {
            xPos = (double) canvasSize.getX() / 2 - width / 2;
        } else if (position == TextPosition.Right) {
            xPos += levelSize.getX() * cubeSize - width;
        }

        gc.setFill(Color.BLACK);
        gc.setFont(font);
        gc.fillText(text, xPos, renderPos.getY() + cubeSize - border);
    }
}
