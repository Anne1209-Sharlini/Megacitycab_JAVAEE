package com.megacitycab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);  // Don't create a new session if one doesn't exist
	        if (session != null) {
	            session.invalidate();  // Invalidate the session
	        }

	        // Expire the session cookie
	        Cookie cookie = new Cookie("JSESSIONID", "");
	        cookie.setMaxAge(0);  // Expire the cookie
	        cookie.setPath(request.getContextPath());
	        response.addCookie(cookie);

	        // Redirect to the login page
	        response.sendRedirect("login.jsp");
	}

	
}
