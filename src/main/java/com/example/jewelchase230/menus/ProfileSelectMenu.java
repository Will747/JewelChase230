package com.example.jewelchase230.menus;

import java.util.Optional;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.ProfileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

/**
 * Controller for the profile menus - changing scenes.
 *
 * @author Daniel Clark
 */
public final class ProfileSelectMenu {

    @FXML 
    private Label playerOne;

    @FXML
    private void initialize()
    {
        playerOne.setText(ProfileManager.getProfileNames().get(0));
    }

    @FXML
    void onBackToMainMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getMainMenu());
    }

    @FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }

    @FXML
    private void onStartGamePressed(final MouseEvent event) {
        Main.switchToCanvas();
    }

    @FXML
    private void onDeletePressed(final MouseEvent event) {
        Alert.AlertType type = Alert.AlertType.CONFIRMATION;

        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        //alert.initOwner(stage);
        alert.getDialogPane().setContentText("are you sure?");
        alert.getDialogPane().setHeaderText("You are about to delete this profile");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
            System.out.println("profile deleted.");
        }
        else if (result.get() == ButtonType.CANCEL)
        {
            System.out.println("cancelled profile deletion.");
        }
    }
}
