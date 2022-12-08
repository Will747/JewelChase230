package com.example.jewelchase230.menus;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;

/**
 * The class controls the pause menu of the game.
 * @author Adam Smith
 */
public class PauseMenu {
    /**
     * Resumes the game to the current state.
     * @param event A user input.
     */
    @FXML
    private void onResumeGamePressed(final MouseEvent event) {
        Main.switchToCanvas();
    }

    /**
     * Changes to the settings menu.
     * @param event A user input.
     */
    @FXML
    private void onSettingsMenuPressed(final MouseEvent event) {
        Menu.getSettingsMenuController().setPreviousParent(Menu.getPauseMenu());
        Main.switchRoot(Menu.getSettingsMenu());
    }

    /**
     * Changes to the high score menu.
     * @param event A user input.
     */
    @FXML
    private void onHighScoreTablePressed(final MouseEvent event) {
        Menu.getHighScoreMenuController().setPreviousParent(Menu.getPauseMenu());
        Main.switchRoot(Menu.getHighScoreTable());
    }
}
