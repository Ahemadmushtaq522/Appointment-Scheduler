<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>The Job</title>
    <link rel="stylesheet" href="css/style-02.css?version=1">
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
        <a href="#">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Dashboard</span>
        </a>
         <span class="tooltip">Dashboard</span>
      </li>
      <li>
       <a href="#">
         <i class='bx bx-briefcase' ></i>
         <span class="links_name">Services</span>
       </a>
       <span class="tooltip">Services</span>
     </li>
     
     <li>
       <a href="#">
		<i class='bx bx-bulb' ></i>
         <span class="links_name">Consultants</span>
       </a>
       <span class="tooltip">Consultants</span>
     </li>
     <li>
       <a href="#">
         <i class='bx bx-calendar'></i>
         <span class="links_name">Appointments</span>
       </a>
       <span class="tooltip">Appointments</span>
     </li>
      <li>
       <a href="#">
         <i class='bx bx-user' ></i>
         <span class="links_name">Profile</span>
       </a>
       <span class="tooltip">Profile</span>
     </li>
     
     <li class="profile">
         <div class="profile-details">
           <img src="images/profile.png" alt="profileImg">
           <div class="name_job">
             <div class="name"><%= session.getAttribute("username") %></div>
             <div class="job">Web designer</div>
           </div>
         </div>
         <i class='bx bx-log-out' id="log_out" ></i>
     </li>
    </ul>
  </div>
  <section class="home-section">
      
      <!--  Left side of the dashboard -->
      	<h2><div class="text">Dashboard</div></h2>
      <div class="column-1">
    
    	
    	<!-- consultant cards -->
    	<div class="cards-container">
    		<div class="card">
			  <div class="container">
			    <h4><b>John Doe</b></h4> 
			    <p>Architect & Engineer</p> 
			  </div>
			</div>
			<br>
			<div class="card">
			  <div class="container">
			    <h4><b>Jakson Peter</b></h4> 
			    <p>Computer Engineering</p> 
			  </div>
			</div>
    	</div>
			
	 </div>

	<!-- Right side of the dashboard -->
  <div class="column-2">
			<div class="right-column">
			  <div class="container">
			    <h4><b>John Doe</b></h4> 
			    <p>Architect & Engineer</p> 
			  </div>
			</div>  </div>
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