package com.capgemini.hotelbookingmanagementsystem.exception;

@SuppressWarnings("serial")
public class RoomNoNotFoundException extends Exception{
	String message = "Please Select Room number from the Given List of Rooms\nand only Rooms that are Available \n";

	public RoomNoNotFoundException() {
		super();
	}

	public String getMesssage() {
		return message;
	}
}
