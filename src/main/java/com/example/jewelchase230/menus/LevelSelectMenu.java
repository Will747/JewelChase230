package com.example.jewelchase230.menus;

import com.example.jewelchase230.Level;
import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Daniel Clark, Will Kaye
 */

public final class LevelSelectMenu {
    /** Profile being used to play the levels. */
    private Profile selectedProfile;

    //@FXML
    //private ImageView lvl2;
    //@FXML
    //private ImageView lvl3;
    //@FXML
    //private ImageView lvl4;
    //@FXML
    //private ImageView lvl5;
    //@FXML
    //private ImageView lvl6;
    //@FXML
    //private ImageView lvl7;
    //@FXML
    //private ImageView lvl8;
    //@FXML
    //private ImageView lvl9;
    //@FXML
    //private ImageView lvl10;

    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileSelect());
    }

    @FXML
    void changeLevel(final MouseEvent event) {
        int btnNum = Integer.parseInt(((Button)event.getSource()).getText());
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
    }

    private void switchToLevel(final int levelNum) {
        Level nextLevel = LevelFileReader.getLevel(levelNum);
        nextLevel.setProfile(selectedProfile);
        Main.setLevel(nextLevel);
        Main.switchToCanvas();
    }
    
}
