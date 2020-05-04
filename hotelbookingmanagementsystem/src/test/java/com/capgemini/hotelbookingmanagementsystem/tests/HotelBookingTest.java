package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDao;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class HotelBookingTest {

	@Test
	void testHotelBookingStatus() {
		CustomerDao customerDaoImpl = HotelFactory.getCustomerDaoImpl();
		assertEquals(null, customerDaoImpl.bookingStatus());

	}

	@Test
	void testHotelBooking1() {
		CustomerDao customerDaoImpl = HotelFactory.getCustomerDaoImpl();
		assertEquals(true, customerDaoImpl.chooseHotel(1001));

	}

	@Test
	void testHotelBooking2() {
		CustomerDao customerDaoImpl = HotelFactory.getCustomerDaoImpl();
		assertEquals(true, customerDaoImpl.chooseHotel(1003));

	}

}
