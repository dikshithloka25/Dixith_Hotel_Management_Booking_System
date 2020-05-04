package com.capgemini.hotelbookingmanagementsystem.factory;

import com.capgemini.hotelbookingmanagementsystem.bean.Address;
import com.capgemini.hotelbookingmanagementsystem.bean.Customer;
import com.capgemini.hotelbookingmanagementsystem.bean.EmployeeManagement;
import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminHotelOperations;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminLogin;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminRoomOperations;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDao;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerLogin;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerRegistrationDao;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerRegistrationDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.EmployeeManagementLogin;
import com.capgemini.hotelbookingmanagementsystem.dao.LoginForm;
import com.capgemini.hotelbookingmanagementsystem.dao.Reports;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerRegistrationService;
import com.capgemini.hotelbookingmanagementsystem.services.CustomerService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;
import com.capgemini.hotelbookingmanagementsystem.validations.ValidationsImpl;

public class HotelFactory {

	public static Customer getCustomer() {

		return new Customer();

	}

	public static Address getAddress() {

		return new Address();
	}
	
	public static Room getRoom() {

		return new Room();
	}

	public static Hotel getHotel() {

		return new Hotel();

	}

	public static LoginForm getAdminLogin() {
		return new AdminLogin();

	}

	public static EmployeeManagement getEmployeeManagement() {

		return new EmployeeManagement();

	}

	public static CustomerRegistrationDao getCustomerRegistrationDaoImpl() {

		return new CustomerRegistrationDaoImpl();

	}

	public static Validations getvalidations() {

		return new ValidationsImpl();

	}

	public static CustomerDao getCustomerDaoImpl() {

		return new CustomerDaoImpl();

	}

	public static CustomerRegistrationService getCustomerRegistrationService() {
		
		return new CustomerRegistrationService();
	}

	public static CustomerService getCustomerService() {

		return new CustomerService();

	}

	public static LoginForm getCustomerLoginDaoImpl() {

		return new CustomerLogin();

	}

	public static LoginForm getEmployeeManagementLogin() {

		return new EmployeeManagementLogin();
	}

	public static AdminHotelOperations getAdminHotelOperations() {

		return new AdminHotelOperations();

	}

	public static AdminRoomOperations getAdminRoomOperations() {

		return new AdminRoomOperations();

	}

	public static Reports getReports() {

		return new Reports();

	}
	
	public static AdminService getAdminService() {
		
		return new AdminService();
	}

}
