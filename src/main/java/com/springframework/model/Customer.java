package com.springframework.model;

public class Customer {

	private int customerID;
	private String lastName;
	private String firstName;
	private String age;
	private int pinCode;

	public Customer() {}

	public Customer(int customerID, String lastName, String firstName, String age, int pinCode) {
		this.customerID = customerID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.pinCode = pinCode;
	}


	public Customer(int customerID, String age) {
		this.customerID = customerID;
		this.age = age;
	}
	
	// Getter and Setter Methods
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	// Print Customer Info in String Format.
	public String printCustomer() {
		String info = String.format("custId = %d, firstname = %s, lastname = %s, age = %d, pin= %d"
				, customerID, firstName, lastName, age,pinCode);
		return info;
	}



}
