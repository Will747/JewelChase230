package com.example.jewelchase230.menus;
import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


/**
 * The class for the game over screen
 * @author Adam Smith
 */
public class GameOverMenu {
    /**
     * Exits a game back to the main menu.
     */
    @FXML
    private void onReturnToMainMenuPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getMainMenu());
    }
}
