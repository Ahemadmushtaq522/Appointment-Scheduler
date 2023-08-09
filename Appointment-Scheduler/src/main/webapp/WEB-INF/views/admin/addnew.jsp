<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>The Job</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-02.css?version=1">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <style>
  form {
    width: 300px;
    margin:30px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #F0F8FF;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  input[type="text"],
  input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 3px;
  }

  input[type="submit"] {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 3px;
    background-color: #007BFF;
    color: #fff;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #0056b3;
  }

  input::placeholder {
    color: #aaa;
  }
</style>
     
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bx-briefcase icon'></i>
        <div class="logo_name">The Job</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
     <!--   <li>
          <i class='bx bx-search' ></i>
         <input type="text" placeholder="Search...">
         <span class="tooltip">Search</span>
      </li> -->
      <li>
        <a href="<%= request.getContextPath() %>/admin">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Dashboard</span>
        </a>
         <span class="tooltip">Dashboard</span>
      </li>
      <li>
       <a href="<%= request.getContextPath() %>/admin/clients">
         <i class='bx bx-briefcase' ></i>
         <span class="links_name">Clients</span>
       </a>
       <span class="tooltip">Clients</span>
     </li>
     
     <li>
       <a href="<%= request.getContextPath() %>/admin/consultants">
		<i class='bx bx-bulb' ></i>
         <span class="links_name">Consultants</span>
       </a>
       <span class="tooltip">Consultants</span>
     </li>
     <li>
       <a href="<%= request.getContextPath() %>/admin/appointments">
         <i class='bx bx-calendar'></i>
         <span class="links_name">Appointments</span>
       </a>
       <span class="tooltip">Appointments</span>
     </li>
      <li>
       <a href="<%= request.getContextPath() %>/admin/reports">
         <i class='bx bxs-report'></i>
         <span class="links_name">Reports</span>
       </a>
       <span class="tooltip">Reports</span>
     </li>
     
     <li class="profile">
         <div class="profile-details">
           <img src="${pageContext.request.contextPath}/images/profile.png" alt="profileImg">
           <div class="name_job">
             <div class="name"><%= session.getAttribute("username") %></div>
             <div class="job">Web designer</div>
           </div>
         </div>
         <a href="<%= request.getContextPath() %>/login"><i class='bx bx-log-out' id="log_out" ></i></a>
     </li>
    </ul>
  </div>
  <section class="home-section">
  
   <div class="column-3">
			<div class="right-column">
			  <div class="container">
			    <div class="table-container">
			      <p style="color:red;font-size:12;"><%= request.getAttribute("errorMessage") %></p>
			    <form action="<%= request.getContextPath() %>/consultant/register" method="POST">
				    <input type="text" name="username" placeholder="Username" required />
				    <input type="text" name="email" placeholder="E-mail" required />
				    <input type="text" name="country" placeholder="Country" required />
				    <input type="password" name="password" placeholder="Password" required />
				    <input type="password" name="password2" placeholder="Retype password" required />
				    <input type="text" name="mobile" placeholder="Mobile Number" required />
				    <input type="submit" name="signup_submit" value="Sign up" />
				</form>
			    </div>
			  </div>
			</div>
		</div>
       
  </section>
  <script>
  let sidebar = document.querySelector(".sidebar");
  let closeBtn = document.querySelector("#btn");
  let searchBtn = document.querySelector(".bx-search");

  closeBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("open");
    menuBtnChange();//calling the function(optional)
  });

  searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
    sidebar.classList.toggle("open");
    menuBtnChange(); //calling the function(optional)
  });

  // following are the code to change sidebar button(optional)
  function menuBtnChange() {
   if(sidebar.classList.contains("open")){
     closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
   }else {
     closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
   }
  }
  </script>
</body>
</html>