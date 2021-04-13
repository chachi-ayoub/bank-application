package application;

import java.util.ArrayList;
import java.util.List;

import application.creditinfo;



public class Customer {
	private String username;
	private String password;
	private String email;
	private String fname;
	private Float credit;
	private String lname;
	private String phoneno;
	private String dob;
	private String gender;
	private Float balance;
	protected  creditinfo cr;
	protected String statut;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  creditinfo getOperation() {
		return cr;
	}

	public void setOperation(creditinfo cr) {
		this.cr = cr;
	}

	//constructor
	public Customer(String username,String password,String email) {
		this.username=username;
		this.password=password;
		this.email=email;
	}

	public Customer(String username,String fname,String lname,String phoneno,String email,String dob,String gender,Float balance,Float credit,String statut) {
		this.username=username;
		this.fname=fname;
		
		this.lname=lname;
		this.phoneno=phoneno;
		this.email=email;
		this.email=email;
		this.dob=dob;
		this.gender=gender;
		this.balance=balance;
		this.credit=0f;
		this.statut=statut;
		
	}
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public creditinfo getCr() {
		return cr;
	}

	public void setCr(creditinfo cr) {
		this.cr = cr;
	}

	public Customer(String username, String password, String email, String fname, Float credit, String lname,
			String phoneno, String dob, String gender, Float balance) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fname = fname;
		this.credit = credit;
		this.lname = lname;
		this.phoneno = phoneno;
		this.dob = dob;
		this.gender = gender;
		this.balance = balance;
		
	}

	public Customer(String username, String password, String email, String fname,  String lname, String phoneno, String dob, String gender) {
		this(username,password,email);
		this.fname = fname;
		
		this.lname = lname;
		this.phoneno = phoneno;
		this.dob = dob;
		this.gender = gender;
		this.balance=0f;
		this.credit=0f;
	}






	//getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
		
	public String getFname() {
		return fname;
	}

	

	public String getLname() {
		return lname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}
	
	public Float getBalance() {
		return balance;
	}
	
	public void setBalance(Float balance) {
		this.balance=balance;
	}

	public Float getCredit() {
		return credit;
	}

	public void setCredit(Float Credit) {
		this.credit = Credit;
	}


	
}
