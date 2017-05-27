<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/> type="image/x-icon">
	<link rel="icon" href=<c:url value="/resource/images/favicon.png"/> type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">
	<link rel="stylesheet" href=<c:url value="/resource/css/bootstrap-multiselect.css"/> type="text/css" media="screen">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" />
	
	<style>
		.event a{
			background-color: #5FBA7D !important;
			color: #FFFFFF !important;
		}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script src=<c:url value="/resource/js/lib/bootstrap-multiselect.js"/>></script>
	<script src=<c:url value="/resource/js/ArthubAPI.js"/>></script>
  	<script src=<c:url value="/resource/js/commonUI.js"/>></script>
  	

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
	  <li class="dropdown active">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Events <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li class="active"><a href="newEvent">Create new event</a></li>
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
	   <li><a href="editProfile">Edit Profile</a></li>
	</ul>
	
    <p id="userdata" class="navbar-text navbar-right" style="padding-right: 50px"></p>
    
  </div>
</nav>


<div >

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-md-offset-1">
		<form role="form" id="newEvent">
			<h2>New Event</h2>
			<div class="row" >
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="name" id="name" class="form-control input-lg" placeholder="Event Title" tabindex="1">
					</div>
				</div>
			</div>
			<div class="row" >
				<div class="col-xs-12 col-sm-12 col-md-12">
					<div class="form-group">
						<textarea  class="form-control input-lg"  rows="8" cols="100" style="resize : none" name="description" id="description" placeholder="Enter your event description here"></textarea>	
					</div>
				</div>
			</div>
			
			<div class="row" >
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<label class="control-label" for="resource">Resource</label>
                        <input type="text" name="resource" id="resource" class="form-control input-lg" placeholder="Resource" tabindex="1">
					</div>
				</div>
			</div>
			
			<div class="row" >
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<label class="control-label" for="date">Duration</label>
                        <input type="text" name="duration" id="duration" class="form-control input-lg" placeholder="Duration" tabindex="1">
					</div>
				</div>
			</div>
			
			<div class="row" >
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<label class="control-label" for="date">Members</label>
                        			<select id="chkveg"  multiple="multiple">
									
									</select>
					</div>
				</div>
			</div>
		<div class="row">
				 <div class="col-xs-12 col-sm-4 col-md-4">
						<div class="form-group">
						<label class="control-label" for="date">Date</label>
                        <input onclick="getBusyDates()" type="text" name="date" id="datePicker" class="form-control input-lg" placeholder="Date" tabindex="1">
					</div>
				</div>
			</div>
			</form>
			<div class="row">
				 <div class="col-xs-12 col-sm-4 col-md-4">
						<div class="form-group">
						<label class="control-label" id="computed-price"></label>
					</div>
				</div>
			</div>
			<div class="row" >
				<div class="col-xs-11 col-sm-12 col-md-12">
					 By clicking <strong class="label label-primary">Create Event</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> regarding event creation set out by this site.
				</div>
			</div>
			
			
			<hr class="colorgraph">
			<div class="row" style="padding-top:20">
				<div class="col-xs-12 col-md-12"><input onclick="eventNew()" type="submit" value="Create Event" class="btn btn-primary btn-block btn-lg"/ tabindex="7"></div>
			</div>
	
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
				<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
			</div>
			<div class="modal-body">
				<p>You will basically sell your soul to us</p>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</div>

<script src=<c:url value="/resource/js/newEvent.js"/>></script>
  	
  	<script type="text/javascript">

  	$(document).ready(function() {
  		loadUsernames();
  		loadUserFirstAndLastname();
  	});  
  	

</script>

</body>

</html>
