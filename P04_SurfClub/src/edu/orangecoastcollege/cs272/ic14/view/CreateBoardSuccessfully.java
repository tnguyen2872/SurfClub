package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;

public class CreateBoardSuccessfully 
{
	private static Controller controller = Controller.getInstance();
	@FXML
	public Object ok()
	{
		ViewNavigator.loadScene("Surfboard Record", ViewNavigator.SURFBOARD_RECORD_SCENE);
		return this;
	}

}
