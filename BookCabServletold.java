package com.megacitycab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.megacitycab.dao.BookingDAO;
import com.megacitycab.model.Booking;



@WebServlet("/BookCabServlet")
public class BookCabServletold extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
        String customerContact = request.getParameter("customerContact");
        int carId = Integer.parseInt(request.getParameter("carId"));
        String curraddress = request.getParameter("currentadd");
        String destination = request.getParameter("destination");
        double distance = Double.parseDouble(request.getParameter("distance"));
        BookingDAO bookingDAO = new BookingDAO();

     // Get the carId and distance from the request
    
     // Calculate the total fare using the carId and distance
     double totalFare = bookingDAO.calculateFare( distance,carId);

     // Generate a reference number (optional)
     String referenceNo = bookingDAO.generateReferenceNo();

     // Create a Booking object
     Booking booking = new Booking(referenceNo, customerName, customerContact, carId, curraddress, destination, distance, totalFare, "Pending");

     // Insert the booking into the database
     boolean isInserted = bookingDAO.insertBooking(booking);

     if (isInserted) {
         // Redirect or show success message
//         response.sendRedirect("success.jsp");
         response.getWriter().println("<script>alert('Booking successful!'); window.location='BookCabs.jsp';</script>");
     } else {
         // Show error message
         //response.sendRedirect("error.jsp");
         response.getWriter().println("<script>alert('Booking Unsuccessful!'); window.location='BookCabs.jsp';</script>");

     }
	}}