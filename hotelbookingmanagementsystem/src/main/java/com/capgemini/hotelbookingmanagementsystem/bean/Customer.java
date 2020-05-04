package com.capgemini.hotelbookingmanagementsystem.bean;

public class Customer {
	private String customerName;

	private long customerPhnno;
	private String customerEmail;
	private long customerAdhaarNo;
	private int customerAge;
	private String customerPassword;
	Address address;

	public Customer(String customerName, long customerPhnno, String customerEmail, long customerAdhaarNo,
			int customerAge, String customerPassword, Address address) {
		super();
		this.customerName = customerName;
		this.customerPhnno = customerPhnno;
		this.customerEmail = customerEmail;
		this.customerAdhaarNo = customerAdhaarNo;
		this.customerAge = customerAge;
		this.customerPassword = customerPassword;
		this.address = address;
	}
	
	public Customer() {
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhnno() {
		return customerPhnno;
	}

	public void setCustomerPhnno(long customerPhnno) {
		this.customerPhnno = customerPhnno;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerAdhaarNo() {
		return customerAdhaarNo;
	}

	public void setCustomerAdhaarNo(long customerAdhaarNo) {
		this.customerAdhaarNo = customerAdhaarNo;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\n customerName=" + customerName + "\n customerPhnno=" + customerPhnno + "\n customerEmail="
				+ customerEmail + "\n customerAdhaarNo=" + customerAdhaarNo + "\n customerAge=" + customerAge
				+ "\n customerPassword=" + customerPassword + "\n address=" + address + "]";
	}

}
