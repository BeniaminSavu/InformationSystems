function loadIncomeReport() {

	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);

	var request = arthubAPI.getIncomeReport();
	request.done(function(data) {
		// Define our data object
		console.log(data);
		var users = {
			user : []
		};

		for ( var i in data) {
			var item = data[i];
			users.user.push({
				"no" : i + 1,
				"firstName" : item.firstName,
				"lastName" : item.lastName,
				"username" : item.username,
				"dueAmmount" : item.dueAmount
			});
		}
		var theCompiledHtml = theTemplate(users);
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

function loadResourceAvailabilityReport() {
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template2").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);

	var request = arthubAPI.getAllResources();
	request.done(function(data) {
		var resources = {
			resource : []
		};

		for ( var i in data) {
			var item = data[i];
			resources.resource.push({
				"no" : i,
				"roomName" : item.name
			});
		}

		var theCompiledHtml = theTemplate(resources);
		$('#content-placeholder2').html(theCompiledHtml);

	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'login.html';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}