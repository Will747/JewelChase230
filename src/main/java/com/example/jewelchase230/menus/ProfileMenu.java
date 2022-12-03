package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.ProfileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the profile menus - changing scenes.
 *
 * @author Daniel Clark
 */
public final class ProfileMenu {

    @FXML 
    private Label playerOne;

    @FXML
    private Label playerTwo;

    @FXML
    private Label playerThree;
    
    @FXML
    private Label playerFour;




    @FXML
    private void initialize()
    {
        playerOne.setText(ProfileManager.getProfileNames().get(0));
        playerTwo.setText(ProfileManager.getProfileNames().get(0));
        playerThree.setText(ProfileManager.getProfileNames().get(0));
        playerFour.setText(ProfileManager.getProfileNames().get(0));
    }

    @FXML
    void onBackToMainMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getMainMenu());
    }

    @FXML
    void onP1Pressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void onP2Pressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void onP3Pressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void onP4Pressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }
}
