package com.megacitycab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;

/**
 * Servlet implementation class GeneratePDFServlet
 */
@WebServlet("/GeneratePDFServlet")
public class GeneratePDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GeneratePDFServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=User_Guide.pdf");

        try (OutputStream out = response.getOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out); // ✅ Fixed PdfWriter issue
            document.open();

            // Title
            Paragraph title = new Paragraph("User Guide - Cab Booking System");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // Section 1: Registration
            document.add(new Paragraph("\n1. Register a New Account"));
            addImage(document, request.getServletContext().getRealPath("/img/sinuppage.PNG"));

            // Section 2: Login
            document.add(new Paragraph("\n2. Login to Your Account"));
            addImage(document, request.getServletContext().getRealPath("/img/loginuser.PNG"));

            // Section 3: Booking
            document.add(new Paragraph("\n3. Book a Cab"));
            addImage(document, request.getServletContext().getRealPath("/img/bookingcabs1.PNG"));

            document.add(new Paragraph("\nThank you for using our Cab Booking System!"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addImage(Document document, String imagePath) {
        try {
            Image img = Image.getInstance(imagePath);
            img.scaleToFit(200, 200);
            document.add(img);
        } catch (Exception e) {
            try {
                document.add(new Paragraph("Image not available: " + imagePath));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
