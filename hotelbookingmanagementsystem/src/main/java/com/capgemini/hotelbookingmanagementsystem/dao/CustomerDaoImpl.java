package com.capgemini.hotelbookingmanagementsystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingmanagementsystem.bean.Hotel;
import com.capgemini.hotelbookingmanagementsystem.bean.Room;
import com.capgemini.hotelbookingmanagementsystem.exception.HotelIdNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.exception.NoRoomsBookedException;
import com.capgemini.hotelbookingmanagementsystem.exception.RoomNoNotFoundException;
import com.capgemini.hotelbookingmanagementsystem.factory.HotelFactory;
import com.capgemini.hotelbookingmanagementsystem.validations.Validations;

public class CustomerDaoImpl implements CustomerDao {
	Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	Scanner sc = new Scanner(System.in);

	public static Map<Hotel, ArrayList<Room>> hotelroomlist = new HashMap<Hotel, ArrayList<Room>>();
	static ArrayList<Room> roomlist1 = new ArrayList<Room>();
	static ArrayList<Room> roomlist2 = new ArrayList<Room>();
	static ArrayList<Room> bookingStatus = new ArrayList<Room>();
	static ArrayList<Room> blist = new ArrayList<Room>();
	static {
		Hotel hotel1 = HotelFactory.getHotel();
		hotel1.setHotelId(1001);
		hotel1.setHotelName("Taj Krishna");
		hotel1.setHotelAddress("Hyderabad");
		hotel1.setNoOfRooms(3);
		hotel1.setDescription("3 star hotel");

		Room room1 = HotelFactory.getRoom();
		room1.setRoomno("taj01");
		room1.setRoomprice(960);
		room1.setRoomStatus("available");
		room1.setRoomtype("Delux 2X");
		String[] r1 = { "A/C", "FREE WIFI", "TV" };
		room1.setAvailabilities(r1);
		room1.setFrom(null);
		room1.setTo(null);
		room1.setGuestName(null);
		roomlist1.add(room1);

		Room room2 = HotelFactory.getRoom();
		room2.setRoomno("taj02");
		room2.setRoomprice(999);
		room2.setRoomStatus("available");
		room2.setRoomtype("Classic 2X");
		String[] r2 = { "COOLER", "FREE WIFI", "TV" };
		room2.setAvailabilities(r2);
		room2.setFrom(null);
		room2.setTo(null);
		room2.setGuestName(null);
		roomlist1.add(room2);

		Room room5 = HotelFactory.getRoom();
		room5.setRoomno("taj03");
		room5.setRoomprice(1290);
		room5.setRoomStatus("reserved");
		room5.setRoomtype("Classic 3X");
		String[] r5 = { "A/C", "FREE WIFI", "TV" };
		room5.setAvailabilities(r5);
		room5.setFrom(LocalDate.now());
		room5.setTo(LocalDate.now());
		room5.setGuestName("Sathish Reddy");
		roomlist1.add(room5);
		bookingStatus.add(room5);

		Hotel hotel2 = HotelFactory.getHotel();
		hotel2.setHotelId(1002);
		hotel2.setHotelName("Mayuri Hotel");
		hotel2.setHotelAddress("Nirmal");
		hotel2.setNoOfRooms(3);
		hotel2.setDescription("2 star hotel");

		Room room3 = HotelFactory.getRoom();
		room3.setRoomno("myu01");
		room3.setRoomprice(800);
		room3.setRoomStatus("available");
		room3.setRoomtype("Classic 2X");
		String[] r3 = { "COOLER", "FREE WIFI", "TV" };
		room3.setAvailabilities(r3);
		room3.setFrom(null);
		room3.setTo(null);
		room3.setGuestName(null);
		roomlist2.add(room3);

		Room room4 = HotelFactory.getRoom();
		room4.setRoomno("myu02");
		room4.setRoomprice(1090);
		room4.setRoomStatus("reserved");
		room4.setRoomtype("Classic 3X");
		String[] r4 = { "FREE WIFI", "TV", "COOLER" };
		room4.setAvailabilities(r4);
		room4.setFrom(LocalDate.now());
		room4.setTo(LocalDate.now());
		room4.setGuestName("Akshith Reddy");
		roomlist2.add(room4);
		bookingStatus.add(room4);

		Room room6 = HotelFactory.getRoom();
		room6.setRoomno("myu03");
		room6.setRoomprice(799);
		room6.setRoomStatus("available");
		room6.setRoomtype("Classic 3X");
		String[] r6 = { "A/C", "FREE WIFI", "TV" };
		room6.setAvailabilities(r6);
		room6.setFrom(null);
		room6.setTo(null);
		room6.setGuestName(null);
		roomlist2.add(room6);

		hotelroomlist.put(hotel2, roomlist2);
		hotelroomlist.put(hotel1, roomlist1);

	}

  	@Override
	public boolean chooseHotel(int hotelId) {
		Validations validations = HotelFactory.getvalidations();
		int count = 0;

		Iterator<Hotel> itr = hotelroomlist.keySet().iterator();
		while (itr.hasNext()) {
			Hotel hotel = itr.next();
			if (hotelId == hotel.getHotelId()) {
				logger.info("Welcome to " + hotel.getHotelName()+"\n");
				logger.info("-------------------- ROOM BOOKING PORTAL ---------------------");
				count++;

				ArrayList<Room> rooms = new ArrayList<Room>(hotelroomlist.get(hotel));
				logger.info(rooms);

				logger.info("Enter Room No");
				String roomno = sc.next();
				while (!validations.roomNumber(roomno)) {
					logger.info("Please Enter Valid Room Number");
					roomno = sc.next();
				}

				for (Room room : rooms) {

					if (roomno.equals(room.getRoomno()) && room.getRoomStatus().equals("available")) {
						count++;
						logger.info("From Date (YYYY-MM-DD):");
						String fromdate = sc.next();
						while (!validations.Date(fromdate)) {
							logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
							fromdate = sc.next();
						}
						LocalDate from = LocalDate.parse(fromdate);
						while (LocalDate.now().isAfter(from)) {
							logger.info("Please enter a Valid Date \n");
							fromdate = sc.next();
							while (!validations.Date(fromdate)) {
								logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
								fromdate = sc.next();
							}
							from = LocalDate.parse(fromdate);
						}
						room.setFrom(from);

						logger.info("To Date (YYYY-MM-DD):");
						String todate = sc.next();
						while (!validations.Date(todate)) {
							logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
							todate = sc.next();
						}
						LocalDate to = LocalDate.parse(todate);
						if (from.isAfter(to)) {
							logger.info("Please enter a Valid Date \n");
							todate = sc.next();
							while (!validations.Date(todate)) {
								logger.info("Please Enter Valid Date In The Format YYYY-MM-DD ");
								todate = sc.next();
							}
							to = LocalDate.parse(todate);
						}
						room.setTo(to);
						room.setRoomStatus("reserved");

						logger.info("Enter Your Name");
						sc.nextLine();
						String guest = sc.nextLine();
						while (!validations.customerName(guest)) {
							logger.info("Please enter valid Name ");
							guest = sc.nextLine();
						}
						room.setGuestName(guest);
						logger.info("Room Has Reserved For You");
						logger.info(room);
						blist.add(room);
						bookingStatus.add(room);
					}
				}

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 1) {
				throw new RoomNoNotFoundException();
			}
		} catch (HotelIdNotFoundException e1) {
			logger.info("Please Select Hotel Id from the Given List of Hotels \n ");

		} catch (RoomNoNotFoundException e) {
			logger.info("Please Select Room number which is 'available' from the Given List of ROOMS \n ");

		}
		return true;
	}

	@Override
	public List<Room> bookingStatus() {
		logger.info("List of Bookings \n");
		try {
			if (blist.isEmpty()) {
				throw new NoRoomsBookedException();
			} else {

				logger.info(blist);
			}
		} catch (NoRoomsBookedException e2) {
			logger.info("No Bookings Done..\n");
		}

		return null;
	}

}
