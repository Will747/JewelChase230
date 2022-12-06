package com.example.jewelchase230.text;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;

/**
 * Renders the time remaining in the current level above the grid.
 *
 * @author Will Kaye.
 */
public final class TimeText extends CanvasText {
    /**
     * Constructs a new TimeText.
     */
    public TimeText() {
        super(TextPosition.Left);
    }

    @Override
    protected String getText() {
        Level level = getLevel();
        int remainingTime =
                level.getTimeLimit() / Main.MILLISECONDS_IN_A_SECOND;
        return "Time Left: " + remainingTime;
    }
}
