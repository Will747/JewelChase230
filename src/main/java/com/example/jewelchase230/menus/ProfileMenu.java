package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the profile menus - changing scenes
 *
 * @author Daniel Clark
 */
public final class ProfileMenu {
    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getMainMenu());
    }

    @FXML
    void onP1Pressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileSelect());
    }

    @FXML
    void onP2Pressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileSelect());
    }

    @FXML
    void onP3Pressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileSelect());
    }

    @FXML
    void onP4Pressed(final MouseEvent event) {
        Main.switchToScene(Menu.getProfileSelect());
    }
}