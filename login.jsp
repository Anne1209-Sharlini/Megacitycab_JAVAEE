<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
  <link rel="stylesheet" href="css/loginform.css" />

</head>
<body>

<div class="container" id="container">
	
	<div class="form-container sign-in-container">
		<form action="login1" method="POST">
    <h1>Sign in</h1>
    <input type="email" placeholder="Email" name="email" required />
    <input type="password" placeholder="Password" name="password" required/>
    <a href="#">Forgot your password?</a>
    <button>Sign In</button>
</form>
		
	</div>
	<div class="overlay-container">
		<div class="overlay">
			
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				
				Don't Have Account<a href="userRegister.jsp"> Sign Up Here</a>
		         ---------------------------
				
				<a href="index.jsp"> GO Home</a>
				---------------------------
			</div>
			<div>
		
			</div>
		</div>
	</div>
</div>

<footer>
	<p>
		Created with <i class="fa fa-heart"></i> by
		<a target="_blank" href="#">Anne Sharlini</a>
	
	</p>
</footer>
</body>
</html>