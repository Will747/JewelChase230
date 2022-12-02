package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.MessageOfTheDay;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * MainMenu controller for main menu fxml file.
 *
 * @author Will Kaye
 */
public final class MainMenu {
    /** Label used to display the message of the day. */
    @FXML
    private Label messageOfTheDay;

    @FXML
    private void initialize() {
        messageOfTheDay.setText(MessageOfTheDay.getMessageOfTheDay());
    }

    @FXML
    private void onStartGamePressed(final MouseEvent event) {
        Main.switchToCanvas();
    }

    @FXML
    private void onSwitchMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getTestMenu());
    }

    @FXML
    private void onSettingsMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getSettingsMenu());
    }

    @FXML
    private void onHighScoreTablePressed(final MouseEvent event) {
        Main.switchRoot(Menu.getHighScoreTable());
    }

    @FXML
    private void onProlifeMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }

    @FXML
    private void onProlifeSelectPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }
}
