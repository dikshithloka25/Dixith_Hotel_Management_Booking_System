package com.capgemini.hotelbookingmanagementsystem.bean;

public class EmployeeManagement {
private String EmailId;
private String Passsword;

public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getPasssword() {
	return Passsword;
}
public void setPasssword(String passsword) {
	Passsword = passsword;
}
@Override
public String toString() {
	return "EmployeeManagement [EmailId=" + EmailId + ", Passsword=" + Passsword + "]";
}


}
