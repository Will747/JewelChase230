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

	private static int profileSelected;

	private static void setProfileSelected(int profile) {
		profileSelected = profile;
	}

	public static int getProfileSelected() {
		return profileSelected;
	}

	@FXML
	private Label playerOne;

	@FXML
	private Label playerTwo;

	@FXML
	private Label playerThree;

	@FXML
	private Label playerFour;

	@FXML
	private void initialize() {
		for (int i = 0; i <= 3; i++) {

			if (isProfileEmpty(i) == false) {
				switch (i) {
				case 0:
					playerOne.setText(
							ProfileManager.rearrangeListOfProfile(ProfileManager.listOfProfile).get(0).getPlayerName());
					break;
				case 1:
					playerTwo.setText(
							ProfileManager.rearrangeListOfProfile(ProfileManager.listOfProfile).get(1).getPlayerName());
					break;
				case 2:
					playerThree.setText(
							ProfileManager.rearrangeListOfProfile(ProfileManager.listOfProfile).get(2).getPlayerName());
					break;
				case 3:
					playerFour.setText(
							ProfileManager.rearrangeListOfProfile(ProfileManager.listOfProfile).get(3).getPlayerName());
					break;
				}

			} else if (isProfileEmpty(i) == true) {
				switch (i) {
				case 0:
					playerOne.setText("P1");
					break;
				case 1:
					playerTwo.setText("P2");
					break;
				case 2:
					playerThree.setText("P3");
					break;
				case 3:
					playerFour.setText("P4");
					break;
				}
			}
		}
	}

	private boolean isProfileEmpty(int i) {
		boolean isListIEmpty;

		if (ProfileManager.rearrangeListOfProfile(ProfileManager.listOfProfile).get(i) == null)
			 isListIEmpty = true;
		else { 
			isListIEmpty = false;
			
		}
	
		return isListIEmpty;
	}

	@FXML
	void onBackToMainMenuPressed(final MouseEvent event) {
		Main.switchRoot(Menu.getMainMenu());
	}

	@FXML
	void onP1Pressed(final MouseEvent event) {
		Main.switchRoot(Menu.getProfileSelect());
		setProfileSelected(0);
	}

	@FXML
	void onP2Pressed(final MouseEvent event) {
		Main.switchRoot(Menu.getProfileSelect());
		setProfileSelected(1);
	}

	@FXML
	void onP3Pressed(final MouseEvent event) {
		Main.switchRoot(Menu.getProfileSelect());
		setProfileSelected(2);
	}

	@FXML
	void onP4Pressed(final MouseEvent event) {
		Main.switchRoot(Menu.getProfileSelect());
		setProfileSelected(3);
	}
}
