package com.capgemini.hotelbookingmanagementsystem.exception;

@SuppressWarnings("serial")
public class HotelIdNotFoundException extends Exception {
	String message = "Please Select Hotel Id from the Given List of Hotels \n ";

	public HotelIdNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}
}
