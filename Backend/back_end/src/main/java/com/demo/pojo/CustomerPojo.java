package com.demo.pojo;

//POJO class for customer table
public class CustomerPojo {
	protected long custNumber;
	protected String nameCustomer;
	
	//Constructor creation
	public CustomerPojo(long custNumber, String nameCustomer) {
		this.custNumber = custNumber;
		this.nameCustomer = nameCustomer;
	}

	
	//Declaring the required getters and setters of the above data members
	public long getcustNumber() {
		return custNumber;
	}

	public void setcustNumber(long custNumber) {
		this.custNumber = custNumber;
	}

	public String getnameCustomer() {
		return nameCustomer;
	}

	public void setnameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	
}
