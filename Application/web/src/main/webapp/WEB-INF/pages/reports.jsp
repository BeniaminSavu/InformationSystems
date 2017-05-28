<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/> type="image/x-icon">
	<link rel="icon" href=<c:url value="/resource/images/favicon.png"/> type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0/handlebars.js"></script>	
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  	<script src=<c:url value="/resource/js/ArthubAPI.js"/>></script>
  	<script src=<c:url value="/resource/js/commonUI.js"/>></script>
	<script src=<c:url value="/resource/js/reportsUI.js"/>></script>
  

 
 <style>
  .event a{
   background-color: #FF0000 !important;
   color: #FFFFFF !important;
  }
 </style>

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
						<li><a href="res">View Resources</a></li>
					</ul>
		</li>
		<li><a href="manageMembers">Manage Members</a></li>
		<li class="active"><a href="reports">Reports</a></li>
	   <li><a href="editProfile">Edit Profile</a></li>
	</ul>
	
    <p id="userdata" class="navbar-text navbar-right" style="padding-right: 50px"></p>
    
  </div>
</nav>

<div class="container" align="left">

<!--This is our template. -->
<!--Data will be inserted in its according place, replacing the brackets.-->


<!--Your new content will be displayed in here-->
<h1 class="page-header">Income Report</h1>
<button type="button" class="button1 button2 btn btn-primary" onclick="showIncomeReport()">See Income Report</button>
<div id="incomeDiv" style="display: none;">
		<div id="content-placeholder"></div>
		<script id="address-template" type="text/x-handlebars-template">
			<div class="bs-example" data-example-id="simple-table"> 
				<table class="table"> 
						<thead>
							<tr> 
								<th>#</th> 
								<th>First Name</th> 
								<th>Last Name</th> 
								<th>Username</th> 
								<th>Due Ammount</th> 
							</tr> 
						</thead> 
						<tbody> 
							{{#each user}}
								<tr> 
									<th scope="row">{{no}}</th> 
									<td>{{firstName}}</td>
									<td>{{lastName}}</td> 
									<td>{{username}}</td>
									<td>{{dueAmmount}}</td> 
								</tr> 
							{{/each}}
						</tbody> 
				</table> 
			</div>
		</script>
</div>

<h1 class="page-header">Resource availability report</h1>
<button type="button" class="button1 button2 btn btn-primary" onclick="showResourceAvailabilityReport()">See resource availability report</button>
<div id="availabilityDiv" style="display: none;">
	<div id="content-placeholder2"></div>
	<script id="address-template2" type="text/x-handlebars-template">
	<div class="bs-example" data-example-id="simple-table"> 
		<table class="table"> 
				<thead>
					<tr> 
						<th>#</th> 
						<th>Room Name</th> 
						<th>Availability</th> 
					</tr> 
				</thead> 
				<tbody> 
				
				{{#each resource}}
					<tr> 
						<th scope="row">{{no}}</th> 
						<td id={{no}}>{{roomName}}</td>
						<td><a href="#" data-toggle="modal" data-target="#t_and_c_m" onclick="test({{no}})">Check</a></td>
					</tr> 
				{{/each}}
				
				</tbody> 
		</table> 
	</div>
	</script>
	
</div>

<h1 class="page-header">Profit report</h1>
<button type="button" class="button1 button2 btn btn-primary" onclick="showProfitReports()">See profit report</button>
<div id="profitDiv" style="display: none;">
	<div id="content-placeholder3"></div>
	<script id="address-template3" type="text/x-handlebars-template">
	<div class="bs-example" data-example-id="simple-table"> 
		<table class="table"> 
			<caption>Optional table caption.</caption>
				<thead>
					<tr> 
						<th>#</th> 
						<th>Income</th> 
						<th>Costs</th> 
						<th>Total earned</th> 
					</tr> 
				</thead> 
				<tbody> 
				
				{{#each gibberish}}
					<tr> 
						<th scope="row">{{no}}</th> 
						<td>{{Income}}</td>
						<td>{{Costs}}</td> 
						<td>{{TotalEarned}}</td> 
					</tr> 
				{{/each}}
				
				</tbody> 
		</table> 
	</div>
	</script>
</div>


<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
				<h4 class="modal-title" id="myModalLabel"  style="padding-left: 360px;" >Availability</h4>
			</div>
			<div class="container " >
				<div  id="date" style="padding-top: 30px;  padding-bottom: 30px;  padding-left: 280px;" ></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
			</div>
			</div>
	</div>
</div>


</div>
	
<script>

$(document).ready(function() {
	loadUserFirstAndLastname();
	loadIncomeReport();
	loadResourceAvailabilityReport();
});  


function test(no)
{	 
	$("#date").datepicker( "destroy" );
	var x= document.getElementById(no).innerHTML;
	document.getElementById('myModalLabel').innerHTML=x + ' availability';
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	request = arthubAPI.getBusyDates(x);
	request.done(function( response ) {
		console.log(response);
		eventsBusy = [];
		for ( var i in response){
			eventsBusy[ new Date(response[i].month + "/" + response[i].day + "/" + response[i].year)] = new Date(response[i].month + "/" + response[i].day + "/" + response[i].year);
		}
		console.log(eventsBusy);
		$('#date').datepicker({
			beforeShowDay : function(date){
				var highlight = eventsBusy[date];
				if(highlight){
					return [true, "event", "Tooltip text"];
				} else {
					return [true, '', ''];
				}
			}
		});
		
		
	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'login.html';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}



function showIncomeReport() {
    var x = document.getElementById('incomeDiv');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function showResourceAvailabilityReport() {
    var x = document.getElementById('availabilityDiv');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }	
}
function showProfitReports() {
    var x = document.getElementById('profitDiv');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}
</script>


</body>
</html>