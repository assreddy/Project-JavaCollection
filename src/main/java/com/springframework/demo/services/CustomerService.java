package com.springframework.demo.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.serial.SerialArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;
import com.springframework.model.Customer;

@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	public static Map<String, Customer> customerHashMap = new HashMap<String, Customer>();

	@Autowired
	public CustomerService() {}

	public CustomerService(Map<String, Customer> customerHashMap) {
		super();
		CustomerService.customerHashMap = customerHashMap;
	}

	// default customer object.
	Customer customer;


	public Map<String, Customer> getCustomerHashMap() {
		return customerHashMap;
	}

	public void setCustomerHashMap(Map<String, Customer> customerHashMap) {
		CustomerService.customerHashMap = customerHashMap;
	}

	public String addCustomer(Map<String, Customer> customerHashMap, String ckey, Customer csString) throws Exception {
		String id = csString.getCustomerID();
		String age = csString.getAge();
		String lastName = csString.getLastName();
		String firstName = csString.getFirstName();
		String error = null;
		LOGGER.info("User ID", id);

		try {
			if(id.matches("^[0-9]+$") != true){
				error = "Invalid Customer ID Input!. Should be +ve value and Should be an Integer Number";
				throw new Exception ("Customer ID invalid input.");
			}
			if(age.matches("^[0-9]+$") != true) {	
				error = "Invalid Customer Age Input!. Should be +ve value and Should be an Integer Number.";
				throw new Exception ("Customer Age invalid input.");
			} 
			if(lastName.matches("[a-zA-Z]+") != true){
				error = "Invalid Customer First Name!. Accept only Alphabets.";
				throw new Exception("Customer First Name invalid input.");
			}
			if(firstName.matches("[a-zA-Z]+") != true){
				error = "Invalid Customer Last Name!. Accept only Alphabets.";
				throw new Exception ("Customer First Name invalid input.");
			}
			else {
				customerHashMap.put(id, csString);	
			}
			try {
				if(!(Integer.parseInt(age) >=18 && Integer.parseInt(age) <=99)) {	
					error = "Invalid Customer Age. Customer age should be 18 - 99 age.";
					throw new Exception ("Customer First Age invalid input.");
				}
				else {
					customerHashMap.put(id, csString);				
				}
			}
			catch (Exception e){
				CustomerService.getStackTrackException(e);
				return error;
			}			
		}
		catch (NumberFormatException e) {
			CustomerService.getStackTrackException(e);
			return "Invalid Customer ID Pleaes try once again";
		}
		catch (Exception e){
			CustomerService.getStackTrackException(e);
			return error; 
		}
		return "Successfully Created";
	}

	public String deleteCustomer(Map<String, Customer> customerHashMap, String cKey) {
		customerHashMap.remove(cKey);
		return "Successfully Deleted Entry from Map";
	}

	public String deleteAllCustomers(Map<String, Customer> customerHashMap) {
		customerHashMap.clear();
		return "Removed All Cusotmers.";
	}

	public Customer getCustomer(Map<String, Customer> customerHashMap, String cKey) {
		return customerHashMap.get(cKey);
	}

	public Map<String, Customer> getAllCustomers(Map<String, Customer> customerHashMap) {
		return customerHashMap;
	}

	public Customer updateCustomer(Map<String, Customer> customerHashMap, String ckey, Customer cValue) {
		customerHashMap.put(ckey, cValue);
		return customerHashMap.get(ckey);
	}

	public boolean isNonEmpty(String str) {
		return str !=null && !str.isEmpty();
	}

	public boolean isNonZero(String i) {
		return i.length()!=0;	
	}

	public boolean numberOrNot(String age) {
		try
		{
			Integer.parseInt(age);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
	}
	public static void getStackTrackException(Exception e) {
		String s = Throwables.getStackTraceAsString(e);
		System.out.println(s);
	}
}
