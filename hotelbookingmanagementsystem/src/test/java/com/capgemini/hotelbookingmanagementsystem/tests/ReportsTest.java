package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.dao.Reports;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class ReportsTest {

	@Test
	@DisplayName("Specific Hotel Booking")
	void testSpecificHotelBooking1() {
		Reports reports = HotelFactory.getReports();
		assertEquals(true, reports.specificHotelBookingList(1002));
	}
	
	@Test
	@DisplayName("Specific Hotel Booking")
	void testSpecificHotelBooking2() {
		Reports reports = HotelFactory.getReports();
		assertEquals(true, reports.specificHotelBookingList(1001));
	}
		
	@Test
	@DisplayName("Specific Date Booking")
	void testSpecificDateBooking() {
		Reports reports = HotelFactory.getReports();
		assertEquals(true, reports.bookingsByDate(LocalDate.now()));
	}
		
	@Test
	@DisplayName("Guest Hotel Name")
	void testHotelGuestName1() {
		Reports reports = HotelFactory.getReports();
		assertEquals(true, reports.hotelGuestName(1001));
	}
	
	@Test
	@DisplayName("Guest Hotel Name")
	void testHotelGuestName2() {
		Reports reports = HotelFactory.getReports();
		assertEquals(true, reports.hotelGuestName(1002));
	}

}
