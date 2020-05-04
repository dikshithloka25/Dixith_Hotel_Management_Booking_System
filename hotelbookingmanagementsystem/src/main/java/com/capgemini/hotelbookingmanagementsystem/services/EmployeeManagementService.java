package com.capgemini.hotelbookingmanagementsystem.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.dao.LoginForm;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;

public class EmployeeManagementService {

	static final Logger logger = Logger.getLogger(EmployeeManagementService.class);
	Scanner sc = new Scanner(System.in);

	public void getEmployeeLogin() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String email = properties.getProperty("employeeEmail");

		String password = properties.getProperty("employeePassord");

		LoginForm employeeManagementLogin = HotelFactory.getEmployeeManagementLogin();

		if (employeeManagementLogin.login(email, password) == true) {

			employeeManagementLogin.controller();
		}
	}
}
