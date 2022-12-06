package com.example.jewelchase230.text;

import com.example.jewelchase230.Level;

/**
 * Renders the current level number above the grid.
 *
 * @author Will Kaye
 */
public final class LevelNumText extends CanvasText {
    /**
     * Constructs a new LevelNumText.
     */
    public LevelNumText() {
        super(TextPosition.Middle);
    }

    @Override
    protected String getText() {
        Level level = getLevel();
        return "Level " + level.getLevelNumber();
    }
}
