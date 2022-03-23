package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import application.creditinfo; 



import javafx.fxml.FXMLLoader;

import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.Scene;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Login {
	static int id;
	@FXML
	TextField username;
	@FXML
	TextField password;
	
    
	
	
	public void signIn() throws IOException{
		
		
		try {
		String query1="Select id,password from bank.login where username='"+username.getText()+"' OR email='"+username.getText()+"';";
		Statement st=Main.con.createStatement();
		ResultSet rs=st.executeQuery(query1);
		rs.next();
		String dbpassword=rs.getString(2);
		
		if(dbpassword.contentEquals(password.getText())) {
			System.out.println("Right password");
			id=rs.getInt(1);
			new Main().changeScene("Menu.fxml", "Ensah Bank", 600, 400);}
			else {
				
				Stage window=new Stage(); 
				window.initModality(Modality.APPLICATION_MODAL);
				window.setTitle("Error");
				window.setMinWidth(250);
				window.setResizable(false);
				
				
				Scene scene=new Scene(FXMLLoader.load(getClass().getResource("incorr.fxml")),300,140);
				window.setScene(scene);
				window.showAndWait();
				password.setText("");
				
				
			System.out.println("Check username and password");
			
						
			
		}
		}
		catch(SQLException sqlException) {
			Stage window=new Stage(); 
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Error");
			window.setMinWidth(250);
			window.setResizable(false);
			
			
			Scene scene=new Scene(FXMLLoader.load(getClass().getResource("incorr.fxml")),300,140);
			window.setScene(scene);
			window.showAndWait();
			password.setText("");
			username.setText("");
			
		System.out.println("Check username");
		}
	}
	
	public void back() {
		new Main().changeScene("firstshow.fxml","Ensah Bank",600,400);
	}
	
	static public Customer downloadObj(int id) throws SQLException{
		
		String query2="Select * from bank.information where id='"+id+"';";
		Statement st=Main.con.createStatement();
		st.executeQuery(query2);
		ResultSet rs=st.executeQuery(query2);
		rs.next();
		String username=rs.getString(2);
		String fname=rs.getString(3);
		
		String lname=rs.getString(4); 
		String phoneno=rs.getString(5);
		String email=rs.getString(6);
		String dob=rs.getString(7);
		String gender=rs.getString(8);
		Float balance=rs.getFloat(9);
		Float credit=rs.getFloat(10);
		String Statutc=rs.getString(11);
		Customer c=new Customer(username, fname, lname, phoneno, email, dob, gender,balance,credit,Statutc);
		
		return c;
	}
	
	
}
