<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="shortcut icon" href=<c:url value="images/favicon.ico"/> type="image/x-icon">
	<link rel="icon" href=<c:url value="/resource/images/favicon.png"/> type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href=<c:url value="/resource/css/workaround.css"/> type="text/css" media="screen">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	

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
      <li class="active"><a href="index">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signin">Log In</a></li>
      <li><a href="register">Sign Up </a></li>
	  <li id="test"></li>
    </ul>
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
			<div class="col-xs-12 col-sm-12 col-md-12">
					<p style="text-align:center;"><a href="register"><button type="button" class="btn btn-success">Join us now!</button></a>	</p>
			</div>		  
		</div>
		
		<div class="row" style="padding-top:20" >
		
			<div class="col-md-4">
				<div  class= "jumbotron" > 
					<p style="text-align:left;"><h1>Who we are?<small>  Find out here!</small></h1></p>
					
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
					<p>	Around the world, around the world  </p>
				</div>	
			</div>
			
			<div class="col-md-4">  
			<div  class= "jumbotron" > 
					<p style="text-align:center;"><h1>What we offer?<small></small></h1></p>
					
					<p>	Buy it, use it, break it, fix it,          </p>
					<p>	Trash it, change it, mail - upgrade it,    </p>
					<p>	Charge it, point it, zoom it, press it,    </p>
					<p>	Snap it, work it, quick - erase it,        </p>
					<p>	Write it, cut it, paste it, save it,       </p>
					<p>	Load it, check it, quick - rewrite it,     </p>
					<p>	Plug it, play it, burn it, rip it,         </p>
					<p>	Drag and drop it, zip - unzip it,          </p>
					<p>	Lock it, fill it, call it, find it,        </p>
					<p>	View it, code it, jam - unlock it,         </p>
					<p>	Surf it, scroll it, pause it, click it,    </p>
					<p>	Cross it, crack it, switch - update it,    </p>
					<p>	Name it, rate it, tune it, print it,       </p>
					<p>	Scan it, send it, fax - rename it,         </p>
					<p>	Touch it, bring it, pay it, watch it,      </p>
					<p>	Turn it, leave it, start - format it.      </p>
				</div>
			</div>
			
			<div class="col-md-4"  >   
				<div  class= "jumbotron" > 
					<p style="text-align:right;"><h1>Why join us?<small> no reason !</small></h1></p>
					<p>	Work it harder		</p>
					<p>	Make it better      </p>
					<p>	Do it faster        </p>
					<p>	Makes us stronger	</p>	
					<p>	More than ever      </p>
					<p>	Hour after          </p>
					<p>	Our work is         </p>
					<p>	Never over          </p>
					<p>	Mom's spaghetti     </p>
				</div>
			</div>
		</div>	 
    </div>
	
  </div>
 
 </div>


</body>
</html>