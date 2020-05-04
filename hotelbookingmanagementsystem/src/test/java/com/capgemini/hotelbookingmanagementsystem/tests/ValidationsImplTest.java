package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

class ValidationsImplTest {

	@Test
	@DisplayName("CustomerName")
	void testCustomerName() {
		Validations customerNameValidation = HotelFactory.getvalidations();
		assertEquals(true, customerNameValidation.customerName("Dikshith"));
	}

	@Test
	@DisplayName("CustomerAddress")
	void testCustomerAddress() {
		Validations customerAddressValidation = HotelFactory.getvalidations();
		assertEquals(true, customerAddressValidation.customerAddress("A N Reddy Colony"));
	}

	@Test
	@DisplayName("CustomerPhnno")
	void testCustomerPhno() {
		Validations customerPhnoValidation = HotelFactory.getvalidations();
		assertEquals(true, customerPhnoValidation.customerPhnno("9505514745"));
	}

	@Test
	@DisplayName("CustomerEmail")
	void testCustomerEmail() {
		Validations customerEmailValidation = HotelFactory.getvalidations();
		assertEquals(true, customerEmailValidation.customerEmail("dikshith@gmail.com"));
	}

	@Test
	@DisplayName("CustomerAdhaar")
	void testCustomerAdhaar() {
		Validations customerAdhaarValidation = HotelFactory.getvalidations();
		assertEquals(true, customerAdhaarValidation.customerAdhaar("284781679201"));
	}

	@Test
	@DisplayName("CustomerAge")
	void testCustomerAge() {
		Validations customerAgeValidation = HotelFactory.getvalidations();
		assertEquals(true, customerAgeValidation.customerAge("24"));
	}

	@Test
	@DisplayName("CustomerPassword")
	void testCustomerPassword() {
		Validations customerPasswordValidation = HotelFactory.getvalidations();
		assertEquals(true, customerPasswordValidation.customerPassword("Dikshu@123"));
	}

	@Test
	@DisplayName("CustomerHNo")
	void testCustomerHNo() {
		Validations customerHNoValidation = HotelFactory.getvalidations();
		assertEquals(true, customerHNoValidation.customerHNo("1-4-136/98"));
	}

	@Test
	@DisplayName("Option1")
	void testOption1() {
		Validations Option1Validation = HotelFactory.getvalidations();
		assertEquals(true, Option1Validation.Option1("2"));
	}

	@Test
	@DisplayName("Option2")
	void testOption2() {
		Validations Option2Validation = HotelFactory.getvalidations();
		assertEquals(true, Option2Validation.Option2("1"));
	}

	@Test
	@DisplayName("Option3")
	void testOption3() {
		Validations Option3Validation = HotelFactory.getvalidations();
		assertEquals(true, Option3Validation.Option3("3"));
	}

	@Test
	@DisplayName("HotelID")
	void testHotelID() {
		Validations hotelIDValidation = HotelFactory.getvalidations();
		assertEquals(true, hotelIDValidation.hotelID("1001"));
	}

	@Test
	@DisplayName("HotelName")
	void testHotelName() {
		Validations hotelNameValidation = HotelFactory.getvalidations();
		assertEquals(true, hotelNameValidation.hotelName("Santhosh DABA"));
	}

	@Test
	@DisplayName("HotelDescription")
	void testHotelDesc() {
		Validations hotelDescValidation = HotelFactory.getvalidations();
		assertEquals(true, hotelDescValidation.hotelDescription("5* hotel"));
	}

	@Test
	@DisplayName("HotelAddress")
	void testHotelAddress() {
		Validations hotelAddressValidation = HotelFactory.getvalidations();
		assertEquals(true, hotelAddressValidation.hotelAddress("Baswangudi bangalore"));
	}

	@Test
	@DisplayName("RoomNumber")
	void testRoomNumber() {
		Validations RoomNumberValidation = HotelFactory.getvalidations();
		assertEquals(true, RoomNumberValidation.roomNumber("taj09"));
	}

	@Test

	@DisplayName("RoomType")
	void testRoomType() {
		Validations RoomTypeValidation = HotelFactory.getvalidations();
		assertEquals("Single bedroom", RoomTypeValidation.roomType(1));
	}

	@Test
	@DisplayName("RoomPrice")
	void testRoomPrice() {
		Validations RoomPriceValidation = HotelFactory.getvalidations();
		assertEquals(true, RoomPriceValidation.roomPrice("1800"));
	}

	@Test

	@DisplayName("RoomStatus")
	void testRoomStatus() {
		Validations RoomStatusValidation = HotelFactory.getvalidations();
		assertEquals("available", RoomStatusValidation.roomStatus(1));
	}

	@Test
	@DisplayName("Date")
	void testDate() {
		Validations DateValidation = HotelFactory.getvalidations();
		assertEquals(true, DateValidation.Date("2020-05-04"));
	}
	
	@Test

	@DisplayName("RoomAvailabilities")
	void testRoomAvailabilities() {
		Validations AvailabilitiesValidation = HotelFactory.getvalidations();
		assertEquals("FREE WIFI", AvailabilitiesValidation.availabilities(1));
	}
	
	

}
