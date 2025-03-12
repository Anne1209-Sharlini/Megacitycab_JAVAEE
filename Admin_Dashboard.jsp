<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse"%>
<%@ page import="com.megacitycab.dao.CarDAO" %>
<%@ page import="com.megacitycab.dao.DriverDAO" %>
<%
// Prevent browser caching by setting headers
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setHeader("Expires", "0"); // Proxies

// Check session validity
if (session == null || session.getAttribute("username") == null) {
	response.sendRedirect("AdminLogin.jsp"); // Redirect to login if session is invalid
	return;
}

CarDAO carDAO = new CarDAO();

int totalCars = carDAO.getCarCount();
DriverDAO driverdao=new DriverDAO();
int totaldriver=driverdao.getDriversCount();

%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- FontAwesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<link rel="stylesheet" href="css/Admin_Dashboard.css">
</head>
<body>




	<div class="sidebar">
		<h5 class="text-white text-center">Mega City Cab</h5>
		<h5 class="text-white text-center">*** ----------- ***</h5>
		<a href="Admin_Dashboard.jsp"><i class="fas fa-home"></i>
			Dashboard </a> <a href="ManageCars.jsp"><i class="fas fa-car"></i>
			Manage Cars</a> <a href="ManageDrivers.jsp"><i class="fas fa-user"></i> Manage
			Drivers</a> <a href="#"><i class="fas fa-users"></i> Customers</a> <a
			href="#"><i class="fas fa-book"></i> Bookings</a> <a
			href="adminlogout"><i class="fas fa-sign-out-alt"></i> Logout</a>
	</div>
	<!-- Main Content -->
	<div class="content">
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<span class="navbar-brand">Admin Dashboard</span>

				<div class="d-flex align-items-center">

					<Span>Welcome, <%=session.getAttribute("username")%></Span>

				</div>
			</div>
		</nav>

		<!-- Dashboard Cards -->
		<div class="container mt-4">
			<div class="row">
				<div class="col-md-4">
					<div class="card dashboard-card text-center p-3">
						<i class="fas fa-users fa-3x text-primary"></i>
						<h4>100 Customers</h4>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card dashboard-card text-center p-3">
						<i class="fas fa-car fa-3x text-success"></i>
						<h4><%=totalCars%>
							Cars Available
						</h4>
						<a href="ManageCars.jsp">Check Cars details</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card dashboard-card text-center p-3">
						
						<i class="fas fa-user-tie fa-3x text-danger"></i>
						
						<h4><%=totaldriver%>
							Drivers Available
						</h4>
						<a href="ManageDrivers.jsp">Check Drivers Details</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- Footer -->
	<div class="footer">
		<p>Design By Anne Sharlini for Mega City Cab</p>
	</div>
	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

