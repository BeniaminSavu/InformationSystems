<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="shortcut icon" href=<c:url value="resource/images/favicon.ico"/> type="image/x-icon">
<link rel="icon" href=<c:url value="/resource/images/favicon.ico"/> type="image/x-icon">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src=<c:url value="/resource/js/lib/jquery.cookie.js"/>></script>
	<script src=<c:url value="/resource/js/loginUI.js"/>></script>
  <link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">  

<title>
ArtHub
</title>
</head>

<body>

<nav class="navbar navbar-default" style="margin-bottom:0">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index">ArtHub</a>
    </div>
	<ul class="nav navbar-nav navbar-left">
      <li><a href="index">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="signin">Log In</a></li>
      <li><a href="register">Sign Up </a></li>
    </ul>
  </div>
</nav>

<div class="container">
<!--action = "http://localhost:8080/web/login"-->
<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form method = "post" id="login" >
			<h2>Please Log In</h2>
			<hr class="colorgraph">
			<div class="form-group">
				<input type="text" name="username" id="username" class="form-control input-lg" placeholder="Username">
			</div>
			<div class="form-group">
				<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
			</div>
		
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<input type="submit" class="btn btn-lg btn-success btn-block" value="Log In">
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<a href="register" class="btn btn-lg btn-primary btn-block">Register</a>
				</div>
			</div>
		</form>
		
	</div>
</div>

</div>


</body>
</html>