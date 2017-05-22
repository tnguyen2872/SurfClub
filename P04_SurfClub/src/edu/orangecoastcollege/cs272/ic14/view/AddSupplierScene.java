package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.Supplier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddSupplierScene {

	private static Controller controller = Controller.getInstance();
	private static ObservableList<Supplier> mAllSuppliersList = controller.getAllSuppliers();
	@FXML
	private TextField nameTF;
	@FXML
	private TextField addressTF;
	@FXML
	private TextField cityTF;
	@FXML
	private TextField stateTF;
	@FXML
	private TextField categoryTF;
	
	
	@FXML
	public Object createNewSurfboard()
	{
		String name = nameTF.getText();
		String address = addressTF.getText();
		String city = cityTF.getText();
		String state = stateTF.getText();
		String category = categoryTF.getText();
		
		controller.createNewSupplier(name, address, city, state, category);
		
		ViewNavigator.loadScene("Added new Supplier Successfully", ViewNavigator.CREATE_SUPPLIER_SUCCESSFULLY_SCENE);
		
		return this;
	}
	
	@FXML
	public Object cancel()
	{
		ViewNavigator.loadScene("Supplier Records", ViewNavigator.SUPPLIER_RECORD_SCENE);
		return this;
	}
	
	public static void main (String[] args)
	{
		for (Supplier a : mAllSuppliersList)
		System.out.println(a);
	}

}
