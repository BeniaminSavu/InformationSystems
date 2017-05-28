<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/> type="image/x-icon">
	<link rel="icon" href=<c:url value="/resource/images/favicon.png"/> type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0/handlebars.js"></script>
  	<script src=<c:url value="/resource/js/ArthubAPI.js"/>></script>
  	<script src=<c:url value="/resource/js/commonUI.js"/>></script>
  	<script src=<c:url value="/resource/js/loggedUserUI.js"/>></script>

<title>
ArtHub
</title>
</head>

<body>

<nav class="navbar navbar-default" style="margin-bottom:0">
  <div class="container-fluid">
    <div class="navbar-header">
      <a href="index">
         <span class="logo"> </span> <img src=<c:url value="/resource/images/logo.png"/> alt="" width="80px" height="45px"/>
      </a>
    </div>
	<ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="home">Home</a></li>
	  <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Events <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="newEvent">Create new event</a></li>
            <li><a href="#">Edit Event</a></li>
            <li><a href="#">View Events</a></li>
          </ul>
       </li>
       <li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Resources <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newResource">Create new resource</a></li>
						<li><a href="res">View Resources</a></li>
					</ul>
		</li>
		<li><a href="manageMembers">Manage Members</a></li>
		<li><a href="reports">Reports</a></li>
	   <li><a href="editProfile">Edit Profile</a></li>
	</ul>
	
    <p id="userdata" class="navbar-text navbar-right" style="padding-right: 50px"></p>
    
  </div>
</nav>

<div class="bg-content">
    <div class="container-fluid" >
		<div class="row" >
			<div class="col-md -12">
					<div  class= "jumbotron" > 
						<p style="text-align:center;"><img src=<c:url value="/resource/images/home.jpg"/>  style="width:75%; height:70%"   ></p>
					</div>			
			</div>		  
		</div>
		
		<div class="row" >
    		<h3>Upcoming Events</h3>
    		<ul class="thumbnails" id="content-placeholder">
			<script id="address-template" type="text/x-handlebars-template">
				{{#each event}}
				<li class="span3">
				  <div class="thumbnail">
					<div class="caption">
					  <h2>{{name}}</h2>
					<p>
						{{resource}}
					</p>
					  <p> 
						{{description}} 
					  </p>

					  <p> 
						{{startDate}} 
					  </p>
					 
					</div>
				  </div>
				</li>
				{{/each}}
						</script>
					</ul>
    	</div>
    </div>
    
    
	
  </div>

<script>
$(document).ready(function() {
	loadUserFirstAndLastname();
	loadEvents();
});  
  </script>

</body>
</html>