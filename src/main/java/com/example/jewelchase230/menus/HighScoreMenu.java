package com.example.jewelchase230.menus;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Menu;
import com.example.jewelchase230.profiles.ProfileScore;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    /** This will be assigned 0 if Prev button is clicked, and 1 if Next button is clicked*/ 
    private int navigationSelected;
    
    @FXML
	private TableView hsTable;
	@FXML
	private TableColumn<ProfileScore, String> nameCol;
	
	@FXML
	private TableColumn<ProfileScore, Integer> levelCol;
	
	@FXML 
	private TableColumn<ProfileScore, Integer> hsCol;
	
	private String profileName;
	private int level;
	private int levelScore;
    
	
	public HighScoreMenu() {
	}
    
    //ObservableList<ProfileScore> topTenObservableList = FXCollections.observableArrayList(
    //		new HighScoreMenu ("Hi",2,1000)
    //		); 
    
    
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
    
    public void levelSelectOutOfBounds(){ 
    	Alert.AlertType type = Alert.AlertType.WARNING;

		Alert alert = new Alert(type, "");

		alert.initModality(Modality.APPLICATION_MODAL);
		alert.getDialogPane().setContentText("Level Out of Bounds");
		alert.getDialogPane().setHeaderText("Cannot select this level: Invalid");

		alert.show();
    }
    
    
    
    public boolean isLevelNavigationValid() { 
    	if(navigationSelected == 0 && topTenLevelSelected == 1) { 
    		return false;
    	} else if (navigationSelected == 1 && topTenLevelSelected == 5) { 
    		return false; 
    	} else { 
    		return true;
    	}
    }
    
    
}
