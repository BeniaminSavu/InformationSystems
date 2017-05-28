function loadEvents(){
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);
	
	var request = arthubAPI.getComingEvents();
	request.done(function(data) {
		// Define our data object
		var events = {
			event : []
		};

		for ( var i in data) {
			var item = data[i];
			events.event.push({
				"name" : item.name,
				"startDate" : "Event starting at: " + item.date,
				"description" : "Description: " + item.description,
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