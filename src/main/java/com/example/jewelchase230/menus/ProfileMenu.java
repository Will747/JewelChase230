package com.example.jewelchase230.menus;

import java.util.Optional;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller for the profile menus - changing scenes.
 *
 * @author Daniel Clark
 */
public final class ProfileMenu {
    @FXML
    void onBackToMainMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getMainMenu());
    }

    @FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
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
