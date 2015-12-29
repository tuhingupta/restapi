package com.camel.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tuhin Gupta
 *
 */
@XmlRootElement(name = "Customer")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String address;
	String country;
	
	public Customer(){
		super();
	}
	
	public Customer(String name, String address, String country) {
		super();
		this.name = name;
		this.address = address;
		this.country = country;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
