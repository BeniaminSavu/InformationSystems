function loadResources(){
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);
	
	var request = arthubAPI.getAllResources();
	request.done(function(data) {
		// Define our data object
		var resources = {
			resource : []
		};

		for ( var i in data) {
			var item = data[i];
			resources.resource.push({
				"name" : item.name,
				"capacity" :"Available seats " + item.capacity,
				"price" : "$" + item.price,
				"id" : item.id
			});
		}
		var theCompiledHtml = theTemplate(resources);
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