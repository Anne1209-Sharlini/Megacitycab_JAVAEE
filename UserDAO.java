package com.megacitycab.dao;

import com.megacitycab.model.User;
import com.megacitycab.util.DBConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserDAO {

    public boolean authenticateUser(String email, String password) {
        Connection conn = DBConnection.getConnection();
        boolean isAuthenticated = false;
        String hashedPassword = hashPassword(password);

        String sql = "SELECT * FROM userlogin WHERE email = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, hashedPassword);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean emailExists(String email) {
        Connection conn = DBConnection.getConnection();
        boolean exists = false;

        try {
            String sql = "SELECT * FROM userlogin WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public boolean nicExists(String nicNo) {
        Connection conn = DBConnection.getConnection();
        boolean exists = false;

        try {
            String sql = "SELECT * FROM userlogin WHERE nic_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nicNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public String generateCustomerNo() {
        Connection conn = DBConnection.getConnection();
        String lastCustomerNo = "MCC000";
        String newCustomerNo;

        try {
            String sql = "SELECT customer_no FROM userlogin ORDER BY id DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lastCustomerNo = rs.getString("customer_no");
            }

            int lastNumber = Integer.parseInt(lastCustomerNo.substring(3));
            newCustomerNo = "MCC" + String.format("%03d", lastNumber + 1);

        } catch (SQLException e) {
            e.printStackTrace();
            newCustomerNo = "MCC001";
        }
        return newCustomerNo;
    }

    public boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        return Pattern.matches(regex, password);
    }

    public boolean registerUser(User user) {
        boolean status = false;
        Connection conn = DBConnection.getConnection();

        if (emailExists(user.getEmail()) || nicExists(user.getNicNo())) {
            System.out.println("Debug: Email or NIC already exists in DB!");
            return false;
        }

        String customerNo = generateCustomerNo();
        String hashedPassword = hashPassword(user.getPassword());

        String sql = "INSERT INTO userlogin (customer_no, fname, email, password, nic_no, address,mobile_no) VALUES (?,?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerNo);
            ps.setString(2, user.getFname());
            ps.setString(3, user.getEmail());
            ps.setString(4, hashedPassword);
            ps.setString(5, user.getNicNo());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getMobileNo());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}
