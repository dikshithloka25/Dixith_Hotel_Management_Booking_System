package com.capgemini.hotelbookingmanagementsystem.validations;

public interface Validations {
	public boolean customerName(String name);
	public boolean customerAddress(String address);
	public boolean customerPhnno(String phnno);
	public boolean customerEmail(String email);
	public boolean customerAdhaar(String adhaar);
	public boolean customerAge(String age);
	public boolean customerPassword(String password);
	public boolean customerHNo(String hno);
	public boolean Option1(String option);
	public boolean Option2(String option1);
	public boolean Option3(String option2);
	public boolean Date(String date);
	public boolean hotelID(String hotelId);
	public boolean hotelName(String hotelname);
	public boolean hotelDescription(String Desc);
	public boolean hotelAddress(String hotelAdd);
	public boolean roomNumber(String roomNo);
	public boolean roomPrice(String price);
	public String roomType(int option);
	public String roomStatus(int option);
	public String availabilities(int availables);
}
