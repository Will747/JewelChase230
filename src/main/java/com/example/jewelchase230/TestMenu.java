package com.example.jewelchase230;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 */
public class TestMenu {
    @FXML
    void onBackPressed(MouseEvent event) {
        Main.switchToMenu(Menu.getMainMenu());
    }
}
