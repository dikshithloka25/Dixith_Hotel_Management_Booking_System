package com.capgemini.hotelbookingmanagementsystem.bean;

public class Address {
	private String HNo;
	private String street;
	private String city;
	private String state;

	public Address(String hNo, String street, String city, String state) {
		super();
		HNo = hNo;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public Address() {
		
	}
	
	
	public String getHNo() {
		return HNo;
	}

	public void setHNo(String hNo) {
		HNo = hNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address :\n     HNo=" + HNo + "\n     street=" + street + "\n     city=" + city + "\n     state=" + state + "\n";
	}

	

}
