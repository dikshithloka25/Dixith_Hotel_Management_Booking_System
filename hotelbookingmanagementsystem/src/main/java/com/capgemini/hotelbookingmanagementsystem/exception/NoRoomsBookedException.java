package com.capgemini.hotelbookingmanagementsystem.exception;

@SuppressWarnings("serial")
public class NoRoomsBookedException extends Exception{
	String message = "No Room is booked Till Now \n";

	public NoRoomsBookedException() {
		super();
	}

	public String getMesssage() {
		return message;
	}
}
