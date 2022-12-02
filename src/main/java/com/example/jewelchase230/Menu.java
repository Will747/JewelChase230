package com.example.jewelchase230;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Class containing static functions for getting the parent nodes of any menu in
 * the game.
 *
 * @author Will Kaye, Daniel Clark
 */
public final class Menu {
    // Filenames of all fxml files
    /** Main menu fxml file. */
    private static final String MAIN_MENU_FXML = "main-menu.fxml";
    /** Test menu fxml file. */
    private static final String TEST_MENU_FXML = "test-menu.fxml";
    /** Profile Menu fxml file. */
    private static final String PROFILE_MENU_FXML = "profile-menu.fxml";
    /** Settings Menu fxml file. */
    private static final String SETTINGS_MENU_FXML = "settings-menu.fxml";
    /** HighScore Table Menu fxml file. */
    private static final String HIGHSCORE_TABLE_FXML = "highScore-table.fxml";
    /** Profile Select fxml file. */
    private static final String PROFILE_SELECT_FXML = "profile-select.fxml";


    /** Already created parent nodes. */
    private static HashMap<String, Parent> cachedParents;

    private Menu() {
        
    }

    /**
     * Initializes all scenes and caches them.
     * This must be run before any scenes can be accessed.
     */
    public static void initMenus() throws IOException {
        cachedParents = new HashMap<>();

        createParent(MAIN_MENU_FXML);
        createParent(TEST_MENU_FXML);
        createParent(SETTINGS_MENU_FXML);
        createParent(HIGHSCORE_TABLE_FXML);
        createParent(PROFILE_MENU_FXML);
        createParent(PROFILE_SELECT_FXML);
    }

    /**
     * Creates a new parent node and adds it to the cache.
     * @param fxmlFile fxmlFile that should be in the scene.
     */
    private static void createParent(final String fxmlFile) throws IOException {
        URL url = Menu.class.getResource(fxmlFile);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        cachedParents.put(fxmlFile, fxmlLoader.load());
    }

    /**
     * @return main menu node.
     */
    public static Parent getMainMenu() {
        return getParent(MAIN_MENU_FXML);
    }

    /**
     * @return test menu node.
     */
    public static Parent getTestMenu() {
        return getParent(TEST_MENU_FXML);
    }

    /**
     * @return profile menu node.
     */
    public static Parent getProfileMenu() {
    	return getParent(PROFILE_MENU_FXML);
    }

    /**
     * @return profile menu node.
     */
    public static Parent getProfileSelect() {
    	return getParent(PROFILE_SELECT_FXML);
    }

    /**
     * @return settings menu node.
     */
    public static Parent getSettingsMenu() {
        return getParent(SETTINGS_MENU_FXML);
    }

    /**
     * @return highscores table node.
     */
    public static Parent getHighScoreTable() {
        return getParent(HIGHSCORE_TABLE_FXML);
    }

    /**
     * gets a Scene from the cache.
     * @param fxmlFile fxml file being loaded.
     * @return scene containing menu from fxml file.
     */
    private static Parent getParent(final String fxmlFile) {
        return cachedParents.get(fxmlFile);
    }
}
