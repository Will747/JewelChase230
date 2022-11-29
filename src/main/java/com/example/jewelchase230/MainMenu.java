package com.example.jewelchase230;

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
        Main.switchToScene(Menu.getProfileMenu());
    }
    
    
    @FXML
    void onSwitchMenuPressed(final MouseEvent event) {
        Main.switchToScene(Menu.getTestMenu());
    }
    
    void onSettingsPressed(final MouseEvent event) { 
    	Main.switchToScene(Menu.getSettingsMenuFxml());
    }
    
}
