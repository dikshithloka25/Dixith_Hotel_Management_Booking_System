package com.capgemini.hotelbookingmanagementsystem.services;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDao;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.LoginForm;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class CustomerService {
	static Logger logger = Logger.getLogger(CustomerService.class);
	Scanner sc = new Scanner(System.in);


	Validations validations = HotelFactory.getvalidations();
	public void getCustomerLoginService() {
		LoginForm customerLoginForm = HotelFactory.getCustomerLoginDaoImpl();

		logger.info("Enter Email ID ");
		String emailid = sc.next();
		while (!validations.customerEmail(emailid)) {
			logger.info("Please Enter Valid Email ID ");
			emailid = sc.next();
		}
		logger.info("Enter Password ");
		String password = sc.next();
		while (!validations.customerPassword(password)) {
			logger.info("Please Set a valid Password ");
			password = sc.next();
		}
		

		if (customerLoginForm.login(emailid,password) == true) {
			customerLoginForm.controller();
		} else {
			logger.info("Please Enter Valid Login Credentials \n");
		}

	}

	public void getCustomerDaoImplService() {
		CustomerDao customerDaoImpl = HotelFactory.getCustomerDaoImpl();
		logger.info("------------------- HOTEL BOOKING PORTAL -------------------\n");
		logger.info("List of Hotels..\n");
		logger.info(CustomerDaoImpl.hotelroomlist.keySet());
		logger.info("Enter Hotel ID ");
		String hotelId1 = sc.next();
		while (!validations.hotelID(hotelId1)) {
			logger.info("Please Enter Valid Hotel ID ");
			hotelId1 = sc.next();
		}
		Integer hotelId = Integer.parseInt(hotelId1);
		customerDaoImpl.chooseHotel(hotelId);
	}

}
