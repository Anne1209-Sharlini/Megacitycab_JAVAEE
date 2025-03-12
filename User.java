package com.megacitycab.model;

public class User {
	  private int id;
	    private String fname;
	    private String email;
	    private String password;
	    private String nicNo;
	    private String address;
	    private String mobileNo;
	    private String customerNo;



	public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

	

	public User(String fname, String email, String password, String nicNo, String address, String mobileNo,
				String customerNo) {
			super();
			
			this.fname = fname;
			this.email = email;
			this.password = password;
			this.nicNo = nicNo;
			this.address = address;
			this.mobileNo = mobileNo;
			this.customerNo = customerNo;
		}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
}