package com.springframework.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.demo.services.CustomerService;
import com.springframework.model.Customer;

import javassist.bytecode.Descriptor.Iterator;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	Map<Integer, Customer> custStores = new HashMap<Integer, Customer>();


	@RequestMapping(method=RequestMethod.GET,
			value = "healthcheck")
	public String index() {
		return "Customer Info Sping Project Demo";
	}

	@PostConstruct
	public void initIt() throws Exception{
		Customer c1 = new Customer(1,"fn1","ln1","10" ,100);
		Customer c2 = new Customer(2,"fn2","ln2","20",200);
		Customer c3 = new Customer(3,"fn3","ln3","30",300);
		Customer c4 = new Customer(4,"fn4","ln4","40",400);
		Customer c5 =new Customer(5,"fn5","ln5","50",500);
		customerService.getCustomerHashMap().put(c1.getCustomerID(), new Customer(1,"fn1","ln1","10",100));
		customerService.getCustomerHashMap().put(c2.getCustomerID(), new Customer(2,"fn2","ln2","20",200));
		customerService.getCustomerHashMap().put(c3.getCustomerID(), new Customer(3,"fn3","ln3","30",300));
		customerService.getCustomerHashMap().put(c4.getCustomerID(), new Customer(4,"fn4","ln4","40",400));
		customerService.getCustomerHashMap().put(c5.getCustomerID(), new Customer(5,"fn5","ln5","50",500));
	}

	@RequestMapping(method=RequestMethod.GET,
			value="/get/{customerID}",
			produces = "application/json")
	public Customer getMethod(@RequestParam("customerID") int customerID) {
		return customerService.getCustomer(customerService.getCustomerHashMap(), customerID);
	}

	@RequestMapping(method=RequestMethod.GET,
			value="/get/all/",
			produces = "application/json")
	public @ResponseBody Map<Integer, Customer> getAllMethod() {
		return customerService.getAllCustomers(customerService.getCustomerHashMap());
	}

	@RequestMapping(method=RequestMethod.POST,
			value="/post",
			consumes = "application/json")
	@ResponseBody
	public String postMethod(@RequestBody Customer customerInput) throws Exception {
		String resposne = customerService.addCustomer(customerService.getCustomerHashMap(), customerInput.getCustomerID(), customerInput);
		 return resposne;
	}

	@RequestMapping(method=RequestMethod.PUT,
			value = "/put/{customerID}",
			produces = "application/json",
			consumes = "application/json")
	@ResponseBody
	public Customer putMethod(@PathVariable int customerID, @RequestBody Customer customerInput) {
		return customerService.updateCustomer(customerService.getCustomerHashMap(), customerInput.getCustomerID(), customerInput);
	}

	@RequestMapping(method=RequestMethod.DELETE,
			value="/delete/{customerID}",
			consumes = "application/json")
	@ResponseBody
	public String deleteMethod(@PathVariable int customerID, @RequestBody Customer customerInput) {
		String response = customerService.deleteCustomer(customerService.getCustomerHashMap(), customerInput.getCustomerID());
		return  response;
	}

	@RequestMapping(method=RequestMethod.DELETE,
			value = "/delete/all")
	@ResponseBody
	public String deleteAllMethod() {
		String repsone = customerService.deleteAllCustomers(customerService.getCustomerHashMap());
		return repsone;
	}
}
