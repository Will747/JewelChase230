package com.example.jewelchase230;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * MainMenu controller for main menu fxml file.
 *
 * @author Will Kaye
 */
public class MainMenu {
    @FXML
    void onStartGamePressed(MouseEvent event) {
        Main.switchToCanvas();
    }

    @FXML
    void onSwitchMenuPressed(MouseEvent event) {
        Main.switchToMenu(Menu.getTestMenu());
    }
}
