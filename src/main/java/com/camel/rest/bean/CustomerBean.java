package com.camel.rest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;

import com.camel.rest.model.Customer;

/**
 * @author Tuhin Gupta
 *
 */
public class CustomerBean {
	
	public void getCustomers(Exchange exchange) throws Exception{
		
		System.out.println("Customer Bean: "+exchange.getIn().getHeaders());
		
		List<Customer> customerList = new ArrayList<>();
		
		customerList.add(new Customer("Cust-A","address a", "US-A"));
		customerList.add(new Customer("Cust-B","address B", "US-B"));
		
		exchange.getOut().setBody(customerList);
		
		
	}
	
	public void addCustomer(Customer customer, Exchange exchange){
		
		System.out.println("Customer - "+customer.getName()+" "+customer.getAddress());
		
		Response r = Response.status(201).build();
		exchange.getOut().setBody(r);
		
	}

}
