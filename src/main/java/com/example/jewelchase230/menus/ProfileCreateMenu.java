package com.example.jewelchase230.menus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Controller for the create profile menu.
 * 
 * @author Kellie Robinson
 *
 */


public final class ProfileCreateMenu {

	@FXML
	private Button buttonCreateProfile; 
	@FXML 
	private TextField createProfileName;
	
	public String profileCreatedName; 
	
	@FXML
	private Button createProfileMenuButton;
	
	
	@FXML
	void onCreateProfilePressed(final MouseEvent event) { 
		profileCreatedName = createProfileName.getText();
	}
	
	
}
