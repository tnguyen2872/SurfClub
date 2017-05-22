package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EmployeeScene implements Initializable{
	private static Controller controller = Controller.getInstance();
//	public Object 
	@FXML
	public ComboBox<String> positionCB;
	@FXML
	public ListView<Employee> employeeLV;
	@FXML
	public Button deleteButton;
	@FXML
	public Button addButton;
	@FXML
	public TextField searchTF;
	@FXML
	public Object loadBackToMenu()
	{
		ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		return this;
	}
	@FXML
	public Object delete()
	{
		
		Employee selectedItem = employeeLV.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.CONFIRMATION, "Delete " + selectedItem.getPosition() + " " + selectedItem.getFirstName() + " " + selectedItem.getLastName()  + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
		controller.deleteEmployee(employeeLV.getSelectionModel().getSelectedItem());
		}
		
		
		return this;
	}
	@FXML
	public Object loadAddEmployeeScene()
	{
		ViewNavigator.loadScene("Add new Employee", ViewNavigator.ADD_EMPLOYEE_SCENE);
		return this;
	}
//	@FXML
//	public Object search()
//	{
//		String keyword = searchTF.getText();
//		employeeLV.setItems(controller.filter(keyword));
//		
//		
//		return this;
//	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		positionCB.setItems(controller.getAllPositions());
		employeeLV.setItems(controller.getAllEmployees());
		
		
	}
	
	

}
