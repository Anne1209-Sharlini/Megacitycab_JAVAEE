<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link rel="stylesheet" href="css/user_regi_style.css">
 <script>
        function validateForm() {
            var password = document.forms["registerForm"]["password"].value;
            var conpassword = document.forms["registerForm"]["conpassword"].value;
            var email = document.forms["registerForm"]["email"].value;

            // Password regex validation
            var regex = /^(?=.*[A-Z])(?=.*\d).{8,}$/;
            if (!regex.test(password)) {
                alert("Password must be at least 8 characters long, contain 1 uppercase letter and 1 digit.");
                return false;
            }

            // Confirm password check
            if (password !== conpassword) {
                alert("Passwords do not match!");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="wrapper">
    <h2>User Registration</h2>
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
        <p style="color:red;"><%= message %></p>
    <% } %>
    <form action="userregister" method="POST">
      <div class="input-box">
        <input type="text" placeholder="Enter your name" name="fname" required>
      </div>
      <div class="input-box">
        <input type="email" placeholder="Enter your email" name="email" required>
      </div>
      <div class="input-box">
        <input type="password" placeholder="Create password" name="password"  required>
      </div>
      <div class="input-box">
        <input type="password" placeholder="Confirm password" name="conpassword" required>
      </div>
    
      <div class="input-box button">
        <input type="Submit" value="Register Now">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="login.jsp">Login now</a></h3>
        
      </div>
      <br>
       <div class="text">
        <h3>GO <a href="index.jsp">Home</a></h3>
        
      </div>
    </form>
  </div>
</body>
</html>