package edu.orangecoastcollege.cs272.ic14.view;


import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SupplierRecordScene implements Initializable {
	
	private static Controller controller = Controller.getInstance();
	
	@FXML
	public ListView<Supplier> supplierLV;
	@FXML
	private TextField nameTF;
	
	@FXML
	private TextField addressTF;
	
	@FXML
	private TextField cityTF;
	
	@FXML
	private ComboBox<String> stateCB;
	
	@FXML
	private TextField productCategory;
	
	@FXML
	public CheckBox retailCheckBox;
	
	@FXML //for CANCEL BUTTON
	public Object loadBackToMenu()
	{
		ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		return this;
	}
	
	@FXML
	public Object delete()
	{
		
		Supplier selectedItem = supplierLV.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.CONFIRMATION, "Delete " + selectedItem.getName() + " " + selectedItem.getState() + " " + selectedItem.getProductCategory()  + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
		controller.deleteSupplier(supplierLV.getSelectionModel().getSelectedItem());
		}
		
		
		return this;
	}
	@FXML
	public Object loadAddSupplierScene()
	{
		ViewNavigator.loadScene("Add new Supplier", ViewNavigator.ADD_SUPPLIER_SCENE);
		return this;
	}
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		supplierLV.setItems(controller.getAllSuppliers());

	}

}
