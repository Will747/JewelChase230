package com.example.jewelchase230.menus;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.profiles.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Test menu to test out switching between menus.
 *
 * @author Will Kaye
 * @author Kellie Robinson
 */
public final class HighScoreMenu {

	@FXML
	private Button nextLevelButton;
	@FXML
	private Button prevLevelButton;

	private Parent previousMenu;
	private int topTenLevelSelected = 1;
	/**
	 * This will be assigned 0 if Prev button is clicked, and 1 if Next button is
	 * clicked
	 */
	private int navigationSelected;

	@FXML
	private TableView<ProfileScore> hsTable;

	@FXML
	private TableColumn<ProfileScore, String> playerCol;

	@FXML
	private TableColumn<ProfileScore, Integer> levelCol;

	@FXML
	private TableColumn<ProfileScore, Integer> hsCol;
	
	
/*
	ObservableList<ProfileScore> list = FXCollections.observableArrayList(
		new	ProfileScore (600,7,"Poo", 3),
		new ProfileScore(400,1,"hi", 4),
		new	ProfileScore (5600,2,"gksfg",6),
		new	ProfileScore (6000,2,"Cos",6),
		new	ProfileScore (5700,2,"Adam",6),
		new	ProfileScore (9000,2,"Will",6),
		new	ProfileScore (7500,2,"Me",6),

		new	ProfileScore (5000,2,"Ben",6)
	);
	*/

	@FXML
	private void initialize() {
		playerCol.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		levelCol.setCellValueFactory(
				new PropertyValueFactory<>("currentLevel"));
		hsCol.setCellValueFactory(
				new PropertyValueFactory<>("highestScore"));

		hsTable.setItems(null);
		//hsTable.setItems(list);
	}

	@FXML
	void onBackPressed(final MouseEvent event) {
		Main.switchRoot(previousMenu);
	}

	public void setPreviousParent(Parent menu) {
		previousMenu = menu;
	}

	@FXML
	public void onPrevLevelButtonPressed(final MouseEvent event) {
		navigationSelected = 0;
		if (!isLevelNavigationValid()) {
			levelSelectOutOfBounds();
		} else {
			topTenLevelSelected = (topTenLevelSelected - 1);
		}
	}

	@FXML
	public void onNextLevelButtonPressed(final MouseEvent event) {
		navigationSelected = 1;
		if (!isLevelNavigationValid()) {
			levelSelectOutOfBounds();
		} else {
			topTenLevelSelected = (topTenLevelSelected + 1);
		}
	}

	public void levelSelectOutOfBounds() {
		Alert.AlertType type = Alert.AlertType.WARNING;

		Alert alert = new Alert(type, "");

		alert.initModality(Modality.APPLICATION_MODAL);
		alert.getDialogPane().setContentText("Level Out of Bounds");
		alert.getDialogPane().setHeaderText("Cannot select this level: Invalid");

		alert.show();
	}

	public boolean isLevelNavigationValid() {
		if (navigationSelected == 0 && topTenLevelSelected == 1) {
			return false;
		} else if (navigationSelected == 1 && topTenLevelSelected == 5) {
			return false;
		} else {
			return true;
		}
	}

}
