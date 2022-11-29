package com.example.jewelchase230;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Class containing static functions for getting the scene of any menu in the
 * game.
 *
 * @author Will Kaye
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


    /** Already created scenes. */
    private static HashMap<String, Scene> cachedScenes;

    private Menu() {

    }

    /**
     * Initializes all scenes and caches them.
     * This must be run before any scenes can be accessed.
     */
    public static void initMenus() throws IOException {
        cachedScenes = new HashMap<>();

        createScene(MAIN_MENU_FXML);
        createScene(TEST_MENU_FXML);
        createScene(SETTINGS_MENU_FXML);
        createScene(HIGHSCORE_TABLE_FXML);
        //createScene(PROFILE_MENU_FXML);
        //createScene(PROFILE_SELECT_FXML);
    }
    
    /**
     * Creates a new scene and adds it to the cache.
     * @param fxmlFile fxmlFile that should be in the scene.
     */
    private static void createScene(final String fxmlFile) throws IOException {
        URL url = Menu.class.getResource(fxmlFile);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load());
        cachedScenes.put(fxmlFile, scene);
    }

    /**
     * @return main menu scene.
     */
    public static Scene getMainMenu() {
        return getScene(MAIN_MENU_FXML);
    }

    /**
     * @return test menu scene.
     */
    public static Scene getTestMenu() {
        return getScene(TEST_MENU_FXML);
    }

    /**
     * @return profile menu scene.
     */
    public static Scene getProfileMenu() {
    	return getScene(PROFILE_MENU_FXML);
    }

    /**
     * @return settings menu scene.
     */
    public static Scene getSettingsMenu() {
        return getScene(SETTINGS_MENU_FXML);
    }

    /**
     * @return highscores table scene.
     */
    public static Scene getHighScoreTable() {
        return getScene(HIGHSCORE_TABLE_FXML);
    }

    /**
     * gets a Scene from the cache.
     * @param fxmlFile fxml file being loaded.
     * @return scene containing menu from fxml file.
     */
    private static Scene getScene(final String fxmlFile) {
        return cachedScenes.get(fxmlFile);
    }

	/**
	 * @return the cachedScenes
	 */
	public static HashMap<String, Scene> getCachedScenes() {
		return cachedScenes;
	}
}
