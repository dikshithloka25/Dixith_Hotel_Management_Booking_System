package com.capgemini.hotelbookingmanagementsystem.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerRegistrationDao;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

class CustomerRegistrationTest {

	@Test
	void testRegister1() {
		
		CustomerRegistrationDao customerRegistrationDao = HotelFactory.getCustomerRegistrationDaoImpl();
		Address address = new Address("1-2-123/12", "A N Reddy Colony", "Nirmal", "Telangana");
		Customer customer1 = new Customer("Rohit Sharma", 8885544859l, "rohit@gmail.com", 324356456879l, 24, "rohit@123", address);
		assertEquals(true, customerRegistrationDao.addCustomer(customer1));
		
		
	}
	
	@Test
	void testRegister2() {
		
		CustomerRegistrationDao customerRegistrationDao = HotelFactory.getCustomerRegistrationDaoImpl();
		Address address = new Address("1-8-13/120", "Shastri nagar Colony", "Bangalore", "Karnataka");
		Customer customer2 = new Customer("Rahul Yadav", 8902244859l, "rahul@gmail.com", 324356451235l, 42, "rahul@123", address);
		
		assertEquals(true, customerRegistrationDao.addCustomer(customer2));
		
		
	}
	
	

}
