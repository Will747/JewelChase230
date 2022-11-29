package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * MainMenu controller for main menu fxml file.
 *
 * @author Will Kaye
 */
public final class MainMenu {
    @FXML
    void onStartGamePressed(final MouseEvent event) {
        Main.switchToCanvas();
    }
    
    @FXML
    void onSwitchMenuPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getTestMenu());
    }

    @FXML
    void onSettingsMenuPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getSettingsMenu());
    }

    @FXML
    void onHighScoreTablePressed(final MouseEvent event) {
        Main.switchToScene(Menu.getHighScoreTable());
    }

    @FXML
    void onProlifeMenuPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileMenu());
    }

    @FXML
    void onProlifeSelectPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileSelect());
    }
}
