package com.megacitycab.controller;


import com.megacitycab.dao.UserDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login1")
public class AuthenticationController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();

        // Check if the user credentials are valid
        boolean isAuthenticated = userDAO.authenticateUser(email, password);

        if (isAuthenticated) {
            // If authenticated, set session and redirect to a dashboard or homepage
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("dashboard.jsp"); // Replace with the appropriate page
        } else {
            // If authentication fails, show error message
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    
    }
}
