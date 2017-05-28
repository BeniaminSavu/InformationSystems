function getUsers() {

	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	// Grab the template script
	var theTemplateScript = $("#address-template").html();

	// Compile the template
	var theTemplate = Handlebars.compile(theTemplateScript);

	var request = arthubAPI.getAllUsers();
	request.done(function(data) {
		// Define our data object
		var users = {
			user : []
		};

		for ( var i in data) {
			var item = data[i];
			users.user.push({
				"firstName" : item.firstName,
				"lastName" : item.lastName,
				"username" : item.username,
				"id" : item.id,
				"balance": item.balance,
				"role" : item.role
			});
		}
		var theCompiledHtml = theTemplate(users);
		$('.content-placeholder').html(theCompiledHtml);

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

function deleteUser(username){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var user = {};
	
	user["username"] = username;
	
	var request = arthubAPI.deleteUser(user);
	request.done(function(data) {
		document.getElementById("data").innerHTML = data.message;
	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
	
}
