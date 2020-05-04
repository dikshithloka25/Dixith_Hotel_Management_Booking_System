package com.capgemini.hotelbookingmanagementsystem.dao;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class AdminHotelOperations {
	int count = 0;
	Logger logger = Logger.getLogger(AdminHotelOperations.class);
	Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();

	public void hotelController() {
		do {
			logger.info("Select Any Option \n");
			logger.info("1.Add hotel");
			logger.info("2.Delete Hotel");
			logger.info("3.Update Hotel");
			logger.info("4.Back");

			String option2 = sc.next();
			while (!validations.Option3(option2)) {
				logger.info("please Select Valid Option");
				option2 = sc.next();
			}
			int option = Integer.parseInt(option2);

			switch (option) {

			case 1:
				AdminService addHotel = HotelFactory.getAdminService();
				addHotel.getHotelAddOperation();

				break;
			case 2:
				logger.info(CustomerDaoImpl.hotelroomlist.keySet());
				logger.info("Enter Hotel ID ");
				String hotelId1 = sc.next();
				while (!validations.hotelID(hotelId1)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId1 = sc.next();
				}
				Integer hotelid = Integer.parseInt(hotelId1);

				deleteHotel(hotelid);
				break;
			case 3:
				AdminService updateHotel = HotelFactory.getAdminService();
				updateHotel.getHotelUpdateOperation();

				break;
			case 4:
				LoginForm adminLogin = HotelFactory.getAdminLogin();
				adminLogin.controller();
				break;
			default:
				logger.info("please enter valid option \n");
				break;

			}
		} while (true);

	}

	public boolean addHotel(Hotel hotel) {
		int size = CustomerDaoImpl.hotelroomlist.size();

		CustomerDaoImpl.hotelroomlist.put(hotel, new ArrayList<Room>());

		logger.info(CustomerDaoImpl.hotelroomlist);

		if (size == (CustomerDaoImpl.hotelroomlist.size() - 1)) {
			logger.info(hotel.getHotelName() + " Added Successfull.... \n");
		} else {
			logger.info("Something Went Wrong..\n");

		}
		return true;
	}

	public boolean deleteHotel(int hotelid) {

		Iterator<Hotel> hotelitr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		try {
			while (hotelitr.hasNext()) {
				Hotel hotel1 = hotelitr.next();
				if (hotelid == hotel1.getHotelId()) {
					count++;
					CustomerDaoImpl.hotelroomlist.remove(hotel1);
					logger.info(CustomerDaoImpl.hotelroomlist);
				}

			}
		} catch (ConcurrentModificationException m) {

		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else {
				logger.info("Hotel Deleted Successfully..\n");

			}
		} catch (HotelIdNotFoundException e) {
			logger.info("Please Select Hotel Id from the Given List of Hotels \n ");
			return false;
		}
		return true;
	}

	public boolean updateHotel(int hotelid, Hotel hotel) {

		logger.info(CustomerDaoImpl.hotelroomlist);
		return true;
	}

}
