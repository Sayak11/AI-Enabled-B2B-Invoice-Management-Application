package com.demo.pojo;


//POJO class for business table
public class BusinessPojo {

	protected String businessCode;
	protected String businessName;
	
	//Constructor creation
	public BusinessPojo(String businessCode, String businessName) {
		this.businessCode = businessCode;
		this.businessName = businessName;
	}

	
	//Declaring the required getters and setters of the above data members
	public String getbusinessCode() {
		return businessCode;
	}

	public void setbusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getbusinessName() {
		return businessName;
	}

	public void setbusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}
