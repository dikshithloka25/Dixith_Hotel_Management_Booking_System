package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.*;

import com.capgemini.hotelbookingmanagementsystem.bean.Room;

public interface CustomerDao {
	public boolean chooseHotel(int hotelId);
	public List<Room> bookingStatus();
}
