package com.example.jewelchase230.menus;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 */
public final class LevelSelectMenu {
    /** Profile being used to play the levels. */
    private Profile selectedProfile;

    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void changeLevel(final MouseEvent event) {
        Main.switchRoot(Menu.getLevelSelectMenu());
    }

    //temporary tester
    @FXML
    void levelOne(final MouseEvent event) {
        switchToLevel(1);
    }

    /**
     * @param profile The profile being used.
     */
    public void setProfile(final Profile profile) {
        selectedProfile = profile;
    }

    private void switchToLevel(final int levelNum) {
        Level nextLevel = LevelFileReader.getLevel(1);
        nextLevel.setProfile(selectedProfile);
        Main.setLevel(nextLevel);
        Main.switchToCanvas();
    }
}
