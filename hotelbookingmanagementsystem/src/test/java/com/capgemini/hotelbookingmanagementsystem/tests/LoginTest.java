package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.dao.LoginForm;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class LoginTest {

	@Test
	void testCustomerLogin1() {
		LoginForm customerLogin = HotelFactory.getCustomerLoginDaoImpl();
		
		assertEquals(true, customerLogin.login("dik@gmail.com","dikshu@123"));
	}
	
	@Test
	void testCustomerLogin2() {
		LoginForm customerLogin = HotelFactory.getCustomerLoginDaoImpl();
		
		assertEquals(false, customerLogin.login("dikshith@gmail.com","dikshith@123"));
	}
	
	
	@Test
	void testEmployeeLogin1() {
		LoginForm employeeLogin = HotelFactory.getEmployeeManagementLogin();
		
		assertEquals(true, employeeLogin.login("employee1@gmail.com","employee@1"));
	}
	
	@Test
	void testEmployeeLogin2() {
		LoginForm employeeLogin = HotelFactory.getEmployeeManagementLogin();
		
		assertEquals(false, employeeLogin.login("employee@gmail.com","employee@123"));
	}
	
	@Test
	void testAdminLogin1() {
		LoginForm adminLogin = HotelFactory.getAdminLogin();
		
		assertEquals(true, adminLogin.login("admin@gmail.com","admin@123"));
	}
	
	@Test
	void testAdminLogin2() {
		LoginForm adminLogin = HotelFactory.getAdminLogin();
		
		assertEquals(false, adminLogin.login("admin12@gmail.com","admin1@123"));
	}
	

}
