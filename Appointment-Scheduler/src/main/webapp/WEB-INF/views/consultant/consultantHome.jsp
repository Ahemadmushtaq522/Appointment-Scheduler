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
        <a href="<%= request.getContextPath() %>/consultant">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Dashboard</span>
        </a>
         <span class="tooltip">Dashboard</span>
      </li>
      <li>
       <a href="<%= request.getContextPath() %>/consultant/clients">
         <i class='bx bx-briefcase' ></i>
         <span class="links_name">Clients</span>
       </a>
       <span class="tooltip">Clients</span>
     </li>
     
     <li>
       <a href="<%= request.getContextPath() %>/consultant/appointments">
         <i class='bx bx-calendar'></i>
         <span class="links_name">Appointments</span>
       </a>
       <span class="tooltip">Appointments</span>
     </li>
    >
     
     <li class="profile">
         <div class="profile-details">
           <img src="images/profile.png" alt="profileImg">
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
        
      	<h2><div class="text">Dashboard</div></h2>
      <div class="column-1">
    
    	
    	<!-- consultant cards -->
    	<div class="cards-container">
    		<div class="card-1">
			  <div class="container">
			    <h4 style="text-align:center;color:white;"><b>Total Appointments</b></h4> 
			    <p style="font-size:30px;text-align:center;color:white;"><%= request.getAttribute("totalAppointments") %></p> 
			  </div>
			</div>
			
    	</div>
	 </div>
	  <div class="column-1">
    
    	
    	<!-- consultant cards -->
    	<div class="cards-container">
			<div class="card-2">
			  <div class="container">
			    <h4 style="text-align:center;color:white;"><b>Total Clients</b></h4> 
			    <p style="font-size:30px;text-align:center;color:white;"><%= request.getAttribute("totalClients") %></p> 
			  </div>
			</div>
    	</div>
	 </div>
	  <div class="column-1">
    
    	
    	<!-- consultant cards -->
    	<div class="cards-container">
			<div class="card-3">
			  <div class="container">
			    <h4 style="text-align:center;color:white;"><b>Total Consultants</b></h4> 
			    <p style="font-size:30px;text-align:center;color:white;"><%= request.getAttribute("totalConsultants") %></p> 
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