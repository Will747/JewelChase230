package com.example.jewelchase230.menus;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Optional;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

/**
 * Controller for the profile menus - changing scenes.
 *
 * @author Daniel Clark
 */
public final class ProfileSelectMenu {
    /**
     * Displays the player's name.
     */
    @FXML
    private Label selectPlayerName;

    /**
     * Displays the players highest achieved level.
     */
    @FXML
    private Label selectPlayerLevel;

    /**
     * Button used for loading the last saved game.
     */
    @FXML
    private Button saveGameButton;

    /**
     * Image of the profile.
     */
    @FXML
    private ImageView profileImage;

    /**
     * The profile being shown by this.
     */
    private Profile currentProfile;


    /**
     * Sets the profile being shown by this menu.
     *
     * @param p The profile to be shown.
     */
    public void setProfile(final Profile p) {
        currentProfile = p;
        selectPlayerName.setText(p.getPlayerName());
        profileImage.setImage(p.getCatCharacter().getRightImage());
        selectPlayerLevel.setText("LEVEL : " + p.getLevelReached());

        String saveGamePath = p.getSaveGamePath();
        File file = new File(saveGamePath);

        saveGameButton.setDisable(!file.exists());
    }

    @FXML
    void onLoadSaveGamePressed(final MouseEvent event) {
        try {
            String fileName = currentProfile.getSaveGamePath();
            FileInputStream fileInputStream = new
                    FileInputStream(fileName);
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(fileInputStream);

            Level newLevel = (Level) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            Main.setLevel(newLevel, currentProfile);
            Main.switchToCanvas();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        LevelSelectMenu levelSelectController = Menu.getLevelSelectController();
        levelSelectController.setProfile(currentProfile);
        Main.switchRoot(Menu.getLevelSelectMenu());
    }

    @FXML
    private void onDeletePressed(final MouseEvent event) throws IOException {
        Alert.AlertType type = Alert.AlertType.CONFIRMATION;

        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("are you sure?");
        alert.getDialogPane()
                .setHeaderText("You are about to delete this profile");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ProfileManager.deleteProfile(currentProfile);
            ProfileManager.saveProfiles();
            Menu.getProfileMenuController().refresh();
            Main.switchRoot(Menu.getProfileMenu());
        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("cancelled profile deletion.");
        }
    }
}
