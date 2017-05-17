package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.DBModel;
import edu.orangecoastcollege.cs272.ic14.model.Employee;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddEmployeeScene implements Initializable{
	private static Controller controller = Controller.getInstance();
	
	
	private static ObservableList<String> mAllPositionsList = controller.getAllPositions();
	@FXML
	private TextField firstNameTF;
	@FXML
	private TextField lastNameTF;
	@FXML
	private ComboBox<String> positionCB;
	@FXML
	private DatePicker dateHiredDP;
	@FXML
	private ComboBox<String> genderCB;
	@FXML 
	private TextField ssnTF;
	@FXML 
	private TextField wageTF;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		positionCB.setItems(controller.getAllPositions());
		genderCB.setItems(controller.getGender());
		
	}
	
	@FXML
	public Object createNewEmployee()
	{ 
		String firstName = firstNameTF.getText();
		
		String lastName = lastNameTF.getText();
		
		String position = positionCB.getSelectionModel().getSelectedItem();
		
		String dateHired = dateHiredDP.getValue().toString();
		String gender = genderCB.getSelectionModel().getSelectedItem();
		String ssn = ssnTF.getText();
		double wage = Double.parseDouble(wageTF.getText());
		controller.createNewEmployee(firstName, lastName, position, dateHired, gender, ssn, wage);
		
		
		ViewNavigator.loadScene("Notifications", ViewNavigator.CREATE_SUCCESS_SCENE);
		return this;
	}
	@FXML
	public Object cancel()
	{
		ViewNavigator.loadScene("Employee", ViewNavigator.EMPLOYEE_SCENE);
		return this;
	}
	
	public static void main (String[] args)
	{
		for (String a : mAllPositionsList)
		System.out.println(a);
	}

}
