<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Here</title>
<link rel="stylesheet" href="css/loginform.css" />
<script>
    function validateForm() {
        var username = document.forms["adminLoginForm"]["username"].value;
        var password = document.forms["adminLoginForm"]["password"].value;
        var errorDiv = document.getElementById("error-message");

        if (username.trim() === "" || password.trim() === "") {
            errorDiv.innerHTML = "⚠ Please enter both username and password.";
            errorDiv.style.color = "red";
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>
</head>
<body>
<div class="container" id="container">
	
	<div class="form-container sign-in-container">
		<form name="adminLoginForm" action="adminlogin" method="POST" onsubmit="return validateForm()">
		    <h1>Sign in</h1>

		    <input type="text" placeholder="Username" name="username" />
		    <input type="password" placeholder="Password" name="password" />
   
		    <button>Admin Login</button><br><br>
		    
		    <!-- Client-Side Error Message -->
		    <div id="error-message"></div>

		    <!-- Server-Side Error Message -->
    		<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    		<% if (errorMessage != null) { %>
        		<h3 style="color: orangered;"><%= errorMessage %></h3>
    		<% } %>
		</form>
	</div>

	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				<img src="img/m.png" width="450px">
				<h2>Mega City Cab <a href="index.jsp">GO Home</a></h2>
			</div>
		</div>
	</div>
</div>

<footer>
	<p>Created with <i class="fa fa-heart"></i> by <a target="_blank" href="#">Anne Sharlini</a></p>
</footer>
</body>
</html>
