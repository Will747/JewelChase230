package com.example.jewelchase230.text;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;

/**
 * Renders the current in-game score to the canvas.
 *
 * @author Will Kaye
 */
public final class ScoreText extends CanvasText {
    /**
     * Constructs a new ScoreText.
     */
    public ScoreText() {
        super(TextPosition.Right);
    }

    @Override
    protected String getText() {
        Level level = getLevel();
        return "Score: " + level.getPlayerScore();
    }
}
