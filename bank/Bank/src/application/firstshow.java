package application;



import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class firstshow
{
	@FXML 
	Label creators;
	@FXML
	TextField tUsername;
	@FXML
	PasswordField tPassword;
	@FXML
	TextField tEmail;
	static Customer customer;
	
	public void signUp() {
		
		new Main().changeScene("SignUp.fxml", "Sign Up", 600, 400);
	}
	
	public void signIn() {
		new Main().changeScene("SignIn.fxml", "Sign In", 600, 400);
	}
	
	public void about() {
		if(creators.getOpacity()==1)  creators.setOpacity(0);
		else creators.setOpacity(1);
	}

}
