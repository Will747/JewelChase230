package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/** 
 * Controller for choosing a cat image upon profile creation.
 * @author Kellie Robinson
 *
 */

public class CatSelectMenu {

	@FXML
	private ImageView imgBlackCat; 
	
	@FXML 
	private ImageView imgOreoCat;
	
	@FXML
	private ImageView imgTabbyCat; 
	
	@FXML
	private ImageView imgWhiteCat;
	
	@FXML
	private Button catSelectBackButton; 
	
	private char catIDSelected = 't'; 
	
	
	
	@FXML
    void onCatSelectBackButtonPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileCreateMenu());
    }
	
	@FXML
	void blackCatSelected(final MouseEvent event) { 
		catIDSelected = 'b';
	}
	
	@FXML
	void oreoCatSelected(final MouseEvent event) { 
		catIDSelected = 'o';
	}
	
	@FXML
	void tabbyCatSelected(final MouseEvent event) { 
		catIDSelected = 't';
	}
	
	@FXML 
	void whiteCatSelected(final MouseEvent event){ 
		catIDSelected = 'w';
	}
}
