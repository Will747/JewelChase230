package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Settings;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 */
public final class SettingsMenu {
    /** Holds all saved settings. */
    private Settings settings;

    /** Music volume slider. */
    @FXML
    private Slider music;

    /** Sound effects volume slider. */
    @FXML
    private Slider sfx;

    /** Full screen checkbox. */
    @FXML
    private CheckBox fullScreen;

    /** Previous menu. */
    private Parent previousMenu;

    @FXML
    private void initialize() {
        settings = Main.getSettings();

        // Set all controls with values from settings file
        music.adjustValue(settings.getMusicVolume());
        sfx.adjustValue(settings.getSfxVolume());
        fullScreen.setSelected(settings.isFullScreen());

        // Set all triggers
        music.valueProperty().addListener(e -> onMusicVolumeChanged());
        sfx.valueProperty().addListener(e -> onSfxChanged());
        fullScreen.selectedProperty().addListener(e -> onFullScreenChanged());
    }

    private void onMusicVolumeChanged() {
        settings.setMusicVolume(music.getValue());
    }

    private void onSfxChanged() {
        settings.setSfxVolume(sfx.getValue());
    }

    private void onFullScreenChanged() {
        settings.setFullScreen(fullScreen.isSelected());
    }

    /**
     * Sets the menu used before this one.
     * @param menu The menu to switch to when back button is pressed.
     */
    public void setPreviousParent(final Parent menu) {
        previousMenu = menu;
    }

    @FXML
    void onBackPressed(final MouseEvent event) {
        Main.switchRoot(previousMenu);
    }
}
