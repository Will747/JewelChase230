package com.example.jewelchase230;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 */
public final class TestMenu {
    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getMainMenu());
    }
}
