package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;

public class MenuScene {
	private static Controller controller;
	@FXML
	public Object loadSignOut()
	{
		ViewNavigator.loadScene("Welcome to Surf Club", ViewNavigator.SIGN_IN_SCENE);
		return this;
	}
	@FXML
	public Object loadEmployeeScene()
	{
		ViewNavigator.loadScene("Employee", ViewNavigator.EMPLOYEE_SCENE);
		return this;
	}
	@FXML
	public Object loadOrderScene()
	{
		ViewNavigator.loadScene("Order History", ViewNavigator.ORDER_SCENE);
		return this;
	}

}
