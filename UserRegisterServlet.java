package com.megacitycab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.megacitycab.dao.UserDAO;
import com.megacitycab.model.User;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get input parameters from the form
        String name = request.getParameter("fname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String conpassword = request.getParameter("conpassword");
        String nicNo = request.getParameter("nic_no");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobile_no");

        UserDAO userDAO = new UserDAO();

        // Check if email already exists
        if (userDAO.emailExists(email)) {
            request.setAttribute("message", "Email already registered!");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Check if NIC number already exists
        if (userDAO.nicExists(nicNo)) {
            request.setAttribute("message", "NIC number already registered!");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Validate NIC number format
        if (!(nicNo.matches("\\d{9}[A-Za-z]") || nicNo.matches("\\d{12}"))) {
            request.setAttribute("message", "Invalid NIC number! Must be 9 digits + 1 letter (e.g., 123456789V) or 12 digits (e.g., 200012345678).");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Validate mobile number (must be exactly 10 digits)
        if (!mobileNo.matches("\\d{10}")) {
            request.setAttribute("message", "Mobile number must be exactly 10 digits!");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Validate password strength
        if (!userDAO.isValidPassword(password)) {
            request.setAttribute("message", "Password must be at least 8 characters long, contain 1 uppercase letter and 1 digit.");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Check if passwords match
        if (!password.equals(conpassword)) {
            request.setAttribute("message", "Passwords do not match!");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        // Hash password before storing
        String hashedPassword = userDAO.hashPassword(password);

        // Generate a unique customer number (e.g., MCC001, MCC002, etc.)
        String customerNo = userDAO.generateCustomerNo();

        // Create User object
        User user = new User(name, email, hashedPassword, nicNo, address, mobileNo, customerNo);

        // Register user in the database
        boolean isRegistered = userDAO.registerUser(user);

        if (isRegistered) {
            // Redirect to login page after successful registration
            response.setContentType("text/html");
            response.getWriter().println(
                "<script type='text/javascript'>"
                + "alert('Registration Successful! Redirecting to Login...');"
                + "setTimeout(function(){ window.location='login.jsp'; }, 2000);" // Redirect after 2 sec
                + "</script>"
            );
        } else {
            request.setAttribute("message", "Registration failed! Please check your database connection.");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
        }
    }
}
