
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
<link rel="stylesheet" href="css/user_regi_style.css">

</head>
<body>
<div class="wrapper">
    <h2>Customer Registration</h2>
  
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