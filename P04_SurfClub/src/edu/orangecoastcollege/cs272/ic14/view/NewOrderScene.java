package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;

public class NewOrderScene {
	private static Controller controller = Controller.getInstance();
	@FXML
	public Object cancel()
	{
		ViewNavigator.loadScene("Order History", ViewNavigator.ORDER_SCENE);
		return this;
	}

}
