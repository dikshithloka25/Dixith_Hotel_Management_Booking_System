package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.services.AdminService;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class AdminRoomOperations {
	ArrayList<Hotel> hotellist = new ArrayList<Hotel>(CustomerDaoImpl.hotelroomlist.keySet());

	Logger logger = Logger.getLogger(AdminRoomOperations.class);
	Scanner sc = new Scanner(System.in);
	Validations validations = HotelFactory.getvalidations();
	int count = 0;

	public void roomController() {

		do {
			logger.info("Select Any Option \n");
			logger.info("1.Add Room");
			logger.info("2.Delete Room");
			logger.info("3.Update Room");
			logger.info("4.Back");

			String option2 = sc.next();
			while (!validations.Option3(option2)) {
				logger.info("please Select Valid Option");
				option2 = sc.next();
			}
			int option = Integer.parseInt(option2);

			switch (option) {

			case 1:
				AdminService addRoom = HotelFactory.getAdminService();
				addRoom.getRoomAddOperation();

				break;
			case 2:

				logger.info("Enter Hotel ID");
				String hotelId1 = sc.next();
				while (!validations.hotelID(hotelId1)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId1 = sc.next();
				}
				Integer hotelId = Integer.parseInt(hotelId1);
				deleteRoom(hotelId);
				break;
			case 3:
				logger.info("Enter Hotel ID");
				String hotelId4 = sc.next();
				while (!validations.hotelID(hotelId4)) {
					logger.info("Please Enter Valid Hotel ID ");
					hotelId4 = sc.next();
				}
				Integer hotelId5 = Integer.parseInt(hotelId4);
				updateRoom(hotelId5);
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

	public boolean addRoom(int hotelId, Room room) {

		logger.info(CustomerDaoImpl.hotelroomlist);

		return true;
	}

	public boolean deleteRoom(int hotelId) {

		Iterator<Hotel> hotelitr = hotellist.iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId == hotel1.getHotelId()) {
				count++;
				logger.info("Welcome to" + hotel1.getHotelName());
				logger.info(CustomerDaoImpl.hotelroomlist.get(hotel1));
				logger.info("Enter Roomno");
				String roomNo = sc.next();
				while (!validations.roomNumber(roomNo)) {
					logger.info("Please Enter Valid Room Number");
					roomNo = sc.next();
				}
				ArrayList<Room> deleteroom = new ArrayList<Room>(CustomerDaoImpl.hotelroomlist.get(hotel1));
				try {
					for (Room room1 : deleteroom) {

						if (roomNo.equals(room1.getRoomno())) {
							count++;
							deleteroom.remove(room1);
							CustomerDaoImpl.hotelroomlist.put(hotel1, deleteroom);
							int n = CustomerDaoImpl.hotelroomlist.get(hotel1).size();
							int noOfRooms = n--;
							hotel1.setNoOfRooms(noOfRooms);
							logger.info(CustomerDaoImpl.hotelroomlist);
						}

					}
				} catch (ConcurrentModificationException e) {

				}

			}

		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 1) {
				throw new RoomNoNotFoundException();
			} else {
				logger.info("Room deleted successfully...\n");
			}
		} catch (HotelIdNotFoundException e1) {
			logger.info("Please Select Hotel Id from the Given List of Hotels \n ");

		} catch (RoomNoNotFoundException e) {
			logger.info("Please Select Room number from the Given List of ROOMS \n ");

		}

		return true;
	}

	public boolean updateRoom(int hotelId) {

		Iterator<Hotel> hotelitr = hotellist.iterator();
		while (hotelitr.hasNext()) {
			Hotel hotel1 = hotelitr.next();
			if (hotelId == hotel1.getHotelId()) {
				count++;
				logger.info("Welcome to" + hotel1.getHotelName());
				logger.info(CustomerDaoImpl.hotelroomlist.get(hotel1));
				logger.info("Enter Room number");
				String roomno = sc.next();
				while (!validations.roomNumber(roomno)) {
					logger.info("Please Enter Valid Room Number");
					roomno = sc.next();
				}

				ArrayList<Room> updateroom = new ArrayList<Room>(CustomerDaoImpl.hotelroomlist.get(hotel1));
				try {
					for (Room room1 : updateroom) {

						if (roomno.equals(room1.getRoomno())) {
							count++;
							logger.info("Update Room Number");
							sc.nextLine();
							String roomNo = sc.nextLine();
							while (!validations.roomNumber(roomNo)) {
								logger.info("Please Enter Valid Room Number");
								roomNo = sc.nextLine();
							}

							logger.info("Update Room Price");
							String roomPrice1 = sc.nextLine();
							while (!validations.roomPrice(roomPrice1)) {
								logger.info("Please Enter Valid Room price");
								roomPrice1 = sc.nextLine();
							}
							Double roomPrice = Double.parseDouble(roomPrice1);

							logger.info("Update Room Availabilities:(select any 3 options)");
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

							logger.info("Update Room Status");
							logger.info("1.available \n2.reserved");
							String option1 = sc.nextLine();
							while (!validations.Option2(option1)) {
								logger.info("please Select Valid Option");
								option1 = sc.nextLine();

							}
							int option3 = Integer.parseInt(option1);
							String roomStatus = validations.roomStatus(option3);

							logger.info("Update Room Type");
							logger.info("1.Single bedroom \n 2.Double bedroom \n 3.Triple bedroom");
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

							room1.setRoomno(roomNo);
							room1.setRoomStatus(roomStatus);
							room1.setRoomprice(roomPrice);
							room1.setRoomtype(roomType);
							room1.setAvailabilities(roomAvailabilities);
							room1.setFrom(fromDate);
							room1.setTo(ToDate);
							room1.setGuestName(name);
							updateroom.add(room1);
							logger.info(CustomerDaoImpl.hotelroomlist);

						}
					}
				} catch (ConcurrentModificationException c) {

				}

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 1) {
				throw new RoomNoNotFoundException();
			} else {
				logger.info("update success");

			}
		} catch (HotelIdNotFoundException e1) {
			logger.info("Please Select Hotel Id from the Given List of Hotels \n ");

		} catch (RoomNoNotFoundException e) {
			logger.info("Please Select Room number from the Given List of ROOMS \n ");

		}

		return true;
	}

}
