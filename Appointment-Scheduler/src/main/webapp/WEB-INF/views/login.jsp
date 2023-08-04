<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/style-01.css">
</head>
<body>
<div id="login-box">
  <div class="left">
    <h1>Log In</h1>
    
    <form action="<%= request.getContextPath() %>/login" method="POST">
    <br><br><br>
    <input type="text" name="email" placeholder="E-mail" required />
    <input type="password" name="password" placeholder="Password" required />
    <input type="submit" name="signup_submit" value="Log In" /><br><br>
    <span class="subtext">Aren't you a member? <a href="<%= request.getContextPath() %>/register">Register Here</a></span>
</form>

    
  </div>
  
  <div class="right">
    <div >
		<figure>
			<img src="images/signin-image.jpg" alt="sing up image">
		</figure>
		
	</div>
  </div>
  
</div>
</body>
</html>