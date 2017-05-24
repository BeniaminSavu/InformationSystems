<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/>
	type="image/x-icon">
<link rel="icon" href=<c:url value="/resource/images/favicon.png"/>
	type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href=<c:url value="/resource/css/workaround.css"/> type="text/css"
	media="screen">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src=<c:url value="/resource/js/ArthubAPI.js"/>></script>
  	<script src=<c:url value="/resource/js/commonUI.js"/>></script>
  	<script src=<c:url value="/resource/js/newResourceUI.js"/>></script>

<title>ArtHub</title>
</head>

<body>

	<nav class="navbar navbar-default" style="margin-bottom: 0">
		<div class="container-fluid">
			<div class="navbar-header">
      <a href="index">
         <span class="logo"> </span> <img src=<c:url value="/resource/images/logo.png"/> alt="" width="80px" height="45px"/>
      </a>
    </div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="home">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Events <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="newEvent">Create new event</a></li>
						<li><a href="#">Edit Event</a></li>
						<li><a href="#">View Events</a></li>
					</ul></li>
				<li class="dropdown active"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Resources <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="newResource">Create new resource</a></li>
						<li><a href="#">Edit Event</a></li>
						<li><a href="#">View Events</a></li>
					</ul></li>
				<li><a href="index">Edit Profile</a></li>
			</ul>

			<p id="userdata" class="navbar-text navbar-right"
				style="padding-right: 50px"></p>

		</div>
	</nav>


	<div class="row">
		<div class="col-xs-12 col-sm-8 col-md-6 col-md-offset-1">
			<form id="newResource" role="form">
				<h2>New Resource</h2>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" name="name" id="name"
								class="form-control input-lg" placeholder="Resource Title"
								tabindex="1">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-3 col-md-3">
						<div class="form-group">
							<input type="text" name="capacity" id="capacity"
								class="form-control input-lg" placeholder="Capacity" tabindex="1">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-3 col-md-3">
						<div class="form-group">
							<input type="text" name="price" id="price"
								class="form-control input-lg" placeholder="Price" tabindex="1">
						</div>
					</div>
				</div>
				</form>
				<div class="row" style="padding-top: 20">
					<div class="col-xs-12 col-md-12">
						<input onclick="createResource()" type="submit" value="Create Resource"
							class="btn btn-primary btn-block btn-lg" / tabindex="7">
					</div>
				</div>
			
		</div>
	</div>
<p id="log"></p>

<script>
$(document).ready(function() {
	loadUserFirstAndLastname();
});  
 </script>

</body>

</html>