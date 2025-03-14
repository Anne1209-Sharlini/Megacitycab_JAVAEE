<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Help - User Guide</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link your CSS file -->
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .container { max-width: 800px; margin: auto; }
        h2 { color: #2c3e50; }
        img { width: 100%; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .step { margin-bottom: 30px; }
        .download-btn {
            display: inline-block; background: #3498db; color: #fff; padding: 10px 15px;
            text-decoration: none; border-radius: 5px; font-weight: bold;
        }
        .download-btn:hover { background: #2980b9; }
    </style>
</head>
<body>

    <div class="container">
        <h1>How to Use the Cab Booking System</h1>
        
        <h2>🚀 1. Register a New Account</h2>
        <div class="step">
            <p>First Go to the <strong>Your Home Page</strong>, There is Book Now Option , Once you  and click You Can Redirect to  <strong>Login/Register</strong>If You are already User Please  Login Your Username and Password. Other Wise You Have to Register.</p>
            <img src="img/book1.PNG" alt="User Registration Screenshot">
                       
                   <p>Your  <strong> Register Page</strong></p>
                 <img src="img/sinuppage.PNG" alt="User Registration Screenshot">            
            
        </div>

        <h2>🔐 2. Login to Your Account</h2>
        <div class="step">
            <p>Enter your <strong>Email & Password</strong> on the Login Page and click <strong>Login</strong>.</p>
          
                 <img src="img/loginuser.PNG" alt="User Registration Screenshot"> 
        </div>

        <h2>🚖 3. Book a Cab</h2>
        <div class="step">
            <p>Select your pickup & drop location, choose a car, and click <strong>Book Now</strong>.</p>
            <img src="img/bookingcabs1.PNG" alt="Cab Booking Screenshot">
        </div>

        <h2>📥 Download Full Guide</h2>
        <p>If you need a detailed guide, download the **PDF version**.</p>
        <a href="GeneratePDFServlet" class="download-btn">📄 Download User Guide</a>
    </div>

</body>
</html>
