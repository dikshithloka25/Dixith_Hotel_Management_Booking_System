package com.capgemini.hotelbookingmanagementsystem.services;

import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.controller.HotelBookingManagementSystem;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerRegistrationDao;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerRegistrationDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.exception.EmailAlreadyExistsException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class CustomerRegistrationService {
	
	static Logger logger = Logger.getLogger(CustomerRegistrationService.class);
	Scanner sc = new Scanner(System.in);

	public  void service() {
		
		int count = 0;
		Validations validations = HotelFactory.getvalidations();
		Customer customer = HotelFactory.getCustomer();
		Address address = HotelFactory.getAddress();

		logger.info("Enter Full Name");
		String fullname = sc.nextLine();
		while (!validations.customerName(fullname)) {
			logger.info("Please enter valid Name ");
			fullname = sc.nextLine();
		}

		logger.info("Enter your Mobile Number");
		String phnno = sc.nextLine();
		while (!validations.customerPhnno(phnno)) {
			logger.info("Please enter valid Mobile Number ");
			phnno = sc.nextLine();
		}
		long phnNo = Long.parseLong(phnno);

		logger.info("Enter Email ID ");
		String email = sc.nextLine();
		Iterator<Customer> itr = CustomerRegistrationDaoImpl.list.iterator();
		while (itr.hasNext()) {
			Customer customer1 = itr.next();
			if (email.equals(customer1.getCustomerEmail())) {
				count++;
			}
		}
		try {
			if (count != 0) {
				throw new EmailAlreadyExistsException();

			} else {

				while (!validations.customerEmail(email)) {
					logger.info("Please enter valid Email ID ");
					email = sc.nextLine();
				}
			}
		} catch (EmailAlreadyExistsException e) {
			logger.error("Email Already Exists...\n");
			HotelBookingManagementSystem.main(null);

		}

		logger.info("Set a Password ");
		String password = sc.nextLine();
		while (!validations.customerPassword(password)) {
			logger.info("Please Set a valid Password ");
			password = sc.nextLine();
		}

		logger.info("Enter Adhaar Number (format 12 digits) ");
		String adhaar = sc.nextLine();
		while (!validations.customerAdhaar(adhaar)) {
			logger.info("Please enter valid Adhaar Number ");
			adhaar = sc.nextLine();
		}
		long adhaarNo = Long.parseLong(adhaar);

		logger.info("Enter your Age (>21)");
		String age1 = sc.nextLine();
		while (!validations.customerAge(age1)) {
			logger.info("Please enter valid Age ");
			age1 = sc.nextLine();
		}
		Integer age = Integer.parseInt(age1);
		logger.info("Enter Address \n");
		logger.info("H-No :");
		String hno = sc.nextLine();
		while (!validations.customerHNo(hno)) {
			logger.info("Please enter valid House Number ");
			hno = sc.nextLine();
		}
		logger.info("Street :");
		String street = sc.nextLine();

		while (!validations.customerAddress(street)) {
			logger.info("Please enter valid Street Name ");
			street = sc.nextLine();
		}
		logger.info("City :");
		String city = sc.nextLine();
		while (!validations.customerAddress(city)) {
			logger.info("Please enter valid City Name ");
			city = sc.nextLine();
		}
		logger.info("State :");
		String state = sc.nextLine();
		while (!validations.customerAddress(state)) {
			logger.info("Please enter valid State Name ");
			state = sc.nextLine();
		}

		address.setHNo(hno);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);

		customer.setCustomerName(fullname);
		customer.setCustomerPhnno(phnNo);
		customer.setCustomerEmail(email);
		customer.setCustomerAdhaarNo(adhaarNo);
		customer.setCustomerAge(age);
		customer.setCustomerPassword(password);
		customer.setAddress(address);

		
		CustomerRegistrationDao customerRegistrationDao = HotelFactory.getCustomerRegistrationDaoImpl();
		customerRegistrationDao.addCustomer(customer);
	}
	
	
	
}
