package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.controller.HotelBookingManagementSystem;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class EmployeeManagementLogin implements LoginForm {
	final Logger logger = Logger.getLogger(EmployeeManagementLogin.class);
	Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();

	@Override
	public boolean login(String email, String password) {

		if (email.equals("employee@gmail.com") && password.equals("employee@123")) {

			logger.info("Login Successfull....\n");
			logger.info("**************Welcome Employee..**************\n");

			return true;
		}

		else {
			logger.info("Please Enter Valid Login Credentials \n");
			return false;
 
		}

	}

	@Override
	public void controller() {
		do {
			logger.info("1.Hotel Booking");
			logger.info("2.Booking Status");
			logger.info("3.Customer List");
			logger.info("4.Logout");

			String option2 = sc.next();
			while (!validations.Option3(option2)) {
				logger.info("please Select Valid Option");
				option2 = sc.next();
			}
			int option = Integer.parseInt(option2);

			switch (option) {
			case 1:
				CustomerService employeeHotelList = HotelFactory.getCustomerService();
				employeeHotelList.getCustomerDaoImplService();
				break;
			case 2:

				List<Room> bookingStatus = new ArrayList<Room>(CustomerDaoImpl.bookingStatus);
				logger.info(bookingStatus);

				break;
			case 3:
				List<Customer> customerList = new ArrayList<Customer>(CustomerRegistrationDaoImpl.list);
				logger.info(customerList);
				break;
			case 4:
				logger.info("Logout successfull \n");
				HotelBookingManagementSystem.main(null);
				break;

			}

		} while (true);

	}

}
