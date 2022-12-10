package com.example.jewelchase230.menus;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Daniel Clark, Will Kaye
 */

public final class LevelSelectMenu {
    /**
     * The number of levels shown on this menu.
     */
    private static final int NUM_OF_LEVELS = 10;

    /**
     * Profile being used to play the levels.
     */
    private Profile selectedProfile;

    /**
     * Level 2 view.
     */
    @FXML
    private ImageView lvl2;

    /**
     * Level 3 view.
     */
    @FXML
    private ImageView lvl3;

    /**
     * Level 4 view.
     */
    @FXML
    private ImageView lvl4;

    /**
     * Level 5 view.
     */
    @FXML
    private ImageView lvl5;

    /**
     * Level 6 view.
     */
    @FXML
    private ImageView lvl6;

    /**
     * Level 7 view.
     */
    @FXML
    private ImageView lvl7;

    /**
     * Level 8 view.
     */
    @FXML
    private ImageView lvl8;

    /**
     * Level 9 view.
     */
    @FXML
    private ImageView lvl9;

    /**
     * Level 10 view.
     */
    @FXML
    private ImageView lvl10;

    private ImageView[] getImageViews() {
        ImageView[] imageViews = new ImageView[NUM_OF_LEVELS - 1];
        int i = 0;
        imageViews[i++] = lvl2;
        imageViews[i++] = lvl3;
        imageViews[i++] = lvl4;
        imageViews[i++] = lvl5;
        imageViews[i++] = lvl6;
        imageViews[i++] = lvl7;
        imageViews[i++] = lvl8;
        imageViews[i++] = lvl9;
        imageViews[i] = lvl10;
        return (imageViews);
    }

    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void changeLevel(final MouseEvent event) {
        int btnNum = Integer.parseInt(((Button) event.getSource()).getText());
        System.out.println(btnNum);
        switchToLevel(btnNum);
    }

    /*temporary tester
    @FXML
    void levelOne(final MouseEvent event) {
        switchToLevel(1);
    }*/

    /**
     * @param profile The profile being used.
     */
    public void setProfile(final Profile profile) {
        selectedProfile = profile;
        levelUnlock();
    }

    private void switchToLevel(final int levelNum) {
        Level nextLevel = LevelFileReader.getLevel(levelNum);
        Main.setLevel(nextLevel, selectedProfile);
        Main.switchToCanvas();
    }

    private void levelUnlock() {
        ImageView[] imageViews = getImageViews();
        int playerLvl = selectedProfile.getLevelReached();
        for (int i = 2; i < NUM_OF_LEVELS + 1; i++) {
            imageViews[i - 2].setVisible(true);
            if (playerLvl >= i) {
                imageViews[i - 2].setVisible(false);
            }
        }
    }
}
