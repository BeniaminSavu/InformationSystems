function loadUserInformation(){
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
    var request = arthubAPI.getUserInformation();
	request.done(function( data ) {
		console.log(data);
		document.getElementById("firstName").value = data.firstName;
		document.getElementById("lastName").value = data.lastName;
		document.getElementById("username").value = data.username;
		document.getElementById("email").value = data.email;
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}

function saveChanges(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var elements = document.getElementById("update").elements;
    var user ={};
    for(var i = 0 ; i < elements.length; i++){
        var item = elements.item(i);
        user[item.name] = item.value;
    }
    user["role"] = "";
    console.log(user);
    
    var request = arthubAPI.saveChanges(user);
	request.done(function( data ) {
		var element = document.getElementById('message');
		 if (element.style.display === 'none') {
		        element.style.display = 'block';
		 }
		 loadUserInformation();
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}

function loadCreatedEvents(){
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);
	
	var request = arthubAPI.getCreatedEvents();
	request.done(function(data) {
		// Define our data object
		var events = {
			event : []
		};

		for ( var i in data) {
			var item = data[i];
			events.event.push({
				"no" : i,
				"name" : item.name,
				"date" : "Star date: " + item.date,
				"resource" : "Room name: " + item.resource
			});
		}
		var theCompiledHtml = theTemplate(events);
		$('#content-placeholder').html(theCompiledHtml);

		// Add the compiled html to the page

		// Pass our data to the template
	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});

	
}

function loadInvitedEvents(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template2").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);
	
	var request = arthubAPI.getInvitedEvents();
	request.done(function(data) {
		// Define our data object
		var events = {
			event : []
		};

		for ( var i in data) {
			var item = data[i];
			events.event.push({
				"no" : i,
				"name" : item.name,
				"date" : "Star date: " + item.date,
				"resource" : "Room name: " + item.resource
			});
		}
		var theCompiledHtml = theTemplate(events);
		$('#content-placeholder2').html(theCompiledHtml);

		// Add the compiled html to the page

		// Pass our data to the template
	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}