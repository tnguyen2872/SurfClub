package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class OrderScene implements Initializable {
	private static Controller controller = Controller.getInstance();
	@FXML
	private ListView orderLV;
	
	@FXML
	private Button addOrder;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		orderLV.setItems(controller.getAllOrders());
		
	}
	@FXML
	public Object backToMenu()
	{
		ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		return this;
	}
	@FXML
	public Object newOrder()
	{
		ViewNavigator.loadScene("New Order", ViewNavigator.NEW_ORDER_SCENE);
		return this;
	}
	
	
	

}
