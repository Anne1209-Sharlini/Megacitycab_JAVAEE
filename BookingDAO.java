package com.megacitycab.dao;

import com.megacitycab.model.Booking;
import com.megacitycab.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {

    // Insert a new booking
    public boolean insertBooking(Booking booking) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        
        // SQL query to insert a booking
        String query = "INSERT INTO bookingscabs (booking_ref, customer_name, customer_contact,car_id, cuaddress, " +
                       "destination, booking_status, distance, total_fare) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // Create a prepared statement
            ps = connection.prepareStatement(query);
            
            // Set values in the query
            ps.setString(1, booking.getReferenceNo());
            ps.setString(2, booking.getCustomerName());
            ps.setString(3, booking.getCustomerContact());
            ps.setInt(4, booking.getCarId());
            ps.setString(5, booking.curraddress());
            ps.setString(6, booking.getDestination());
            ps.setString(7, booking.getBookingStatus());
           
            ps.setDouble(8, booking.getDistance());
            ps.setDouble(9, booking.getTotalFare());
          

            // Execute the query
            int result = ps.executeUpdate();
            return result > 0;  // Returns true if insert was successful
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Get the last booking reference number to generate the next one
    public String generateReferenceNo() {
        String referenceNo = "";
        String query = "SELECT MAX(CAST(SUBSTRING(booking_ref, 6) AS UNSIGNED)) AS last_number FROM bookingscabs WHERE booking_ref LIKE 'MCCBK%'";

        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                int lastNumber = rs.getInt("last_number");
                lastNumber++;  // Increment the last number by 1

                // Generate the reference number with the prefix 'MCCBK' and padded to 3 digits
                referenceNo = "MCCBK" + String.format("%03d", lastNumber);
            } else {
                // If no reference number exists, start with MCCBK001
                referenceNo = "MCCBK001";
            }

            // Check if the generated reference number already exists in the database
            while (isReferenceExists(referenceNo)) {
                int lastNumber = Integer.parseInt(referenceNo.substring(5)) + 1;
                referenceNo = "MCCBK" + String.format("%03d", lastNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return referenceNo;
    }
    // Method to check if the reference number already exists in the database
    private boolean isReferenceExists(String referenceNo) {
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM bookingscabs WHERE booking_ref = ?";

        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, referenceNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }


    // Method to fetch the fare rate for the car based on car ID
    

    // Calculate the total fare based on the car's fare rate and distance
    public double calculateFare(double distance, int carId) {
        double fareRate = 0;

        // Get the fare rate for the selected car
        String query = "SELECT fare_per_km FROM cars WHERE car_id = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, carId);
            rs = ps.executeQuery();

            if (rs.next()) {
                fareRate = rs.getDouble("fare_per_km");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Calculate the total fare (distance * fare rate)
        return fareRate * distance;
    }

}
