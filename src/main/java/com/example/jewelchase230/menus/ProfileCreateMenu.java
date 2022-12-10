package com.example.jewelchase230.menus;



import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileManager;
import com.example.jewelchase230.profiles.ProfileImage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

/**
 * Controller for the create profile menu.
 *
 * @author Kellie Robinson, Daniel Clarke
 */
public final class ProfileCreateMenu {

    /**
     * Create profile button.
     */
    @FXML
    private Button buttonCreateProfile;

    /**
     * Profile name text field.
     */
    @FXML
    private TextField createProfileName;

    /**
     * Create profile button.
     */
    @FXML
    private Button createProfileMenuButton;
    
    /*
     * Choose cat combo box.
     */
    @FXML
    private ComboBox<ProfileImage> chooseCatComboBox;
    
    /** 
     * char which indicated which cat is selected.
     */
    private char catIDSelected = 't'; 
    
    private String chosenCat;
    
/**
    ObservableList<ProfileImage> catList = 
    	    FXCollections.observableArrayList(
    	        ProfileImage.Black,
    	        ProfileImage.Oreo,
    	        ProfileImage.Tabby,
    	        ProfileImage.White
    	    );
    
    
    @FXML
    public void initialize() {
    	chooseCatComboBox.getItems().removeAll(chooseCatComboBox.getItems());
    	chooseCatComboBox.setItems(catList);
    	//chooseCatComboBox.getSelectionModel().select("Option B");
    }
    
    
    private char getChosenCat() {
    	chooseCatComboBox.setOnAction(event -> { 
    		 chosenCat = chooseCatComboBox.getValue().toString();    
    		});
    	return chosenCat.toLowerCase().charAt(0);
    }
   */

    /**
     * This method creates a profile using the user's name input.
     *
     * @param event MouseClick
     */
    @FXML
    void onCreateProfilePressed(final MouseEvent event) {
        String profileCreatedName = createProfileName.getText();
        if (acceptableName(profileCreatedName)) {
            if (ProfileManager.getListOfProfile().size()
                    < ProfileMenu.MAX_NUM_OF_PROFILES) {
            	
                Profile newProfile = new Profile(profileCreatedName);
                ProfileManager.addProfile(newProfile);
                ProfileManager.saveProfiles();
                Menu.getProfileMenuController().refresh();
                Main.switchRoot(Menu.getProfileMenu());
            } else {
                fullProfiles();
                System.out.println("FULL PROFILES");
            }

        } else {
            System.out.println("INVALID INPUT");
        }

    }

    /**
     * Method which allows user to navigate back to the Main Menu.
     *
     * @param event (MouseClick)
     */
    @FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }

    /**
     * Method which checks if a name is valid (only characters and numbers).
     *
     * @param name The name to be checked.
     * @return boolean value valid.
     */
    boolean acceptableName(final String name) {
        boolean valid = false;
        if (name.equals("")) {
            System.out.println("No name was entered");
        } else if (!name.matches("[a-zA-Z1-9]+")) {
            System.out.println("invalid charecter in name");
        } else {
            valid = true;
        }
        return (valid);
    }

    /**
     * Method which throws error on pretense that all profile
     * slots are occupied.
     */
    private void fullProfiles() {
        Alert.AlertType type = Alert.AlertType.WARNING;

        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("Too many profiles!");
        alert.getDialogPane()
                .setHeaderText("Please delete a Profile to continue");

        alert.show();
    }
}
