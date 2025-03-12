package com.megacitycab.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.megacitycab.model.Car;
import com.megacitycab.util.DBConnection;

public class CarDAO {
    // Add Car
    public void addCar(Car car) {
        String query = "INSERT INTO cars (model, brand, reg_number, availability, image_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, car.getModel());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getRegNumber());
            stmt.setBoolean(4, car.isAvailability());
            stmt.setString(5, car.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get All Cars
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        String query = "SELECT * FROM cars";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Car car = new Car(rs.getInt("car_id"), rs.getString("model"), rs.getString("brand"),
                        rs.getString("reg_number"), rs.getBoolean("availability"), rs.getString("image_path"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    // Delete Car
    public void deleteCar(int carId) {
        String query = "DELETE FROM cars WHERE car_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, carId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // get count of cars
    public int getCarCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM cars"; // Adjust table name if necessary

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
