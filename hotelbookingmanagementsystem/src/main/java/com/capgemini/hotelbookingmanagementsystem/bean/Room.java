package com.capgemini.hotelbookingmanagementsystem.bean;

import java.time.LocalDate;
import java.util.Arrays;

public class Room {
	private String roomno;
	private String roomtype;
	private String guestName;
	private double roomprice;
	private String roomStatus;
	private String[] availabilities;
	private LocalDate from;
	private LocalDate to;

	
	public Room(String roomno, String roomtype, String guestName, double roomprice, String roomStatus,
			String[] availabilities, LocalDate from, LocalDate to) {
		super();
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.guestName = guestName;
		this.roomprice = roomprice;
		this.roomStatus = roomStatus;
		this.availabilities = availabilities;
		this.from = from;
		this.to = to;
	}
	
	public Room() {
		
	}

	public String[] getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(String[] availabilities) {
		this.availabilities = availabilities;
	}


	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public double getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(double roomprice) {
		this.roomprice = roomprice;
	}

	

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return "\nRoomNo=" + roomno + "            RoomType=" + roomtype + "                   RoomPrice=" + roomprice + 
			   "\nRoomStatus=" + roomStatus + "    Availabilities=" + Arrays.toString(availabilities) + "   From=" + from + 
			   "\nTo=" + to + "                Guest name=" + guestName + "\n";
	}

}
