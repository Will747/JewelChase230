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
    /**
     * The maximum number of profiles shown by this menu.
     */
    public static final int MAX_NUM_OF_PROFILES = 4;

    /**
     * Player 1 Label.
     */
    @FXML
    private Label playerOneLabel;

    /**
     * Player 2 Label.
     */
    @FXML
    private Label playerTwoLabel;

    /**
     * Player 3 Label.
     */
    @FXML
    private Label playerThreeLabel;

    /**
     * Player 4 Label.
     */
    @FXML
    private Label playerFourLabel;

    /**
     * Player 1 Pane.
     */
    @FXML
    private Pane playerOnePane;

    /**
     * Player 2 Pane.
     */
    @FXML
    private Pane playerTwoPane;

    /**
     * Player 3 Pane.
     */
    @FXML
    private Pane playerThreePane;

    /**
     * Player 4 Pane.
     */
    @FXML
    private Pane playerFourPane;

    /**
     * Player 1 profile.
     */
    private Profile player1;

    /**
     * Player 2 profile.
     */
    private Profile player2;

    /**
     * Payer 3 profile.
     */
    private Profile player3;

    /**
     * Player 4 profile.
     */
    private Profile player4;

    /**
     * List of profiles.
     */
    private static ArrayList<Profile> profileList = new ArrayList<>();

    @FXML
    private void initialize() {

        refresh();

    }

    /**
     * Updates all labels with the latest profiles.
     */
    public void refresh() {
        profileList = ProfileManager.getListOfProfile();

        int i = 0;
        if (profileList.size() > i) {
            playerOneLabel.setText(profileList.get(i).getPlayerName());
            player1 = profileList.get(i);
            i++;
            if (profileList.size() > i) {
                playerTwoLabel.setText(profileList.get(i).getPlayerName());
                player2 = profileList.get(i);
                i++;
                if (profileList.size() > i) {
                    playerThreeLabel.setText(profileList.get(i)
                            .getPlayerName());
                    player3 = profileList.get(i);
                    i++;
                    if (profileList.size() > i) {
                        playerFourLabel.setText(profileList.get(i)
                                .getPlayerName());
                        player4 = profileList.get(i);

                    }
                }
            }
        }

        i = MAX_NUM_OF_PROFILES;
        if (profileList.size() < i) {
            playerFourPane.setVisible(false);
            i--;
            if (profileList.size() < i) {
                playerThreePane.setVisible(false);
                i--;
                if (profileList.size() < i) {
                    playerTwoPane.setVisible(false);
                    playerOnePane.setVisible(profileList.size() >= 1);
                } else {
                    playerTwoPane.setVisible(true);
                }
            } else {
                playerThreePane.setVisible(true);
            }
        } else {
            playerFourPane.setVisible(true);
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
