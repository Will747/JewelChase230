package com.example.jewelchase230.menus;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * The class for the game over screen.
 *
 * @author Adam Smith, Will Kaye
 */
public final class GameOverMenu {
    /**
     * The number of the level just lost.
     */
    private int levelNum;

    /**
     * Profile playing this level.
     */
    private Profile profile;

    /**
     * Sets the stats shown by this menu.
     * @param level The level just completed.
     */
    public void setLevelLost(final Level level) {
        levelNum = level.getLevelNumber();
        profile = level.getCurrentProfile();
    }

    @FXML
    private void onReturnToMainMenuPressed(final MouseEvent event) {
        Main.endCurrentLevel();
        Main.switchRoot(Menu.getMainMenu());
    }

    @FXML
    void onRestartPressed(final MouseEvent event) {
        Main.endCurrentLevel();
        Main.setLevel(
                LevelFileReader.getLevel(levelNum), profile);
        Main.switchToCanvas();
    }

    @FXML
    private void onExitPressed(final MouseEvent event) {
        Main.close();
    }
}
