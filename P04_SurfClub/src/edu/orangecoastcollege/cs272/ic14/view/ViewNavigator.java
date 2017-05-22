package edu.orangecoastcollege.cs272.ic14.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {
	public static final String SIGN_UP_SCENE = "SignUpScene.fxml";
	public static final String SIGN_IN_SCENE = "SignInScene.fxml";
	public static final String MENU_SCENE = "menu.fxml";
	public static final String VIEW_INVENTORY_SCENE = "ViewInventoryScene.fxml";
	public static final String EMPLOYEE_SCENE = "Employee.fxml";

//<<<<<<< HEAD
	public static final String SURFBOARD_RECORD_SCENE = "SurfboardRecordScene.fxml"; //
	public static final String ADD_BOARD_SCENE = "AddBoardScene.fxml"; //
	public static final String CREATE_BOARD_SUCCESSFULLY_SCENE = "CreateBoardSuccessfully.fxml"; //
	public static final String ADD_SUPPLIER_SCENE = "AddSupplierScene.fxml"; //
	public static final String SUPPLIER_RECORD_SCENE = "SupplierRecordScene.fxml"; //
	public static final String CREATE_SUPPLIER_SUCCESSFULLY_SCENE = "CreateSupplierSuccessfully.fxml";
	
//=======
	public static final String ORDER_SCENE = "Order.fxml";
	public static final String NEW_ORDER_SCENE = "NewOrder.fxml";
//>>>>>>> branch 'master' of https://github.com/tnguyen2872/SurfClub.git
	
	public static final String ADD_EMPLOYEE_SCENE = "AddEmployee.fxml";
	
	public static final String CREATE_SUCCESS_SCENE = "CreateSuccess.fxml";
	public static Stage mainStage;

	public static void setStage(Stage stage) {
		mainStage = stage;
	}

	public static void loadScene(String title, String sceneFXML) {

		try {
			mainStage.setTitle(title);
			Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
			mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

}
