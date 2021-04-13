package application;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class creditinfo {
	protected  Float month;
	protected Float loan;

	protected Float pmonth;
	
	public Float getPmonth() {
		return pmonth;
	}

	public void setPmonth(Float pmonth) {
		this.pmonth = pmonth;
	}

	public creditinfo(Float month, Float loan,Float pmonth) {
		super();
		this.month = month;
		this.loan = loan;
		
		this.pmonth=pmonth;
	}

	public Float getMonth() {
		return month;
	}

	public void setMonth(Float month) {
		this.month = month;
	}

	public Float getLoan() {
		return loan;
	}

	public void setLoan(Float loan) {
		this.loan = loan;
	}

	public creditinfo() {
		super();
		
	}
	
	}
	

