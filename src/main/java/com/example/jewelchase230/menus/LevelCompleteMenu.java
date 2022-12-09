package com.example.jewelchase230.menus;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Menu shown when a level is completed.
 *
 * @author Will Kaye
 */
public final class LevelCompleteMenu {
    /**
     * The number of the level just completed.
     */
    private int levelNum;

    /**
     * Profile completing this level.
     */
    private Profile profile;

    /**
     * Label that shows the score achieved in this level.
     */
    @FXML
    private Label scoreLabel;

    /**
     * Sets the stats shown by this menu.
     * @param level The level just completed.
     */
    public void setLevelCompleted(final Level level) {
        levelNum = level.getLevelNumber();
        profile = level.getCurrentProfile();
        int score = level.getPlayerScore();

        // Save score
        profile.setLevelReached(levelNum + 1);
        Main.getHighScoreTable().addScore(levelNum, profile,
                score);

        scoreLabel.setText("Score " + score);
    }

    @FXML
    void onNextLevelPressed(final MouseEvent event) {
        Main.endCurrentLevel();
        Main.setLevel(
                LevelFileReader.getLevel(levelNum + 1), profile);
        Main.switchToCanvas();
    }

    @FXML
    void onReplayPressed(final MouseEvent event) {
        Main.endCurrentLevel();
        Main.setLevel(
                LevelFileReader.getLevel(levelNum), profile);
        Main.switchToCanvas();
    }

    @FXML
    private void onHighScoreTablePressed(final MouseEvent event) {
        Menu.getHighScoreMenuController()
                .setPreviousParent(Menu.getLevelComplete());
        Main.switchRoot(Menu.getHighScoreTable());
    }

    @FXML
    private void onMainMenuPressed(final MouseEvent event) {
        Main.endCurrentLevel();
        Main.switchRoot(Menu.getMainMenu());
    }

    @FXML
    private void onExitPressed(final MouseEvent event) {
        Main.close();
    }
}
