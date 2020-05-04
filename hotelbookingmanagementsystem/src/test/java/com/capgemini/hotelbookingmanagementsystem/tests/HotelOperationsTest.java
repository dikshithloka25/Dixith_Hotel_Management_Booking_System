package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminHotelOperations;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class HotelOperationsTest {
	static Logger logger = Logger.getLogger(HotelOperationsTest.class);

	@Test
	@DisplayName("Add Hotel")
	void testAddHotel() {
		logger.info("\n Add Hotel Test \n");
		AdminHotelOperations addHotelOperations = HotelFactory.getAdminHotelOperations();
		Hotel hotel1 = new Hotel(1004, "Sreeja Hotel", 2, "2* hotel", "Nirmal");
		assertEquals(true, addHotelOperations.addHotel(hotel1));
	}

	@Test
	@DisplayName("Add Hotel")
	void testAddHotel2() {
		logger.info("\n Add Hotel Test \n");
		AdminHotelOperations addHotelOperations = HotelFactory.getAdminHotelOperations();
		Hotel hotel1 = new Hotel(1001, "Swagath Grand Hotel", 2, "5* hotel", "Hyderabad,telangana");
		assertEquals(true, addHotelOperations.addHotel(hotel1));
	}
	
	@Test
	@DisplayName("Delete Hotel1")
	void testDeleteHotel1() {
		logger.info("\n Delete Hotel Test \n");
		AdminHotelOperations deleteHotelOperations = HotelFactory.getAdminHotelOperations();
		assertEquals(true, deleteHotelOperations.deleteHotel(1001));
	}
	
	@Test
	@DisplayName("Delete Hotel2")
	void testDeleteHotel2() {
		logger.info("\n Delete Hotel Test \n");
		AdminHotelOperations deleteHotelOperations = HotelFactory.getAdminHotelOperations();
		assertEquals(false, deleteHotelOperations.deleteHotel(1005));
	}

	@Test
	@DisplayName("Update Hotel1")
	void testUpdateHotel1() {
		logger.info("\n Update Hotel Test \n");
		AdminHotelOperations updateHotelOperations = HotelFactory.getAdminHotelOperations();
		Hotel hotel1 = new Hotel(1000, "Santhosh Daba", 0, "2* hotel", "Nirmal");
		assertEquals(true, updateHotelOperations.updateHotel(1002,hotel1));
	}
	
	@Test
	@DisplayName("Update Hotel2")
	void testUpdateHotel2() {
		logger.info("\n Update Hotel Test \n");
		AdminHotelOperations updateHotelOperations = HotelFactory.getAdminHotelOperations();
		Hotel hotel1 = new Hotel(1009, "Sathish Hotel", 0, "2* hotel", "Bangalore,karnataka");
		assertEquals(true, updateHotelOperations.updateHotel(1006,hotel1));
	}

}
