package com.capgemini.hotelbookingmanagementsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsImpl implements Validations {
	
	Pattern pat;
	Pattern pat1;
	Matcher mat;
	Matcher mat1;

	@Override
	public boolean customerName(String name) {

		pat = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerAddress(String address) {
		pat = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");
		mat = pat.matcher(address);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerPhnno(String phnno) {
		pat = Pattern.compile("[6-9][0-9]{9}");
		mat = pat.matcher(phnno);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerEmail(String email) {

		pat = Pattern.compile("^(.+)@(.+)$");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerAdhaar(String adhaar) {
		pat = Pattern.compile("[[\\d]&&[^a-z]]{12}");
		mat = pat.matcher(adhaar);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerAge(String age) {
		pat = Pattern.compile("[[\\d]&&[^a-z]]{2}");
		mat = pat.matcher(age);
		pat1 = Pattern.compile("[2-9][0-9]");
		mat1 = pat1.matcher(age);
		if (mat.matches()) {
			if (mat1.matches()) {

				return true;
			}
			return false;
		} else {
			return false;
		}

	}

	@Override
	public boolean customerPassword(String password) {
		pat = Pattern.compile("[[a-zA-Z][@!#$%^&*]{1,}[0-9]{1,}]{8,12}");
		mat = pat.matcher(password);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean Option1(String option) {

		pat = Pattern.compile("[1-5&&[^a-z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Option2(String option1) {

		pat = Pattern.compile("[1-3&&[^a-z]]{1}");
		mat = pat.matcher(option1);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Date(String date) {

		pat = Pattern.compile("[0-9]{4}-(0[1-9]|1[0-2])-(3[0-1]|[1-2][0-9]|0[0-9])");
		mat = pat.matcher(date);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hotelID(String hotelId) {

		pat = Pattern.compile("[0-9&&[^a-z]]{4}");
		mat = pat.matcher(hotelId);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean roomNumber(String roomNo) {
		pat = Pattern.compile("[a-zA-Z]{3}[0-9]{2}");
		mat = pat.matcher(roomNo);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean Option3(String option2) {
		pat = Pattern.compile("[1-4&&[^a-z]]{1}");
		mat = pat.matcher(option2);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean hotelName(String hotelname) {
		pat = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");
		mat = pat.matcher(hotelname);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hotelDescription(String Desc) {
		pat = Pattern.compile("[0-9][*]" + "\\s" + "[a-zA-Z]+");
		mat = pat.matcher(Desc);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean roomPrice(String price) {

		pat = Pattern.compile("[0-9&&[^a-z]]{1,4}");
		mat = pat.matcher(price);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String roomType(int option) {

		switch (option) {
		case 1:
			return "Single bedroom";

		case 2:
			return "Double bedroom";

		case 3:
			return "Triple bedroom";

		default:
			return null;
		}

	}

	@Override
	public String roomStatus(int option) {
		switch (option) {
		case 1:
			return "available";

		case 2:
			return "reserved";
		
		case 3:
			return "Under Maintenance";

		default:
			return null;
		}
	}

	@Override
	public boolean customerHNo(String hno) {

		pat = Pattern.compile("[a-zA-Z0-9-/]+");
		mat = pat.matcher(hno);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean hotelAddress(String hotelAdd) {
		pat = Pattern.compile("[a-zA-Z]+[\\,[\\s[a-zA-Z]+]]*");
		mat = pat.matcher(hotelAdd);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String availabilities(int availables) {
		switch (availables) {
		case 1:
			return "FREE WIFI";

		case 2:
			return "TV";
		case 3:
			return "COOLER";
		case 4:
			return "A/C";
		default:
			return null;
		}
		
	
		
		
		
	}

}
