package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.controller.HotelBookingManagementSystem;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class AdminLogin implements LoginForm {
	static final Logger logger = Logger.getLogger(AdminLogin.class);
	static Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();

	@Override
	public boolean login(String email,String password) {

		
		if (email.equals("admin@gmail.com") && password.equals("admin@123")) {
			logger.info("Login successfull...\n");
			return true;

		} else {
			logger.info("Please Enter Valid Login Credentials \n");
			return false;
		}
	}

	@Override
	public void controller() {
		do {
			logger.info("1.Room Operations");
			logger.info("2.Hotel operations");
			logger.info("3.Reports");
			logger.info("4.Logout");
			
			String option2 = sc.next();
			while (!validations.Option3(option2)) {
				logger.info("please Select Valid Option");
				option2 = sc.next();
			}
			int option = Integer.parseInt(option2);
			
			switch (option) {

			case 1:
				AdminRoomOperations adminRoomOperations = HotelFactory.getAdminRoomOperations();
				adminRoomOperations.roomController();
				break;
			case 2:
				AdminHotelOperations adminHotelOperations = HotelFactory.getAdminHotelOperations();
				adminHotelOperations.hotelController();
				break;
			case 3:
				Reports reports = HotelFactory.getReports();
				reports.reportsController();
				break;
			case 4:
				logger.info("Logout successfull \n");
				HotelBookingManagementSystem.main(null);
				break;
			default:
				logger.info("please enter valid option \n");
				break;

			}

		} while (true);

	}

}
