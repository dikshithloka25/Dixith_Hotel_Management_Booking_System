package com.capgemini.hotelbookingmanagementsystem.bean;

public class Hotel {

	private int hotelId;
	private String hotelName;
	private int noOfRooms;
	private String Description;
	private String hotelAddress;
	
	public Hotel() {
		super();
	}
	
	public Hotel(int hotelId, String hotelName, int noOfRooms, String description, String hotelAddress) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.noOfRooms = noOfRooms;
		Description = description;
		this.hotelAddress = hotelAddress;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	@Override
	public String toString() {
		return "\nhotelId=" + hotelId + "   hotelName=" + hotelName + "   noOfRooms=" + noOfRooms + "   Description="
				+ Description + "   hotelAddress=" + hotelAddress + " \n";
	}
	
	
	
}
