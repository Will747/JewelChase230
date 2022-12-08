package com.example.jewelchase230.menus;

import java.io.IOException;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

/**
 * Controller for the create profile menu.
 * 
 * @author Kellie Robinson
 * @author Daniel Clarke
 *
 */


public final class ProfileCreateMenu {

	@FXML
	private Button buttonCreateProfile; 
	@FXML 
	private TextField createProfileName;
	
	
	public String profileCreatedName; 
	
	@FXML
	private Button createProfileMenuButton;
	
	int profileNewSlot;
	
	
	
	@FXML
	/** 
	 * This method creates a profile using the user's name input
	 * @param event: MouseClick
	 * @throws IOException
	 */
	void onCreateProfilePressed(final MouseEvent event)
			throws IOException {
		profileCreatedName = createProfileName.getText();
		if (acceptableName(profileCreatedName)) {
			Profile newProfile = new Profile(profileCreatedName);
			ProfileManager.addProfile(newProfile);
			ProfileManager.saveProfiles();
			Menu.getProfileMenuController().refresh();
			Main.switchRoot(Menu.getProfileMenu());
		} else {
			System.out.println("INVALID INPUT");
		}

	}

	/**
	 * Method which allows user to navigate back to the Main Menu.
	 * @param event (MouseClick)
	 */
	@FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }

	/**
	 * Method which checks if a name is valid (only characters and numbers).
	 * @param name
	 * @return boolean value valid.
	 */
	boolean acceptableName(String name)
	{
		boolean valid = false;
		if(name == "")
		{
			System.out.println("No name was entered");
		}
		else if(!name.matches("[a-zA-Z1-9]+"))
		{
			System.out.println("invalid charecter in name");
		}
		else
		{
			valid = true;
		}
		return(valid);
	}
	/**
	 * Method which throws error on pretense that all profile slots are occupied.
	 * @throws IOException
	 */
	private void fullProfiles() throws IOException{
		Alert.AlertType type = Alert.AlertType.WARNING;

		Alert alert = new Alert(type, "");

		alert.initModality(Modality.APPLICATION_MODAL);
		alert.getDialogPane().setContentText("Too many profiles!");
		alert.getDialogPane().setHeaderText("Please delete a Profile to continue");

		alert.show();
	}
}
