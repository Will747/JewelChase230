package com.example.jewelchase230;

import com.example.jewelchase230.menus.ProfileMenu;
import com.example.jewelchase230.menus.LevelSelectMenu;
import com.example.jewelchase230.menus.ProfileSelectMenu;
import com.example.jewelchase230.menus.HighScoreMenu;
import com.example.jewelchase230.menus.SettingsMenu;

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
    /**
     * Main menu fxml file.
     */
    private static final String MAIN_MENU_FXML = "main-menu.fxml";
    /**
     * Profile Menu fxml file.
     */
    private static final String PROFILE_MENU_FXML = "profile-menu.fxml";
    /**
     * Settings Menu fxml file.
     */
    private static final String SETTINGS_MENU_FXML = "settings-menu.fxml";
    /**
     * HighScore Table Menu fxml file.
     */
    private static final String HIGHSCORE_TABLE_FXML = "highScore-table.fxml";
    /**
     * Profile Select fxml file.
     */
    private static final String PROFILE_SELECT_FXML = "profile-select.fxml";
    /**
     * Pause menu fxml file.
     */
    private static final String PAUSE_MENU_FXML = "pause-menu.fxml";
    /**
     * Profile creating fxml file.
     */
    private static final String PROFILE_CREATE_MENU_FXML
            = "profile-create-menu.fxml";
    /**
     * Level selecting fxml file.
     */
    private static final String LEVEL_SELECT_MENU_FXML
            = "level-select-menu.fxml";
    /**
     * Game over fxml file.
     */
    private static final String GAME_OVER_FXML = "game-over-menu.fxml";

    /**
     * Already created parent nodes.
     */
    private static HashMap<String, Parent> cachedParents;

    /**
     * Already initialized controllers.
     */
    private static HashMap<String, Object> cachedControllers;

    private Menu() {

    }

    /**
     * Initializes all scenes and caches them.
     * This must be run before any scenes can be accessed.
     */
    public static void initMenus() throws IOException {
        cachedParents = new HashMap<>();
        cachedControllers = new HashMap<>();

        createParent(MAIN_MENU_FXML);
        createParent(SETTINGS_MENU_FXML);
        createParent(HIGHSCORE_TABLE_FXML);
        createParent(PROFILE_MENU_FXML);
        createParent(PROFILE_SELECT_FXML);
        createParent(PAUSE_MENU_FXML);
        createParent(PROFILE_CREATE_MENU_FXML);
        createParent(LEVEL_SELECT_MENU_FXML);
        // createParent(GAME_OVER_FXML);
    }

    /**
     * Creates a new parent node and adds it to the cache.
     *
     * @param fxmlFile fxmlFile that should be in the scene.
     */
    private static void createParent(final String fxmlFile) throws IOException {
        URL url = Menu.class.getResource(fxmlFile);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        cachedParents.put(fxmlFile, fxmlLoader.load());
        cachedControllers.put(fxmlFile, fxmlLoader.getController());
    }

    /**
     * @return main menu node.
     */
    public static Parent getMainMenu() {
        return getParent(MAIN_MENU_FXML);
    }

    /**
     * @return pause menu node.
     */
    public static Parent getPauseMenu() {
        return getParent(PAUSE_MENU_FXML);
    }

    /**
     * @return profile menu node.
     */
    public static Parent getProfileMenu() {
        return getParent(PROFILE_MENU_FXML);
    }

    /**
     * @return menu with one profile.
     */
    public static Parent getProfileSelect() {
        return getParent(PROFILE_SELECT_FXML);
    }

    /**
     * @return menu with all selectable levels.
     */
    public static Parent getLevelSelectMenu() {
        return getParent(LEVEL_SELECT_MENU_FXML);
    }

    /**
     * @return The level select controller.
     */
    public static LevelSelectMenu getLevelSelectController() {
        return (LevelSelectMenu) getController(LEVEL_SELECT_MENU_FXML);
    }

    /*
     * @return Game over menu node.
     */
    /*
    public static Parent getGameOverMenu() {
        return getParent(GAME_OVER_FXML);
    }
    */

    /**
     * @return The profile Menu select controller.
     */
    public static ProfileMenu getProfileMenuController() {
        return (ProfileMenu) getController(PROFILE_MENU_FXML);
    }

    /**
     * @return The profile select controller.
     */
    public static ProfileSelectMenu getProfileSelectController() {
        return (ProfileSelectMenu) getController(PROFILE_SELECT_FXML);
    }

    /**
     * @return The setting menu controller.
     */
    public static SettingsMenu getSettingsMenuController() {
        return (SettingsMenu) getController(SETTINGS_MENU_FXML);
    }

    /**
     * @return The high score table controller
     */
    public static HighScoreMenu getHighScoreMenuController() {
        return (HighScoreMenu) getController(HIGHSCORE_TABLE_FXML);
    }


    /**
     * @return settings menu node.
     */
    public static Parent getSettingsMenu() {
        return getParent(SETTINGS_MENU_FXML);
    }

    /**
     * @return The profile creation node.
     */
    public static Parent getProfileCreateMenu() {
        return getParent(PROFILE_CREATE_MENU_FXML);
    }

    /**
     * @return highscores table node.
     */
    public static Parent getHighScoreTable() {
        return getParent(HIGHSCORE_TABLE_FXML);
    }

    /**
     * Gets a Parent node from the cache.
     *
     * @param fxmlFile fxml file being loaded.
     * @return scene containing menu from fxml file.
     */
    private static Parent getParent(final String fxmlFile) {
        return cachedParents.get(fxmlFile);
    }

    /**
     * Gets a controller from the cache.
     *
     * @param fxmlFile fxml file being loaded.
     * @return controller used by fxml file.
     */
    private static Object getController(final String fxmlFile) {
        return cachedControllers.get(fxmlFile);
    }
}
