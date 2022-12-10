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

public final class CatSelectMenu {

	 /**
     * Black cat Image in FXML scene.
     */
	@FXML
	private ImageView imgBlackCat; 
	
	/**
	 * Oreo cat Image in FXML scene.
	 */
	@FXML 
	private ImageView imgOreoCat;
	
	/**
	 * Tabby cat Image in FXML scene.
	 */
	@FXML
	private ImageView imgTabbyCat; 
	/**
	 * White cat Image in FXML scene.
	 */
	@FXML
	private ImageView imgWhiteCat;
	/**
	 * Button to navigate back to Profile Creation Menu.
	 */
	@FXML
	private Button catSelectBackButton; 
	
	/**
	 * Char value to record which enum has been chosen for profile's cat colour.
	 */
	private char catIDSelected = 't'; 
	
	
	
	@FXML
    void onCatSelectBackButtonPressed(final MouseEvent event) {
        Main.switchRoot(Menu.getProfileCreateMenu());
    }
	
	
	
	/** NOTE:::
	 * 
	 * The Set Visible would be best called as an array and setting visible to false for all that != current selection
	 */
	
	/**
	 * Selects Black Cat.
	 * @param MouseEvent
	 */
	@FXML
	void blackCatSelected(final MouseEvent event) { 
		catIDSelected = 'b';
		imgOreoCat.setVisible(false);
		imgTabbyCat.setVisible(false);
		imgWhiteCat.setVisible(false);
	}
	/**
	 * Selects Oreo Cat.
	 * @param MouseEvent
	 */
	@FXML
	void oreoCatSelected(final MouseEvent event) { 
		catIDSelected = 'o';
		imgTabbyCat.setVisible(false);
		imgWhiteCat.setVisible(false);
		imgBlackCat.setVisible(false);
	}
	
	/**
	 * Selects Tabby Cat.
	 * @param MouseEvent
	 */
	@FXML
	void tabbyCatSelected(final MouseEvent event) { 
		catIDSelected = 't';
		imgWhiteCat.setVisible(false);
		imgBlackCat.setVisible(false);
		imgOreoCat.setVisible(false);

	}
	
	/**
	 * Selects White Cat.
	 * @param event
	 */
	@FXML 
	void whiteCatSelected(final MouseEvent event){ 
		catIDSelected = 'w';
		imgBlackCat.setVisible(false);
		imgOreoCat.setVisible(false);
		imgTabbyCat.setVisible(false);

	}

	/**
	 * @return the catIDSelected
	 */
	public char getCatIDSelected() {
		return catIDSelected;
	}
}
