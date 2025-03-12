
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
<link rel="stylesheet" href="css/user_regi_style.css">
<script>
    function validateForm() {
        var password = document.forms["registerForm"]["password"].value;
        var conpassword = document.forms["registerForm"]["conpassword"].value;
        var email = document.forms["registerForm"]["email"].value;
        var nic = document.forms["registerForm"]["nic_no"].value;
        
        var regex = /^(?=.*[A-Z])(?=.*\d).{8,}$/;
        if (!regex.test(password)) {
            alert("Password must be at least 8 characters long, contain 1 uppercase letter and 1 digit.");
            return false;
        }
        if (password !== conpassword) {
            alert("Passwords do not match!");
            return false;
        }
        if (nic.length !== 10 && nic.length !== 12) {
            alert("NIC must be either 10 or 12 characters long.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
<div class="wrapper">
    <h2>Customer Registration</h2>
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
        <p style="color:red;"><%= message %></p>
    <% } %>
    <form action="UserRegisterServlet" method="POST" onsubmit="return validateForm()">
      <div class="input-box">
        <input type="text" placeholder="Enter your name" name="fname" required>
      </div>
      <div class="input-box">
        <input type="email" placeholder="Enter your email" name="email" required>
      </div>
      <div class="input-box">
        <input type="text" placeholder="Enter your NIC No" name="nic_no" required>
      </div>
      <div class="input-box">
        <input type="text" placeholder="Enter your Mobile no" name="mobile_no" required>
      </div>
      <div class="input-box">
        <input type="text" placeholder="Enter your address" name="address" required>
      </div>
      <div class="input-box">
        <input type="password" placeholder="Create password" name="password" required>
      </div>
      <div class="input-box">
        <input type="password" placeholder="Confirm password" name="conpassword" required>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Register Now">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="login.jsp">Login now</a></h3>
         <h3>Go Home <a href="index.jsp">Click Here</a></h3>
      </div>
    </form>
</div>
</body>
</html>