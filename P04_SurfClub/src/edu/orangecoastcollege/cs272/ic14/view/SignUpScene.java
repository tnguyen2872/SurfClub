package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpScene {

	private static Controller controller = Controller.getInstance();

	@FXML
	private TextField nameTF;
	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signUpErrorLabel;

	@FXML
	public Object signUp() {

	    String name = nameTF.getText();
	    String email = emailAddressTF.getText();
	    String password = passwordTF.getText();
		String result = controller.signUpUser(name, email, password);
		if (result.equalsIgnoreCase("SUCCESS"))
		    ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		else
		{
		    signUpErrorLabel.setText(result);
		    signUpErrorLabel.setVisible(true);

		}
		return this;
	}

	@FXML
	public Object loadSignIn()
	{
		ViewNavigator.loadScene("Sign in", ViewNavigator.SIGN_IN_SCENE);
		return this;
	}

}
