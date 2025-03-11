package com.megacitycab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.megacitycab.dao.CustomerDAO;
import com.megacitycab.model.Customer;


@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String phoneNumber = request.getParameter("phoneNumber");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setNic(nic);
        customer.setTelephone(phoneNumber);

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.addCustomer(customer);

        response.sendRedirect("success.jsp");
	}

}
