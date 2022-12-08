package com.example.jewelchase230.menus;

import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 */
public final class LevelSelectMenu {
    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void changeLevel(final MouseEvent event) {
        Main.switchRoot(Menu.getLevelSelectMenu());
    }

    //temporary tester
    @FXML
    void levelOne(final MouseEvent event) {
        Main.setLevel(LevelFileReader.getLevel(1));
        Main.switchToCanvas();
    }    
}
