package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;



public class Main extends Application {
	//important to extend Main class with Application for using GUI.
	static Stage pstage;
	static Connection con;
	
	@Override
	public void start(Stage primaryStage) {   //compulsory to use this method after extending class "Application" 
		pstage=primaryStage;
		pstage.getIcons().add(new Image("/application/OIP.png"));
		changeScene("firstshow.fxml","Ensah Bank",600,400);
	}
	
	
	
	public void changeScene(String gui,String title,int width,int height) { //method for changing scene within the same window
		try {
			Parent root=FXMLLoader.load(getClass().getResource(gui));//loading FXML file
			Scene scene = new Scene(root,width,height);  //setting width and height of the window 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //loading CSS file if used
			
			pstage.setScene(scene);  // scene=content inside window
			pstage.setTitle(title); //Title of the window
			pstage.setResizable(false); //Making window non resizable
			pstage.show();  //Showing window to user
		} catch(Exception e) {
			e.printStackTrace();  //Printing Exception
		}
	}
	
	public static void connectDB(String url,String user,String pass) throws SQLException{ //Connecting to database at the start of the program
		con=DriverManager.getConnection(url, user, pass);
		System.out.println(con);
		}
	
	public static void main(String[] args) throws SQLException {
		connectDB("jdbc:mysql://localhost:3306/bank","root",""); //connectDB(url,user,password);
		launch(args);  //Starting GUI
	}
}
