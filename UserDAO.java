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
        System.out.println("Debug: emailExists() = " + exists);
        return exists;
    }

    public boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        boolean valid = Pattern.matches(regex, password);
        System.out.println("Debug: isValidPassword() = " + valid);
        return valid;
    }

    public boolean registerUser(User user) {
        boolean status = false;
        Connection conn = DBConnection.getConnection();

        if (emailExists(user.getEmail())) {
            System.out.println("Debug: Email already exists in DB!");
            return false;
        }

        String sql = "INSERT INTO userlogin (fname, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword()); // Hashed password

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Debug: registerUser() = " + status);
        return status;
    }
  
   
    
}