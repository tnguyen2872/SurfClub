package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;

public class CreateSuccessScene {
	private static Controller controller = Controller.getInstance();
	@FXML
	public Object ok()
	{
		ViewNavigator.loadScene("Employee", ViewNavigator.EMPLOYEE_SCENE);
		return this;
	}

}
