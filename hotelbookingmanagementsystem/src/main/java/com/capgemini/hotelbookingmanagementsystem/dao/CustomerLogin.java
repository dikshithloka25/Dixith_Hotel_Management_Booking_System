package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.controller.HotelBookingManagementSystem;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class CustomerLogin implements LoginForm {
	final Logger logger = Logger.getLogger(CustomerLogin.class);
	Scanner sc = new Scanner(System.in);

	CustomerRegistrationDao customerRegistrationDao = HotelFactory.getCustomerRegistrationDaoImpl();

	List<Customer> custlist = new ArrayList<Customer>(CustomerRegistrationDaoImpl.list);

	public boolean login(String email, String password) {
		int count = 0;
		Iterator<Customer> itr = custlist.iterator();
		while (itr.hasNext()) {

			Customer customer1 = itr.next();
			if (email.equals(customer1.getCustomerEmail()) && password.equals(customer1.getCustomerPassword())) {
				count++;
				logger.info("Login Succcessfull...\n");
				logger.info("*******************Welcome " + customer1.getCustomerName() + "************************\n");

			}

		}
		if (count != 0) {

			return true;

		} else {
			logger.info("login failed");
			return false;
		}

	}

	public void controller() {
		Validations validations = HotelFactory.getvalidations();

		do {
			logger.info("1.Hotel Booking");
			logger.info("2.Booking Status");
			logger.info("3.Logout");

			String option2 = sc.next();
			while (!validations.Option2(option2)) {
				logger.info("please Select Valid Option");
				option2 = sc.next();

			}
			int option1 = Integer.parseInt(option2);

			switch (option1) {
			case 1:
				CustomerService customerHotelList = HotelFactory.getCustomerService();
				customerHotelList.getCustomerDaoImplService();
				break;
			case 2:
				CustomerDao bookingStatus = HotelFactory.getCustomerDaoImpl();
				bookingStatus.bookingStatus();
				break;
			case 3:

				logger.info("Logout successfull \n");
				CustomerDaoImpl.blist.clear();
				HotelBookingManagementSystem.main(null);

				break;

			}
		} while (true);

	}

}
