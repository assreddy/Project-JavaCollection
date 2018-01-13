package com.studentinfosystem.model;

public class StudentAddress {
	
	private String houseNumber;	
	private String streetName;
	private String aptNo;
	private String cityName;
	private String pinCode;
	private String state;
	
	public StudentAddress() {
		super();
	}
	
	
	public StudentAddress(String houseNumber, String streetName, String aptNo, String cityName, String pinCode, String state) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.aptNo = aptNo;
		this.cityName = cityName;
		this.pinCode = pinCode;
		this.state = state;
	}
	
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getpinCode() {
		return pinCode;
	}
	
	public void setpinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	

}
