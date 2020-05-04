package com.capgemini.hotelbookingmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;
import com.capgemini.hotelbookingmanagementsystem.services.EmployeeManagementService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerRegistrationService;

public class HotelBookingManagementSystem {

	static Scanner sc = new Scanner(System.in);
	static Logger logger = Logger.getLogger(HotelBookingManagementSystem.class);

	public static void main(String[] args) {
		Validations validations = HotelFactory.getvalidations();
		logger.info("*********Welcome To Online Hotel Management Service********* \n");

		do {

			logger.info("Please Select Who you are..? \n");
			logger.info("1.Customer LOGIN");
			logger.info("2.Employee LOGIN");
			logger.info("3.Admin LOGIN");
			logger.info("4.New Customer Registration");
			logger.info("5.Exit");
			String option1 = sc.next();
			while (!validations.Option1(option1)) {
				logger.info("Please Select valid Option");
				option1 = sc.next();

			}
			int option = Integer.parseInt(option1);

			switch (option) {
			case 1:
				CustomerService customerService = HotelFactory.getCustomerService();
				customerService.getCustomerLoginService();
				break;
			case 2:
				EmployeeManagementService employeeManagementService = new EmployeeManagementService();
				employeeManagementService.getEmployeeLogin();
				break;
			case 3:
				AdminService adminService = new AdminService();
				adminService.getAdminLoginService();
				break;
			case 4:
				CustomerRegistrationService customerRegistrationService = HotelFactory.getCustomerRegistrationService();
				customerRegistrationService.service();
				break;
			case 5:
				logger.info("Thank You......");
				System.exit(0);
				break;

			default:
				logger.info("please enter valid option \n");
				break;
			}

		} while (true);

	}
}
