package com.megacitycab.model;

public class Car {
	private int carId;
	private String model;
	private String brand;
	private String regNumber;
	private boolean availability;
	private String imagePath;

	public Car(int carId, String model, String brand, String regNumber, boolean availability, String imagePath) {
		this.carId = carId;
		this.model = model;
		this.brand = brand;
		this.regNumber = regNumber;
		this.availability = availability;
		this.imagePath = imagePath;
	}

	// Getters and Setters
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
