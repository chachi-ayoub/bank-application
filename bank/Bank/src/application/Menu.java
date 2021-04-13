package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Modality;
import javafx.stage.Stage;
import application.creditinfo;
import application.operation;

public class Menu implements Initializable{
	

   

	@FXML
	Label username;
	@FXML
	Label id;
	@FXML
	Label username2;
	@FXML
	Label id2;
	@FXML
	Label username3;
	@FXML
	Label id3;
	@FXML
	
	Label username4;
	@FXML
	Label id4;
	@FXML
	Label username1;
	@FXML
	Label id1;
	@FXML
	Label username5;
	@FXML
	Label id5;
	@FXML
	Label balance;
	@FXML
	Label datef;
	@FXML
	Label balance1;
	@FXML
	Label balance2;
	@FXML
	Label pmonth3;
	 @FXML
	    TableView<operation> table;

	    @FXML
	    TableColumn<operation, Integer> ido;
	    

	    @FXML
	    TableColumn<operation, String> nameo;

	    @FXML
	     TableColumn<operation, String> lnameo;

	    @FXML
	     TableColumn<operation, String> typeo;

	    @FXML
	     TableColumn<operation, String> dateo;

	    @FXML
	     TableColumn<operation, Float> amounto;
	    
         public ObservableList<operation> data=FXCollections.observableArrayList();
	
	@FXML
	TextField deposit;
	@FXML
	TextField withdraw;
	@FXML
	TextField fname;
	
	@FXML
	Label rmonth3;
	@FXML
	Label rloan3;
	@FXML
	TextField lname;
	@FXML
	TextField phoneno;
	@FXML
	TextField email;
	@FXML
	DatePicker dob;
	@FXML
	ComboBox<String> gender;
	@FXML
	TextField Credit;
	@FXML
	TextField tId;
	@FXML
	TextField tAmount;
	@FXML
	ComboBox<String> INSTALLMENT;
	
	Customer c;
	creditinfo cr;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			c=Login.downloadObj(Login.id);
		    
			username.setText(c.getUsername());
			id.setText(Login.id+"");
			username3.setText(c.getUsername());
			id3.setText(Login.id+"");
			username5.setText(c.getUsername());
			id5.setText(Login.id+"");
			
			username2.setText(c.getUsername());
			id2.setText(Login.id+"");
			username4.setText(c.getUsername());
			id4.setText(Login.id+"");
			username1.setText(c.getUsername());
			id1.setText(Login.id+"");
			balance.setText(c.getBalance()+"");
			balance1.setText(c.getBalance()+"");
			balance2.setText(c.getBalance()+"");
			fname.setText(c.getFname());
			Credit.setText("");
			lname.setText(c.getLname());
			phoneno.setText(c.getPhoneno());
			email.setText(c.getEmail());
			dob.setValue(LocalDate.parse(c.getDob()));
			gender.setItems(FXCollections.observableArrayList("Male","Female"));
			INSTALLMENT.setItems(FXCollections.observableArrayList("6","8","10","12","14","16","18","20","22","24","48"));
			gender.setValue(c.getGender());
			String query6="Select * from `bank`.`information`  WHERE (`id` = '"+Login.id+"');";
			Statement st6=Main.con.createStatement();
			ResultSet rs6=st6.executeQuery(query6);
			rs6.next();
			String status=rs6.getString(11);
			if(status.contentEquals("NeverCredited")) {
				cr=new creditinfo(0.f,0.f,0.f);
				c.setCr(cr);
				
				rmonth3.setText("0"+" "+"Months");
				rloan3.setText("0"+" "+"MAD");
				pmonth3.setText("0"+" "+"MAD");
				datef.setText("");
				}
			else {
				String query7="Select * from `bank`.`credits`  WHERE (`id` = '"+Login.id+"');";
				Statement st7=Main.con.createStatement();
				ResultSet rs7=st7.executeQuery(query7);
				rs7.next();
				cr=new creditinfo(rs7.getFloat(3),rs7.getFloat(4),rs7.getFloat(5));
				c.setCr(cr);
				c.setCredit(rs6.getFloat(10));
				rmonth3.setText(rs7.getString(3)+" "+"Months");
				rloan3.setText(rs7.getString(4)+" "+"MAD");
				pmonth3.setText(rs7.getString(5)+" "+"MAD");
				datef.setText(rs7.getString(6));
			}
			
			
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("aaaa");
			
			e.printStackTrace();
		}
		
	}
	
	//Deposit
	public void dAdd(float rs) throws SQLException {
		deposit.setText(Float.toString(Float.parseFloat(deposit.getText())+rs));
		String pattern = "MM/dd/yyyy HH:mm:ss";

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);

		// Get the today date using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String todayAsString = df.format(today);

		// Print the result!
		System.out.println("Today is: " + todayAsString);
		String query="INSERT INTO `bank`.`operations` VALUES(NULL,'"+Login.id+"','"+c.getFname()+"','"+c.getLname()+"','"+"Deposite"+"','"+todayAsString+"',"+rs+");";
		PreparedStatement ps=Main.con.prepareStatement(query);
		ps.executeUpdate();
	}
	
	public void dAdd100() throws SQLException {
		dAdd(100);
	}
	
	public void dAdd200() throws SQLException {
		dAdd(200);
	}

	public void dAdd500() throws SQLException {
		dAdd(500);
	}

	public void dAdd1000() throws SQLException {
		dAdd(1000);
	}
	
	public void dAdd2000() throws SQLException {
		dAdd(2000);
	}
	
	public void dAdd3000() throws SQLException {
		dAdd(3000);
	}
	public void dAdd5000() throws SQLException {
		dAdd(5000);
	}
	public void dAdd10000() throws SQLException {
		dAdd(10000);
	}
	
	public void reset() {
		deposit.setText(0+"");
		withdraw.setText(0+"");
	}
	
	public void dProceed() throws SQLException {
		float depositMoney=Float.parseFloat(deposit.getText());
		float total=c.getBalance()+depositMoney;
		c.setBalance(total);
		String query="UPDATE `bank`.`information` SET `Balance` = '"+total+"' WHERE (`Id` = '"+Login.id+"');";
		Statement st=Main.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			
			System.out.println(c.getBalance());
			balance.setText(c.getBalance()+"");
			balance1.setText(c.getBalance()+"");
			System.out.println(balance.getText());
			
			deposit.setText(0+"");
		}
		else {
			System.out.println("problem");
		}
	}
	
	
	//Withdraw
	public void wAdd(float rs) throws SQLException {
		withdraw.setText(Float.toString(Float.parseFloat(withdraw.getText())+rs));
		String pattern = "MM/dd/yyyy HH:mm:ss";

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);

		// Get the today date using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String todayAsString = df.format(today);

		// Print the result!
		System.out.println("Today is: " + todayAsString);
		String query="INSERT INTO `bank`.`operations` VALUES(NULL,'"+Login.id+"','"+c.getFname()+"','"+c.getLname()+"','"+"Withdraw"+"','"+todayAsString+"',"+rs+");";
		PreparedStatement ps=Main.con.prepareStatement(query);
		ps.executeUpdate();
	}
	
	public void wAdd100() throws SQLException {
		wAdd(100);
	}
	public void wAdd200() throws SQLException {
		wAdd(200);
	}
	
	public void wAdd500() throws SQLException {
		wAdd(500);
	}

	public void wAdd1000() throws SQLException {
		wAdd(1000);
	}

	public void wAdd2000() throws SQLException {
		wAdd(2000);
	}
	public void wAdd3000() throws SQLException {
		wAdd(3000);
	}
	public void wAdd5000() throws SQLException {
		wAdd(5000);
	}
	
	public void wAdd10000() throws SQLException {
		wAdd(10000);
	}
	
	public void wProceed() throws SQLException, IOException {
		float withdrawMoney=Float.parseFloat(withdraw.getText());
		if(c.getBalance()>=withdrawMoney){
		float total=c.getBalance()-withdrawMoney;
		c.setBalance(total);
		String query="UPDATE `bank`.`information` SET `Balance` = '"+total+"' WHERE (`Id` = '"+Login.id+"');";
		Statement st=Main.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			
			System.out.println(c.getBalance());
			balance1.setText(c.getBalance()+"");
			balance.setText(c.getBalance()+"");
			balance2.setText(c.getBalance()+"");
			System.out.println(balance.getText());
			
			withdraw.setText(0+"");
		}
		else {
			System.out.println("problem");
		}}
		else {
			Stage window=new Stage(); 
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Not Enough Money");
			window.setMinWidth(250);
			window.setResizable(false);
			Scene scene=new Scene(FXMLLoader.load(getClass().getResource("errorwithdraw.fxml")),300,120);
			window.setScene(scene);
			window.showAndWait();
			balance2.setText(c.getBalance()+"");
			balance1.setText(c.getBalance()+"");
			balance.setText(c.getBalance()+"");
			withdraw.setText(0+"");
		}
		
	}
	//Money Transfer
	public void transferMoney() throws SQLException, IOException {
		int payeeId=Integer.parseInt(tId.getText());
		float amount=Float.parseFloat(tAmount.getText());
		if(c.getBalance()>=amount) {
		c.setBalance((c.getBalance()-amount));
		String query1="UPDATE `bank`.`information` SET `Balance` = Balance-"+(amount)+" WHERE (`Id` = '"+Login.id+"');";
		String query2="UPDATE `bank`.`information` SET `Balance` = Balance+"+amount+" WHERE (`Id` = '"+payeeId+"');";
		Statement st=Main.con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		int[] i=st.executeBatch();
		if(i[1]==1) {
			System.out.println("Payment done");			
			balance.setText(c.getBalance()+"");
			balance2.setText(c.getBalance()+"");
			balance1.setText(c.getBalance()+"");
			tId.clear();
			tAmount.clear();
		}
		else {
			System.out.println("Payment not done");
		}}
		else {
			Stage window=new Stage(); 
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Not Enough Money");
			window.setMinWidth(250);
			window.setResizable(false);
			Scene scene=new Scene(FXMLLoader.load(getClass().getResource("errorwithdraw.fxml")),300,120);
			window.setScene(scene);
			window.showAndWait();
			balance2.setText(c.getBalance()+"");
			balance1.setText(c.getBalance()+"");
			balance.setText(c.getBalance()+"");
			
			tId.clear();
			tAmount.clear();
		}
		
	}
	//Change Details
			public void update() throws SQLException {
				Statement st=Main.con.createStatement();
				String query="UPDATE `bank`.`information` SET `fname` = '"+fname.getText()+"', `lname` = '"+lname.getText()+"', `phoneno` = '"+phoneno.getText()+"', `email` = '"+email.getText()+"', `dob` = '"+dob.getValue().toString()+"' WHERE (`Id` = '"+id.getText()+"');";
				c.setFname(fname.getText());
				c.setLname(lname.getText());
				int i=st.executeUpdate(query);
				
				if(i==1) System.out.println("Updated");
				else System.out.println("Not updated");
			}
			//add credit
			public void takeacredit() throws SQLException, IOException {
				
				String query="Select * from `bank`.`information`  WHERE (`Id` = '"+Login.id+"');";
				Statement st=Main.con.createStatement();
				ResultSet rs=st.executeQuery(query);
				rs.next();				
				String status=rs.getString(11);				
				if(status.contentEquals("NeverCredited")) {	
					String pattern = "MM/dd/yyyy HH:mm:ss";

					// Create an instance of SimpleDateFormat used for formatting 
					// the string representation of date according to the chosen pattern
					DateFormat df = new SimpleDateFormat(pattern);

					// Get the today date using Calendar object.
					Date today = Calendar.getInstance().getTime();        
					// Using DateFormat format method we can create a string 
					// representation of a date with the defined format.
					String todayAsString = df.format(today);

					// Print the result!
					System.out.println("Today is: " + todayAsString);
					
					Float balancex=c.getBalance();
			        Float amount1=Float.parseFloat(Credit.getText());
				    Float month1=Float.parseFloat(INSTALLMENT.getSelectionModel().getSelectedItem());
				    System.out.println(month1);					
					Float add1=amount1*5*month1/1200;
					System.out.println(add1);
					Float ram1=amount1+add1;
					System.out.println(ram1);
					Float pmonth1=ram1/month1;					
					System.out.println(pmonth1);					
					String statusc="Credited";
					String query1="UPDATE `bank`.`information` SET `balance`='"+(balancex+amount1)+"' ,`credit` = '"+(amount1)+"',`Status`='"+statusc+"' WHERE (`Id` = '"+Login.id+"');";					
					Statement st1=Main.con.createStatement();	
					c.cr.setMonth(month1);
					c.cr.setLoan(ram1);
					c.cr.setPmonth(pmonth1);
					c.setBalance(balancex+amount1);
					c.setStatut("Credited");
					int i=st1.executeUpdate(query1);
					if(i==1) {						
						System.out.println("crediter");
						Credit.setText("");}
					else{
						System.out.println("error");
					    Credit.setText("");}
					String query3 =" INSERT INTO `bank`.`credits` VALUES (NULL,'"+Login.id+"','"+month1+"','"+ram1+"','"+pmonth1+"','"+todayAsString+"' );";					
					PreparedStatement ps1=Main.con.prepareStatement(query3);			
					int j=ps1.executeUpdate(query3);
	                if(j==1) {						
						System.out.println("crediter2");
						Credit.setText("");}
					else{
						System.out.println("error2");
					    Credit.setText("");}	            	
					rmonth3.setText(month1+" "+"Months");
					rloan3.setText(ram1+" "+"MAD");
					pmonth3.setText(pmonth1+" "+"MAD");
					balance.setText((balancex+amount1)+"");
					balance1.setText((balancex+amount1)+"");
					balance2.setText((balancex+amount1)+"");
					datef.setText(todayAsString);
					
			}
				
				else {									
					Stage window=new Stage(); 
					window.initModality(Modality.APPLICATION_MODAL);
					window.setTitle("Error");
					window.setMinWidth(250);
					window.setResizable(false);					
					Scene scene=new Scene(FXMLLoader.load(getClass().getResource("errorcredit.fxml")),300,120);
					window.setScene(scene);
					window.showAndWait();					
					Credit.setText("");					
				}}
			public void payi() throws SQLException, IOException {							
			Float balancex=c.getBalance();
			String statusc1=c.getStatut();
			if(statusc1.contentEquals("Credited")) {
			
			Float month=c.cr.getMonth();
			Float rloan=c.cr.getLoan();
			Float pmonth=c.cr.getPmonth();
			
			if(month>1 && balancex>=pmonth && rloan>0 ) {
				String query8="UPDATE `bank`.`information` SET `balance`='"+(balancex-pmonth)+"' WHERE (`Id` = '"+Login.id+"');";
				String query2="UPDATE `bank`.`credits` SET `month`='"+(month-1)+"', `amount`='"+(rloan-pmonth)+"',`pricem`='"+pmonth+"' WHERE (`Id` = '"+Login.id+"');";				
				Statement st2=Main.con.createStatement();	
				st2.executeUpdate(query8);
				st2.executeUpdate(query2);
				c.cr.setMonth((month-1));
				c.cr.setLoan((rloan-pmonth));
				c.cr.setPmonth(pmonth);
				c.setBalance(balancex-pmonth);
				rmonth3.setText((month-1)+" "+"Months");
				rloan3.setText((rloan-pmonth)+" "+"MAD");
				pmonth3.setText((pmonth)+" "+"MAD");
				balance.setText((balancex-pmonth)+"");
				balance1.setText((balancex-pmonth)+"");
				balance2.setText((balancex-pmonth)+"");
			}
			else if(month==1 && balancex>=pmonth && rloan>0) {
				String query8="UPDATE `bank`.`information` SET `balance`='"+(balancex-pmonth)+"' WHERE (`Id` = '"+Login.id+"');";
				String query2="UPDATE `bank`.`credits` SET `month`='"+(month-1)+"', `amount`='"+(rloan-pmonth)+"',`pricem`='"+(pmonth-pmonth)+"' WHERE (`Id` = '"+Login.id+"');";								
				Statement st2=Main.con.createStatement();								
				st2.executeUpdate(query8);
				st2.executeUpdate(query2);
				c.cr.setMonth((month-1));
				c.cr.setLoan((rloan-pmonth));
				c.cr.setPmonth((pmonth-pmonth));
				c.setBalance(balancex-pmonth);
				rmonth3.setText((month-1)+" "+"Months");
				rloan3.setText((rloan-pmonth)+" "+"MAD");
				pmonth3.setText((pmonth-pmonth)+" "+"MAD");
				String query9="DELETE from bank.credits WHERE (`Id` = '"+Login.id+"');";
				PreparedStatement ps8=Main.con.prepareStatement(query9);			
				ps8.executeUpdate(query9);
				String query10="UPDATE `bank`.`information` SET `Status`='"+"NeverCredited"+"' WHERE (Id='"+Login.id+"');";
				Statement st3=Main.con.createStatement();
				st3.execute(query10);
				c.setStatut("NeverCredited");
				balance.setText((balancex-pmonth)+"");
				balance1.setText((balancex-pmonth)+"");
				balance2.setText((balancex-pmonth)+"");
				
				}
			else if(balancex<=pmonth) {
				Stage window=new Stage(); 
				window.initModality(Modality.APPLICATION_MODAL);
				window.setTitle("Nothing To Pay");
				window.setMinWidth(250);
				window.setResizable(false);
		
				Scene scene=new Scene(FXMLLoader.load(getClass().getResource("Notenough.fxml")),300,120);
				window.setScene(scene);
				window.showAndWait();
			}
			}
				else {
					
					Stage window=new Stage(); 
					window.initModality(Modality.APPLICATION_MODAL);
					window.setTitle("Nothing To Pay");
					window.setMinWidth(250);
					window.setResizable(false);
					
					
					Scene scene=new Scene(FXMLLoader.load(getClass().getResource("NothingToPay.fxml")),300,120);
					window.setScene(scene);
					window.showAndWait();
					
					rmonth3.setText("0"+" "+"Months");
					rloan3.setText("0"+" "+"MAD");
					pmonth3.setText("0"+" "+"MAD");
					datef.setText("");
					
				}
			}	
			
	//sign out
			public void signOut() {
				new Main().changeScene("firstshow.fxml","Ensah Bank", 600, 400);
			}
			public void refresh() throws SQLException {
				String query="SELECT * from `bank`.`operations` Where (Id='"+Login.id+"');";
				Statement st=Main.con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				for ( int i = 0; i<table.getItems().size(); i++) {
				    table.getItems().clear();
				}
				while(rs.next()){
					data.add(new operation(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getFloat(7)));
				}
				ido.setCellValueFactory(new PropertyValueFactory<operation,Integer>("ido"));
				nameo.setCellValueFactory(new PropertyValueFactory<operation,String>("nameo"));
				lnameo.setCellValueFactory(new PropertyValueFactory<operation,String>("lnameo"));
				typeo.setCellValueFactory(new PropertyValueFactory<operation,String>("typeo"));
				dateo.setCellValueFactory(new PropertyValueFactory<operation,String>("dateo"));
				amounto.setCellValueFactory(new PropertyValueFactory<operation,Float>("amounto"));
				table.setItems(data);
			}
			public void close() throws SQLException, IOException {
				String query="SELECT * from `bank`.`information` Where (Id='"+Login.id+"');";
				Statement st=Main.con.createStatement();
				ResultSet rs=st.executeQuery(query);
				rs.next();
				if(((rs.getFloat(9))<1) && ((rs.getString(11)).contentEquals("NeverCredited"))) {
					String query9="DELETE from bank.information WHERE (`Id` = '"+Login.id+"');";
					String query10="DELETE from bank.login WHERE (`Id` = '"+Login.id+"');";
					String query11="DELETE from bank.operations WHERE (`Id` = '"+Login.id+"');";
					PreparedStatement ps8=Main.con.prepareStatement(query9);			
					ps8.executeUpdate(query9);
					ps8.executeUpdate(query10);
					ps8.executeUpdate(query11);
					new Main().changeScene("firstshow.fxml","Ensah Bank",600,400);
				}
				else {
					Stage window=new Stage(); 
					window.initModality(Modality.APPLICATION_MODAL);
					window.setTitle("Nothing To Pay");
					window.setMinWidth(250);
					window.setResizable(false);
					
					
					Scene scene=new Scene(FXMLLoader.load(getClass().getResource("closeerror.fxml")),300,120);
					window.setScene(scene);
					window.showAndWait();
				}
			}
}
