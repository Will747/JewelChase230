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

		playerOne.setText(ProfileManager.listOfProfile.get(0).getPlayerName());
		playerTwo.setText(ProfileManager.listOfProfile.get(1).getPlayerName());
		playerThree.setText(ProfileManager.listOfProfile.get(2).getPlayerName());
		playerFour.setText(ProfileManager.listOfProfile.get(3).getPlayerName());
	}
	
	@FXML
	void onBackToMainMenuPressed(final MouseEvent event) {
		Main.switchRoot(Menu.getMainMenu());
	}

	@FXML
	void onP1Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		setProfileSelected(0);
		selectController.setProfile();
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP2Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		setProfileSelected(1);
		selectController.setProfile();
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP3Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		setProfileSelected(2);
		selectController.setProfile();
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP4Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		setProfileSelected(3);
		selectController.setProfile();
		Main.switchRoot(Menu.getProfileSelect());
	}
}
