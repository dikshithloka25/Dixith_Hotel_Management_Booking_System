package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.exception.DateNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.NoRoomsBookedException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class Reports {
	Logger logger = Logger.getLogger(Reports.class);
	Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();

	public void reportsController() {
		do {
			logger.info("Select Any Option \n");
			logger.info("1.List of Hotels");
			logger.info("2.Bookings of Hotel");
			logger.info("3.Guest of Hotel");
			logger.info("4.Bookings of Date");
			logger.info("5.Back");

			String option1 = sc.next();
			while (!validations.Option1(option1)) {
				logger.info("Please Select valid Option");
				option1 = sc.next();

			}
			int option = Integer.parseInt(option1);

			switch (option) {

			case 1:
				logger.info("List Of Hotels \n");
				logger.info(CustomerDaoImpl.hotelroomlist.keySet());
				break;
			case 2:
				logger.info("Enter Hotel ID");
				String hotelId2 = sc.next();
				while (!validations.hotelID(hotelId2)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId2 = sc.next();
				}
				Integer hotelID1 = Integer.parseInt(hotelId2);
				specificHotelBookingList(hotelID1);
				break;
			case 3:
				logger.info("Enter Hotel ID");
				String hotelId1 = sc.next();
				while (!validations.hotelID(hotelId1)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId1 = sc.next();
				}
				Integer hotelID = Integer.parseInt(hotelId1);
				hotelGuestName(hotelID);
				break;
			case 4:
				logger.info("Enter Specific Date (YYYY-MM-DD) :");
				String date = sc.next();
				while (!validations.Date(date)) {
					logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
					date = sc.next();
				}
				LocalDate ld = LocalDate.parse(date);
				bookingsByDate(ld);
				break;
			case 5:
				LoginForm adminLogin = HotelFactory.getAdminLogin();
				adminLogin.controller();
				break;
			default:
				break;

			}
		} while (true);

	}

	public boolean bookingsByDate(LocalDate ld) {
		int count = 0;

		for (Room room : CustomerDaoImpl.bookingStatus) {
			if (ld.equals(room.getFrom())) {
				count++;
				logger.info(room);
			}

		}
		try {
			if (count == 0) {
				throw new DateNotFoundException();
			}
		} catch (DateNotFoundException e) {
			logger.info("No Room Booked On the Specific Date " + ld + "\n");
		}
		return true;

	}

	public boolean hotelGuestName(int hotelID) {
		int count = 0;
		ArrayList<String> name = new ArrayList<String>();
		logger.info(CustomerDaoImpl.hotelroomlist.keySet());

		Iterator<Hotel> hotelitr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelID == hotel1.getHotelId()) {
				ArrayList<Room> rooms = new ArrayList<Room>(CustomerDaoImpl.hotelroomlist.get(hotel1));

				for (Room room : rooms) {
					if (room.getRoomStatus().equals("reserved")) {
						count++;
						name.add(room.getGuestName());
					}
				}
				logger.info("List of Guests of " + hotel1.getHotelName());
				logger.info(name);
			}
		}
		try {
			if (count == 0) {
				throw new NoRoomsBookedException();
			}
		} catch (NoRoomsBookedException e) {
			logger.info("No Rooms Reserved By any Guests");
		}

		return true;

	}

	public boolean specificHotelBookingList(int hotelID) {
		int count = 0;
		ArrayList<Room> specificHotelList = new ArrayList<Room>();
		logger.info(CustomerDaoImpl.hotelroomlist.keySet());

		Iterator<Hotel> hotelitr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelID == hotel1.getHotelId()) {
				count++;
				ArrayList<Room> rooms = new ArrayList<Room>(CustomerDaoImpl.hotelroomlist.get(hotel1));

				for (Room room : rooms) {
					if (room.getRoomStatus().equals("reserved")) {
						specificHotelList.add(room);
					}
				}
				logger.info("List of Bookings of " + hotel1.getHotelName());
				logger.info(specificHotelList);
			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 1) {
				throw new NoRoomsBookedException();
			}
		} catch (HotelIdNotFoundException e) {
			logger.info("Hotel ID not Found");
		} catch (NoRoomsBookedException e1) {
			logger.info("No Rooms Reserved for that Hotel");
		}

		return true;
	}

}
