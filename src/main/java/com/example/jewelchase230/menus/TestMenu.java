package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
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
        Main.switchRoot(Menu.getMainMenu());
    }
}
