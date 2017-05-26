<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/> type="image/x-icon">
	<link rel="icon" href=<c:url value="/resource/images/favicon.png"/> type="image/x-icon">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">
  
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script src=<c:url value="/resource/js/ArthubAPI.js"/>></script>
  	<script src=<c:url value="/resource/js/commonUI.js"/>></script>
  	<script src=<c:url value="/resource/js/editMemberUI.js"/>></script>
  
  

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
      <li><a href="home">Home</a></li>
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
						<li><a href="resources">View Resources</a></li>
					</ul>
		</li>
		<li class="active"><a href="manageMembers">Manage Members</a></li>
	   <li><a href="index">Edit Profile</a></li>
	</ul>
	
    <p id="userdata" class="navbar-text navbar-right" style="padding-right: 50px"></p>
    
  </div>
</nav>
<div class="container" align="left">
	<div class="content-placeholder">
		<form method="post" id="updateUser">
			<div style="padding-top: 30px;  padding-bottom: 20px;">
			<span class="glyphicon glyphicon-user"></span>
			<big><big>Editing user <span id="fullName">{{firstName}} {{lastName}}</span></big></big>
			</div>	
			<div class="form-group">
				<input type="username" name="username" id="username" class="form-control input-lg" placeholder="New Username"> *<small>  will replace the old username: <span id="user-username">{{username}}</span> </small>
			</div>
			<div class="form-group">
				<input type="password" name="password" id="password" class="form-control input-lg" placeholder="New Password"> *<small>  will replace the old password: <span id="user-password">{{password}}</span></small>
			</div>
			<div class="form-group">
				<input type="balance" name="balance" id="balance" class="form-control input-lg" placeholder="New balance"> *<small>  will replace the old balance: <span id="user-balance">{{balance}}</span> </small>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" value="" id="roleChange"><big>Change current role</big></label> 
				<big><big><span class="glyphicon glyphicon-warning-sign"></span></big></big>
				*<small>  will change the old role: <span id="role">{{role}}</span></small>			
			</div>
			</form>	
			<div style="padding-top: 20px;">	
				<button  onclick="saveChanges()" type="submit" class="btn btn-info" >Save Changes</button>
				<a href="manageMembers.html" type="button" class="button3 btn" role="button">Cancel</a>
			</div>
		
	</div>
</div>

<script>
$(document).ready(function() {
	loadUserFirstAndLastname();
	loadUserInformation();
});  
  </script>

</body>
</html>