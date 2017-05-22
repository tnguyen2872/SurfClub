package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.Surfboard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SurfboardRecordScene implements Initializable {

	private static Controller controller = Controller.getInstance();
	
	@FXML
	public TextField lengthTF;
	
	@FXML
	public TextField  widthTF;
	
	@FXML
	public TextField thicknessTF;
	
	@FXML
	public ComboBox<String> finSetupCB;
	
	@FXML
	public ListView<Surfboard> surfboardsLV;
	
	@FXML
	public Object loadBackToMenu()
	{
		ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		return this;
	}
	
	@FXML
	public Object delete()
	{
		
		Surfboard selectedItem = surfboardsLV.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.CONFIRMATION, "Delete " + selectedItem.getName() + " " + selectedItem.getLength() 
					+ " " + selectedItem.getWidth() + " " + selectedItem.getThickness() + " " + selectedItem.getFins()  + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
		controller.deleteSurfboard(surfboardsLV.getSelectionModel().getSelectedItem());
		}
		return this;
	}
	
	@FXML
	public Object loadAddBoardScene()
	{
		ViewNavigator.loadScene("Add New Surfboard", ViewNavigator.ADD_BOARD_SCENE);
		return this;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
