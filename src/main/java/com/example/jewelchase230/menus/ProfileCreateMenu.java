package com.example.jewelchase230.menus;

import java.io.IOException;
import java.util.Optional;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 * Controller for the create profile menu.
 * 
 * @author Kellie Robinson
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
	
	void onCreateProfilePressed(final MouseEvent event) throws IOException { 
		profileCreatedName = createProfileName.getText();
		System.out.println(profileCreatedName);
		if(acceptableName(profileCreatedName) == true){
			Profile newProfile = new Profile(choosePlayerSlot(),1,profileCreatedName,0);
			ProfileManager.listOfProfile.add(newProfile);
			ProfileManager.saveProfile(newProfile);
			Menu.getProfileMenuController().refresh();
			//ProfileManager.readLines();
			Main.switchRoot(Menu.getProfileMenu());
		}
		else{
			System.out.println("INVALID INPUT");
		}

	}
	
	/**
	 * This method decides, based on how many profiles exist in profileList, which playerSlot a new player has
	 * @return int profileNewSlot
	 * @throws IOException
	 */
	int choosePlayerSlot() throws IOException { 
		if (ProfileMenu.profileList.size() < 1) { 
			 profileNewSlot = 1;
		} 
		else if(ProfileMenu.profileList.size() == 1) { 
			 profileNewSlot = 2;

		}
		else if(ProfileMenu.profileList.size() == 2) {
			 profileNewSlot = 3;

		}
		else if(ProfileMenu.profileList.size() == 3) {
			 profileNewSlot = 4;

		} else { 
			fullProfiles();
		}
		return profileNewSlot;
	}
	@FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }
	//Only allows charecters a-z, A-Z and numbers 1.. as well as non empty names
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

	private void fullProfiles() throws IOException{
		Alert.AlertType type = Alert.AlertType.WARNING;

		Alert alert = new Alert(type, "");

		alert.initModality(Modality.APPLICATION_MODAL);
		alert.getDialogPane().setContentText("Too many profiles!");
		alert.getDialogPane().setHeaderText("Please delete a Profile to continue");

		alert.show();
	}
}
