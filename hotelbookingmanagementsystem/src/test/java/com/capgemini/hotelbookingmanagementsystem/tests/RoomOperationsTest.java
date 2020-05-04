package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminRoomOperations;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class RoomOperationsTest {
	static Logger logger = Logger.getLogger(RoomOperationsTest.class);

	@Test
	@DisplayName("Add Room")
	void testAddRoom1() {
		logger.info("\n Add Room Test \n");
		AdminRoomOperations addroomOperations = HotelFactory.getAdminRoomOperations();
		String[] s1 = { "FREE WIFI", "A/C", "TV" };
		Room room1 = new Room("taj04", "single bedroom", null, 1800, "available", s1, null, null);
		assertEquals(true, addroomOperations.addRoom(1001, room1));
	}

	@Test
	@DisplayName("Add Room")
	void testAddRoom2() {
		logger.info("\n Add Room Test \n");
		AdminRoomOperations addroomOperations = HotelFactory.getAdminRoomOperations();
		String[] s2 = { "FREE WIFI", "NON-A/C", "TV" };
		Room room1 = new Room("myu01", "Double bedroom", null, 1800, "available", s2, null, null);

		assertEquals(true, addroomOperations.addRoom(1002, room1));
	}

	@Test

	@DisplayName("Delete Room")
	void testDeleteRoom1() {
		logger.info("\n Delete Room Test \n");
		AdminRoomOperations deleteroomOperations = HotelFactory.getAdminRoomOperations();
		assertEquals(true, deleteroomOperations.deleteRoom(1002));
	}

	@Test

	@DisplayName("Delete Room")
	void testDeleteRoom2() {
		logger.info("\n Delete Room Test \n");
		AdminRoomOperations deleteroomOperations = HotelFactory.getAdminRoomOperations();
		assertEquals(true, deleteroomOperations.deleteRoom(1001));
	}

	@Test

	@DisplayName("Update Room")
	void testUpdateRoom1() {
		logger.info(" \n Update Room Test \n");
		AdminRoomOperations updateroomOperations = HotelFactory.getAdminRoomOperations();
		assertEquals(true, updateroomOperations.updateRoom(1001));
	}

	@Test

	@DisplayName("Update Room")
	void testUpdateRoom2() {
		logger.info(" \n Update Room Test \n");
		AdminRoomOperations updateroomOperations = HotelFactory.getAdminRoomOperations();
		assertEquals(true, updateroomOperations.updateRoom(1000));
	}

}
