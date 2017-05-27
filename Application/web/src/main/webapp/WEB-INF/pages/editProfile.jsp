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
  	<script src=<c:url value="/resource/js/editProfileUI.js"/>></script>

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
      <li ><a href="home">Home</a></li>
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
	   <li class="active"><a href="editProfile">Edit Profile</a></li>
	</ul>
	
    <p id="userdata" class="navbar-text navbar-right" style="padding-right: 50px"></p>
    
  </div>
</nav>

<div class="bg-content">
  
    <div class="container" style="padding-top: 1px;">
  <h1 class="page-header">Edit Profile</h1>
  <div class="row">
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <div id="message" class="alert alert-info alert-dismissable" style="display:none;">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        Your information has been <strong>updated</strong>.
      </div>
      <h2>Personal info</h2>
      <form class="form-horizontal" role="form" id="update">
        <div class="form-group">
          <label class="col-lg-3 control-label">First name:</label>
          <div class="col-lg-8">
            <input name="firstName" id="firstName" class="form-control" value="[CURRENT FIRST NAME]" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Last name:</label>
          <div class="col-lg-8">
            <input name="lastName" id="lastName" class="form-control" value="[CURRENT LAST NAME]" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input name="email" id="email" class="form-control" value="[CURRENT EMAIL]" type="text">
          </div>
        </div>
       
        <div class="form-group">
          <label class="col-md-3 control-label">Username:</label>
          <div class="col-md-8">
            <input name="username" id="username" class="form-control" value="[CURRENT USERNAME]" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password:</label>
          <div class="col-md-8">
            <input name="password" id="password" class="form-control" value="[cevaceva]" type="password">
          </div>
        </div>
        </form>
        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8">
            <input onclick="saveChanges()" class="btn btn-primary" value="Save Changes" type="button">
            <span></span>
            <input class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>
      
	  <h1 class="page-header">Created events</h1>
	  <div id="content-placeholder"></div>
	  <script id="address-template" type="text/x-handlebars-template">
		<div class="bs-example" data-example-id="simple-table"> 
			<table class="table"> 
				
					<thead>
						<tr> 
							<th>#</th>
							<th>Event Name</th> 
							<th>Event location</th> 
							<th>Event start date</th> 
						</tr> 
					</thead> 
					<tbody> 
					
					{{#each event}}
						<tr> 
							<td>{{no}}</td>
							<td>{{name}}</td>
							<td>{{resource}}</td> 
							<td>{{date}}</td> 
						</tr> 
					{{/each}}
					
					</tbody> 
			</table> 
		</div>
	</script>
	  
	  <h1 class="page-header">Current invitations</h1>
	  <div id="content-placeholder2"></div>
	  <script id="address-template2" type="text/x-handlebars-template">
		<div class="bs-example" data-example-id="simple-table"> 
			<table class="table"> 
				
					<thead>
						<tr> 
							<th>#</th> 
							<th>Event Name</th> 
							<th>Event location</th> 
							<th>Event start date</th> 
						</tr> 
					</thead> 
					<tbody> 
					
					{{#each event}}
						<tr> 
							<th scope="row">{{no}}</th> 
							<td>{{name}}</td>
							<td>{{resource}}</td> 
							<td>{{date}}</td> 
						</tr> 
					{{/each}}
					
					</tbody> 
			</table> 
		</div>
	</script>
	  
    </div>
  </div>
</div>
	
</div>
<script>
$(document).ready(function() {
	loadUserFirstAndLastname();
	loadUserInformation();
	loadCreatedEvents();
	loadInvitedEvents();
	});
</script>

</body>
</html>