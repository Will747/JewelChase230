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
		choosePlayerSlot();
		
		Profile newProfile = new Profile(choosePlayerSlot(),1,profileCreatedName,0);
		ProfileManager.listOfProfile.add(newProfile);
		Menu.getProfileMenuController().refresh();
		System.out.println(ProfileManager.getListOfProfile().get(3).getPlayerName());
		//ProfileManager.readLines();
		//ProfileManager.saveProfile(newProfile);
		Main.switchRoot(Menu.getProfileMenu());
	}
	
	/**
	 * This method decides, based on how many profiles exist in profileList, which playerSlot a new player has
	 * @return int profileNewSlot
	 */
	int choosePlayerSlot() { 
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
			Alert.AlertType type = Alert.AlertType.WARNING;

	        Alert alert = new Alert(type, "");

	        alert.initModality(Modality.APPLICATION_MODAL);
	        //alert.initOwner(stage);
	        alert.getDialogPane().setContentText("Too many profiles!");
	        alert.getDialogPane().setHeaderText("Please delete a Profile to continue");

	        Optional<ButtonType> result = alert.showAndWait();
	        if(result.get() == ButtonType.OK)
	        {
	        	//do
	           
	        }
		}
		return profileNewSlot;
	}
	@FXML
    void onBackToProfileMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileMenu());
    }

	// ADD WHEN ALL THE CREATE ERRORS DISAPEAR !!!
	//boolean acceptableName(String name)
	//{
	//	boolean valid = false;
	//	if(name == "")
	//	{
	//		System.out.println("No name was entered");
	//	}
	//	else if(name.matches("[a-zA-Z]+"))
	//	{
	//		System.out.println("invalid charecter in name");
	//	}
	//	else
	//	{
	//		valid = true;
	//	}
	//	return(valid);
	//}
}
