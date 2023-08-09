<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    boolean visitedWelcomePage = (boolean) session.getAttribute("visitedWelcomePage");
    if (visitedWelcomePage==false) {
        response.sendRedirect(request.getContextPath() + "/");
        
    }

    session.setAttribute("visitedWelcomePage", false);
%>
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
    <h1 style="color: rgb(0, 128, 192);">
        <% 
            String userType = request.getParameter("userType"); 
            session.setAttribute("userType", userType);  
            out.println(userType); // This will display the userType value on the page
        %>
    </h1>

    <form action="<%= request.getContextPath() %>/login" method="POST">
        <br><br><br>
        <input type="text" name="email" placeholder="E-mail" required />
        <input type="password" name="password" placeholder="Password" required />
        <input type="submit" name="signup_submit" value="Log In" /><br><br>

        <%-- Check userType and display the link only if it's "job hunter" --%>
        <% if ("Job Hunter".equals(userType)) { %>
            <span class="subtext">Aren't you a member? <a href="<%= request.getContextPath() %>/register">Register Here</a></span>
        <% } %>
    </form>
</div>

<div class="right">
    <div>
        <figure>
            <img src="images/signin-image.jpg" alt="sing up image">
        </figure>
    </div>
</div>

</div>


 
 
</body>
</html>