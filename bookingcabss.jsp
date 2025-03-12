<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="com.megacitycab.dao.CarDAO" %>
<%@ page import="com.megacitycab.model.Car" %>
<%@ page import="com.megacitycab.dao.DriverDAO" %>
<%@ page import="com.megacitycab.model.Driver" %>
<%
    CarDAO carDAO = new CarDAO();
    DriverDAO driverDAO = new DriverDAO();
    List<Car> cars = carDAO.getAllCars();
    List<Driver> drivers = driverDAO.getAllDrivers();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Book a Cab</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Book a Cab</h2>
        <form action="BookCabServlet" method="post">
            <div class="mb-3">
                <label class="form-label">Customer Name:</label>
                <input type="text" name="customerName" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contact Number:</label>
                <input type="text" name="customerContact" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Select Car:</label>
                <select name="carId" class="form-control" required>
                    <% for (Car car : cars) { %>
                         <option value="<%= car.getCarId() %>"><%= car.getBrand() %> - <%= car.getModel() %></option>
                    <% } %>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Select Driver:</label>
                <select name="driverId" class="form-control" required>
                    <% for (Driver driver : drivers) { %>
                        <option value="<%= driver.getDriverId() %>"><%= driver.getDriverName() %> - <%= driver.getDriverMobile() %></option>
                    <% } %>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Destination:</label>
                <input type="text" name="destination" class="form-control" required>
            </div>

            <!-- Added distance input field -->
            <div class="mb-3">
                <label class="form-label">Distance (in km):</label>
                <input type="number" name="distance" class="form-control" step="0.1" min="0" required>
            </div>

            <button type="submit" class="btn btn-primary">Book Now</button>
        </form>
    </div>
</body>
</html>
