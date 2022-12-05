package com.example.jewelchase230.menus;

import java.util.ArrayList;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import com.example.jewelchase230.profiles.ProfileManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Controller for the profile menus - changing scenes.
 *
 * @author Daniel Clark
 */
public final class ProfileMenu {

	@FXML
	private Label playerOneLabel;

	@FXML
	private Label playerTwoLabel;

	@FXML
	private Label playerThreeLabel;

	@FXML
	private Label playerFourLabel;

	@FXML
	private Pane playerOnePane;
	@FXML
	private Pane playerTwoPane;
	@FXML
	private Pane playerThreePane;
	@FXML
	private Pane playerFourPane;

	private Profile player1;
	private Profile player2;
	private Profile player3;
	private Profile player4;
	
	static ArrayList<Profile> profileList = new ArrayList<Profile>();

	@FXML
	private void initialize() {

		refresh();

	}

	public void refresh() {
		 profileList = ProfileManager.getListOfProfile();

		playerOneLabel.setText(profileList.get(0).getPlayerName());
		player1 = profileList.get(0);
		if (profileList.size() > 1) {
			playerTwoLabel.setText(profileList.get(1).getPlayerName());
			player2 = profileList.get(1);
			if (profileList.size() > 2) {
				playerThreeLabel.setText(profileList.get(2).getPlayerName());
				player3 = profileList.get(2);
				if (profileList.size() > 3) {
					playerFourLabel.setText(profileList.get(3).getPlayerName());
					player4 = profileList.get(3);

				}
			}
		}

		if (profileList.size() < 4) {
			playerFourPane.setVisible(false);
			if (profileList.size() < 3) {
				playerThreePane.setVisible(false);
				if (profileList.size() < 2) {
					playerTwoPane.setVisible(false);
					if (profileList.size() < 1) {
						playerOnePane.setVisible(false);

					}

				}
			}
		}

	}

	@FXML
	void onBackToMainMenuPressed(final MouseEvent event) {
		Main.switchRoot(Menu.getMainMenu());
	}
	
	@FXML
	void onProfileCreateMenuPressed(final MouseEvent event) { 
		Main.switchRoot(Menu.getProfileCreateMenu());
	}

	@FXML
	void onP1Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		selectController.setProfile(player1);
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP2Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		selectController.setProfile(player2);
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP3Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		selectController.setProfile(player3);
		Main.switchRoot(Menu.getProfileSelect());
	}

	@FXML
	void onP4Pressed(final MouseEvent event) {
		ProfileSelectMenu selectController = Menu.getProfileSelectController();
		selectController.setProfile(player4);
		Main.switchRoot(Menu.getProfileSelect());
	}

	/**
	 * @return the profileList
	 */
	public ArrayList<Profile> getProfileList() {
		return profileList;
	}
}
