package com.megacitycab.model;




public class Booking {
    private String referenceNo;
    private String customerName;
    private String customerContact;
    private int carId;
    private String curraddress;
    private String destination;
    private double distance;
    private double totalFare;
    private String bookingStatus;
    private String createdAt;

    // Default constructor
    public Booking() {}

    // Constructor with all fields
    public Booking(String referenceNo, String customerName, String customerContact, int carId, 
                   String curraddress, String destination, double distance, double totalFare, 
                   String bookingStatus) {
        this.referenceNo = referenceNo;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.carId = carId;
        this.curraddress = curraddress;
        this.destination = destination;
        this.distance = distance;
        this.totalFare = totalFare;
        this.bookingStatus = bookingStatus;
    }

    // Getters and Setters
    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String curraddress() {
        return curraddress;
    }

    public void curraddress(String curraddress) {
        this.curraddress = curraddress;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
