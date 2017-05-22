package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.Surfboard;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddBoardScene implements Initializable {

	private static Controller controller = Controller.getInstance();
	private static ObservableList<Surfboard> mAllSurfboardsList = controller.getAllSurfboards();
	@FXML
	private TextField brandTF;
	@FXML
	private TextField lengthTF;
	@FXML
	private TextField widthTF;
	@FXML
	private TextField thicknessTF;
	@FXML
	private TextField finSetupTF;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	public Object createNewSurfboard()
	{
		String brand = brandTF.getText();
		double length = Double.parseDouble(lengthTF.getText());
		double width = Double.parseDouble(widthTF.getText());
		double thickness = Double.parseDouble(thicknessTF.getText());
		String finSetup = finSetupTF.getText();
		
		controller.createNewSurfboard(brand, length, width, thickness, finSetup);
		
		ViewNavigator.loadScene("Added Surfboard Successfully", ViewNavigator.CREATE_BOARD_SUCCESSFULLY_SCENE);
		
		return this;
	}
	
	@FXML
	public Object cancel()
	{
		ViewNavigator.loadScene("Surfboard Records", ViewNavigator.SURFBOARD_RECORD_SCENE);
		return this;
	}
	
	public static void main (String[] args)
	{
		for (Surfboard a : mAllSurfboardsList)
		System.out.println(a);
	}

}
