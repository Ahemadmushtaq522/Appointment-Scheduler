<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="css/style-01.css">
</head>
<body>
<div id="login-box">
  <div class="left">
    <h1>Sign up</h1>
    
    <form action="<%= request.getContextPath() %>/register" method="POST">
    <input type="text" name="username" placeholder="Username" required />
    <input type="text" name="email" placeholder="E-mail" required />
    <input type="password" name="password" placeholder="Password" required />
    <input type="password" name="password2" placeholder="Retype password" required />
    <input type="text" name="mobile" placeholder="Mobile Number" required />
    <input type="submit" name="signup_submit" value="Sign up" />
</form>

  </div>
  
  <div class="right">
    <div >
		<figure>
			<img src="images/signup-image.jpg" alt="sing up image">
		</figure>
		
   <span class="subtext">Already a member? <a href="<%= request.getContextPath() %>/login">Login Here</a></span>
	</div>
  </div>
  
</div>
</body>
</html>