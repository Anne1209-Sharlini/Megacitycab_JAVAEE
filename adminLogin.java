package com.megacitycab.model;

public class adminLogin {
private int adminid;
private String uname;
private String password;
public int getAdminid() {
	return adminid;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public adminLogin(int adminid, String uname, String password) {
	super();
	this.adminid = adminid;
	this.uname = uname;
	this.password = password;
}
public adminLogin( String uname, String password) {
	super();
	
	this.uname = uname;
	this.password = password;
}

public adminLogin() {}
}
