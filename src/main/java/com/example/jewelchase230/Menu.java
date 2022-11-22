package com.example.jewelchase230;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class containing static functions for getting the scene of any menu in the game.
 *
 * @author Will Kaye
 */
public class Menu {
    // Filenames of all fxml files
    private static final String MAIN_MENU_FXML = "main-menu.fxml";
    private static final String TEST_MENU_FXML = "test-menu.fxml";

    // Already created scenes
    private static HashMap<String, Scene> CachedScenes;

    /**
     * Initializes all scenes and caches them.
     * This must be run before any scenes can be accessed.
     */
    public static void initMenus() throws IOException {
        CachedScenes = new HashMap<>();

        createScene(MAIN_MENU_FXML);
        createScene(TEST_MENU_FXML);
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
     * gets a Scene from the cache.
     * @param fxmlFile fxml file being loaded.
     * @return scene containing menu from fxml file.
     */
    private static Scene getScene(String fxmlFile) {
        return CachedScenes.get(fxmlFile);
    }

    /**
     * Creates a new scene and adds it to the cache.
     * @param fxmlFile fxmlFile that should be in the scene.
     */
    private static void createScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        CachedScenes.put(fxmlFile, scene);
    }
}
