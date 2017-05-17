package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignInScene {

	private static Controller controller = Controller.getInstance();

	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signInErrorLabel;


	@FXML
	public Object signIn() {

		String email = emailAddressTF.getText();
		String password = passwordTF.getText();
		if(email.isEmpty())
		    emailErrorLabel.setVisible(true);
		if(password.isEmpty())
		    passwordErrorLabel.setVisible(true);
		if(emailErrorLabel.isVisible()|| passwordErrorLabel.isVisible())
		    return null;

		// Assume the mail and password are validated:
		// Let's use controller to sign in (check username and password)

		String result = controller.signInUser(email, password);
		if ("SUCCESS".equalsIgnoreCase(result))
		{
		    ViewNavigator.loadScene("Menu", ViewNavigator.MENU_SCENE);
		}
		else
		{
		    signInErrorLabel.setText(result);
		    signInErrorLabel.setVisible(true);

		}
		return null;
	}

	@FXML
	public Object loadSignUp()
	{
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
		return this;
	}

}
