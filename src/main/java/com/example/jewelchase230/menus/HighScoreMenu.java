package com.example.jewelchase230.menus;

import com.example.jewelchase230.LevelFileReader;
import com.example.jewelchase230.Main;

import com.example.jewelchase230.profiles.HighScoreTable;
import com.example.jewelchase230.profiles.LevelHighScores;
import com.example.jewelchase230.profiles.ProfileScore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.scene.Parent;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;

/**
 * High score menu controller.
 *
 * @author Kellie Robinson, Will Kaye
 */
public final class HighScoreMenu {
	/**Button for switching to the next level. */
	@FXML
	private Button nextLevelButton;

	/** Button for switching to the previous level. */
	@FXML
	private Button prevLevelButton;

	/** Label showing what level the scores are from. */
	@FXML
	private Label levelNumLabel;

	/** The previous menu before switching to the high score menu. */
	private Parent previousMenu;

	/** Scores of the level currently being shown. */
	private int levelSelected = 1;

	/** High score table view. */
	@FXML
	private TableView<ProfileScore> hsTable;

	/** Player name column. */
	@FXML
	private TableColumn<ProfileScore, String> playerCol;

	/** High score column. */
	@FXML
	private TableColumn<ProfileScore, Integer> hsCol;

	/** List of the top 10 highest scores. */
	private ObservableList<ProfileScore> list =
			FXCollections.observableArrayList();

	private void showLevelData(final int levelNum) {
		list.remove(0, list.size()); // Removes all elements

		HighScoreTable table = Main.getHighScoreTable();
		LevelHighScores levelScores =
				table.getLevelHighScores(levelNum);
		ProfileScore[] topTen = levelScores.getTopTenHighScores();
		list.addAll(topTen);

		levelNumLabel.setText("Level " + levelNum);
	}

	@FXML
	private void initialize() {
		playerCol.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		hsCol.setCellValueFactory(
				new PropertyValueFactory<>("highestScore"));

		hsTable.setItems(null);
		hsTable.setItems(list);
	}

	@FXML
	void onBackPressed(final MouseEvent event) {
		Main.switchRoot(previousMenu);
	}

	/**
	 * Sets the menu to return to when the back button is pressed.
	 * @param menu The previous menu.
	 */
	public void setPreviousParent(final Parent menu) {
		previousMenu = menu;
		showLevelData(1);
	}

	@FXML
	private void onPrevLevelButtonPressed(final MouseEvent event) {
		levelSelected--;
		if (checkValidLevel(levelSelected)) {
			showLevelData(levelSelected);
		} else {
			levelSelectOutOfBounds();
			levelSelected++;
		}
	}

	@FXML
	private void onNextLevelButtonPressed(final MouseEvent event) {
		levelSelected++;
		if (checkValidLevel(levelSelected)) {
			showLevelData(levelSelected);
		} else {
			levelSelectOutOfBounds();
			levelSelected--;
		}
	}

	/** Displays message when the level doesn't exist. */
	private void levelSelectOutOfBounds() {
		Alert.AlertType type = Alert.AlertType.WARNING;

		Alert alert = new Alert(type, "");

		alert.initModality(Modality.APPLICATION_MODAL);
		alert.getDialogPane().setContentText("Level Out of Bounds");
		alert.getDialogPane()
			.setHeaderText("Cannot select this level: Invalid");

		alert.show();
	}

	private boolean checkValidLevel(final int levelNum) {
		return levelNum > 0
				&& levelNum <= LevelFileReader.getMaxLevel();
	}
}
