package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;

public class CreateSupplierSuccessfullyScene 
{
	private static Controller controller = Controller.getInstance();
	@FXML
	public Object ok()
	{
		ViewNavigator.loadScene("Supplier Record", ViewNavigator.SUPPLIER_RECORD_SCENE);
		return this;
	}
}
