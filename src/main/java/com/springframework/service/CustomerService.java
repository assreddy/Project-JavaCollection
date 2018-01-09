package com.springframework.demo.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.model.Customer;

@Service
public class CustomerService {

	public static Map<Integer, Customer> customerHashMap = new HashMap<Integer, Customer>();

	@Autowired
	public CustomerService() {}

	public CustomerService(Map<Integer, Customer> customerHashMap) {
		super();
		CustomerService.customerHashMap = customerHashMap;
	}

	// default customer object.
	Customer customer;


	public Map<Integer, Customer> getCustomerHashMap() {
		return customerHashMap;
	}

	public void setCustomerHashMap(Map<Integer, Customer> customerHashMap) {
		CustomerService.customerHashMap = customerHashMap;
	}

	public String addCustomer(Map<Integer, Customer> customerHashMap, Integer ckey, Customer cValue) throws Exception {
		String age=cValue.getAge();
		CustomerService cs = new CustomerService();

		try {
			
			if(age.matches("^[0-9]+$") != true){
				throw new Exception ("Invalid Input Please Try Again! Customer age should be 18 - 99 age.");
			}
			else {
				customerHashMap.put(ckey, cValue);	
			}
			try {
				// System.out.println(Integer.parseUnsignedInt("[0-9]",age));
				//cs.isNonZero(age) == false &&
				if(!(Integer.parseInt(age) >=18 && Integer.parseInt(age) <=99)) {	
					throw new Exception ("Invalid Input Please Try Again! Customer age should be 18 - 99 age.");
				}
				else {
					customerHashMap.put(ckey, cValue);				
				}
			}
			catch (Exception e){
				return "Invalid Input Please Try Again! Customer age should be 18 - 99 age.";
			}
		}

		catch (Exception eee1){
			return "Invalid Input Please! Please use only valid integer for age from 18-99 age.";
		}

		return "Successfully Created";
	}

	public String deleteCustomer(Map<Integer, Customer> customerHashMap, Integer cKey) {
		customerHashMap.remove(cKey);
		return "Successfully Deleted Entry from Map";
	}

	public String deleteAllCustomers(Map<Integer, Customer> customerHashMap) {
		customerHashMap.clear();
		return "Removed All Cusotmers.";
	}

	public Customer getCustomer(Map<Integer, Customer> customerHashMap, Integer cKey) {
		return customerHashMap.get(cKey);
	}

	public Map<Integer, Customer> getAllCustomers(Map<Integer, Customer> customerHashMap) {
		return customerHashMap;
	}

	public Customer updateCustomer(Map<Integer, Customer> customerHashMap, Integer ckey, Customer cValue) {
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
}
