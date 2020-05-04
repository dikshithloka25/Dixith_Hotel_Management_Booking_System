package com.capgemini.hotelbookingmanagementsystem.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminHotelOperations;
import com.capgemini.hotelbookingmanagementsystem.dao.AdminRoomOperations;
import com.capgemini.hotelbookingmanagementsystem.dao.CustomerDaoImpl;
import com.capgemini.hotelbookingmanagementsystem.dao.LoginForm;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdExistsException;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoExistsException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class AdminService {
	static Logger logger = Logger.getLogger(AdminService.class);
	Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();

	public void getAdminLoginService() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String email = properties.getProperty("adminEmail");

		String password = properties.getProperty("adminPassword");

		LoginForm adminLogin = HotelFactory.getAdminLogin();

		if (adminLogin.login(email, password) == true) {

			logger.info("**************Welcome ADMIN**************\n");
			adminLogin.controller();

		}

	}

	public void getHotelAddOperation() {

		int count = 0;
		logger.info("Enter Hotel ID");

		String hotelId1 = sc.nextLine();
		while (!validations.hotelID(hotelId1)) {
			logger.info("Please Enter Valid Hotel ID ");
			hotelId1 = sc.nextLine();
		}
		Integer hotelID = Integer.parseInt(hotelId1);
		Iterator<Hotel> itr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		while (itr.hasNext()) {
			Hotel hotel2 = itr.next();
			if (hotelID == hotel2.getHotelId()) {
				count = 3;
			}
		}
		try {
			if (count == 3) {
				throw new HotelIdExistsException();
			}
		} catch (HotelIdExistsException e) {
			logger.info("Hotel Id Already Exists..\n");
			logger.info("Please enter Different Hotel Id ");
			hotelId1 = sc.nextLine();
			while (!validations.hotelID(hotelId1)) {
				logger.info("Please Enter Valid Hotel ID ");
				hotelId1 = sc.nextLine();
			}
			hotelID = Integer.parseInt(hotelId1);

		}

		logger.info("Enter Hotel Name ");
		String hotelName = sc.nextLine();

		while (!validations.hotelName(hotelName)) {
			logger.info("Please Enter Valid Hotel Name ");
			hotelName = sc.nextLine();
		}

		int hotelNoofRooms = 0;

		logger.info("Enter Hotel Description (eg:5* hotel)");
		String hotelDesc = sc.nextLine();
		while (!validations.hotelDescription(hotelDesc)) {
			logger.info("Please Enter Valid Hotel Desc ");
			hotelDesc = sc.nextLine();
		}

		logger.info("Enter Hotel Address:(please enter street,City & State)");
		String hotelAddress = sc.nextLine();
		while (!validations.hotelAddress(hotelAddress)) {
			logger.info("Please Enter Valid Hotel Address ");
			hotelAddress = sc.nextLine();
		}

		AdminHotelOperations adminHotel = HotelFactory.getAdminHotelOperations();
		adminHotel.addHotel(new Hotel(hotelID, hotelName, hotelNoofRooms, hotelDesc, hotelAddress));

	}

	public void getHotelUpdateOperation() {

		int count = 0;
		logger.info(CustomerDaoImpl.hotelroomlist.keySet());
		logger.info("Enter Hotel ID ");
		String hotelId1 = sc.next();
		while (!validations.hotelID(hotelId1)) {
			logger.info("Please Enter Valid Hotel ID ");
			hotelId1 = sc.next();
		}
		Integer hotelid = Integer.parseInt(hotelId1);
		Iterator<Hotel> hotelitr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelid == hotel1.getHotelId()) {
				count++;
				logger.info("Update Hotel ID");
				sc.nextLine();
				String hotelId = sc.nextLine();
				while (!validations.hotelID(hotelId)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId = sc.nextLine();
				}
				Integer hotelID = Integer.parseInt(hotelId);

				logger.info("Update Hotel Name ");
				String hotelName = sc.nextLine();

				while (!validations.hotelName(hotelName)) {

					logger.info("Please Enter Valid Hotel Name ");
					hotelName = sc.nextLine();
				}

				logger.info("Update Hotel Description (eg:5* hotel)");
				String hotelDesc = sc.nextLine();
				while (!validations.hotelDescription(hotelDesc)) {
					logger.info("Please Enter Valid Hotel Description ");
					hotelDesc = sc.nextLine();
				}

				logger.info("Update Hotel Address (Enter street,City & State)");
				String hotelAddress = sc.nextLine();
				while (!validations.hotelAddress(hotelAddress)) {
					logger.info("Please Enter Valid Hotel Address ");
					hotelAddress = sc.nextLine();
				}

				hotel1.setHotelId(hotelID);
				hotel1.setHotelName(hotelName);
				hotel1.setDescription(hotelDesc);
				hotel1.setHotelAddress(hotelAddress);
				AdminHotelOperations updateHotel = HotelFactory.getAdminHotelOperations();
				updateHotel.updateHotel(hotelid, hotel1);

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else {
				logger.info("Hotel Updated Successfully");

			}
		} catch (HotelIdNotFoundException e) {
			logger.info("Please Select Hotel Id from the Given List of Hotels \n ");

		}

	}

	public void getRoomAddOperation() {
		int count = 0;
		logger.info(CustomerDaoImpl.hotelroomlist.keySet());
		logger.info("Enter Hotel ID");
		String hotelId2 = sc.next();
		while (!validations.hotelID(hotelId2)) {
			logger.info("Please Enter Valid Hotel ID ");
			hotelId2 = sc.next();
		}
		Integer hotelId3 = Integer.parseInt(hotelId2);
		Iterator<Hotel> hotelitr = CustomerDaoImpl.hotelroomlist.keySet().iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId3 == hotel1.getHotelId()) {
				count++;
				ArrayList<Room> addRoom1 = new ArrayList<Room>(CustomerDaoImpl.hotelroomlist.get(hotel1));
				int size = addRoom1.size();
				logger.info(addRoom1);
				Room room = HotelFactory.getRoom();

				sc.nextLine();
				logger.info("Enter Room Number");
				String roomNo = sc.nextLine();
				Iterator<Room> room1 = addRoom1.iterator();
				while (room1.hasNext()) {
					Room room2 = room1.next();
					if (roomNo.equals(room2.getRoomno())) {
						count = 8;
					}

				}
				try {
					if (count == 8) {
						throw new RoomNoExistsException();
					} else {

						while (!validations.roomNumber(roomNo)) {
							logger.info("Please Enter Valid Room Number");
							roomNo = sc.nextLine();
						}
					}
				} catch (RoomNoExistsException e) {
					logger.info("Room nuber already Exists \n");
					logger.info("Please Enter different Room Number \n");
					roomNo = sc.nextLine();
				}

				logger.info("Enter Room Price");
				String roomPrice1 = sc.nextLine();
				while (!validations.roomPrice(roomPrice1)) {
					logger.info("Please Enter Valid Room price");
					roomPrice1 = sc.nextLine();
				}
				Double roomPrice = Double.parseDouble(roomPrice1);

				logger.info("Enter Room Status");
				logger.info("1.available \n2.reserved \n3.Under Maintenance");
				String option1 = sc.nextLine();
				while (!validations.Option2(option1)) {
					logger.info("please Select Valid Option");
					option1 = sc.nextLine();

				}
				int option3 = Integer.parseInt(option1);
				String roomStatus = validations.roomStatus(option3);

				logger.info("Enter Room Availabilities:(select any 3 options)");
				logger.info("1.FREE WIFI \n2.TV \n3.COOLER \n4.A/C \n");

				String roomAvailabilities[] = new String[3];
				for (int i = 0; i < roomAvailabilities.length; i++) {
					String option = sc.nextLine();
					while (!validations.Option3(option)) {
						logger.info("please Select Valid Option");
						option = sc.nextLine();
					}
					int availables = Integer.parseInt(option);

					roomAvailabilities[i] = validations.availabilities(availables);
				}

				room.setAvailabilities(roomAvailabilities);

				logger.info("Enter Room Type");
				logger.info("1.Single bedroom \n2.Double bedroom \n3.Triple bedroom ");
				String option2 = sc.nextLine();
				while (!validations.Option2(option2)) {
					logger.info("please Select Valid Option");
					option2 = sc.nextLine();

				}
				int option = Integer.parseInt(option2);

				String roomType = validations.roomType(option);

				LocalDate fromDate = null;

				LocalDate ToDate = null;

				String name = null;

				room.setRoomno(roomNo);
				room.setRoomStatus(roomStatus);
				room.setRoomprice(roomPrice);
				room.setRoomtype(roomType);
				room.setFrom(fromDate);
				room.setTo(ToDate);
				room.setGuestName(name);
				addRoom1.add(room);
				CustomerDaoImpl.hotelroomlist.put(hotel1, addRoom1);
				int n = CustomerDaoImpl.hotelroomlist.get(hotel1).size();
				int noOfRooms = n++;
				hotel1.setNoOfRooms(noOfRooms);

				if (size == (addRoom1.size() - 1)) {
					logger.info("Room Added Successfull....\n");
				} else {
					logger.info("Something Went Wrong..\n");
				}
				AdminRoomOperations addRoom = HotelFactory.getAdminRoomOperations();
				addRoom.addRoom(hotelId3, room);

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			}
		} catch (HotelIdNotFoundException e) {
			logger.info("Hotel id Not Found");

		}

	}

}
