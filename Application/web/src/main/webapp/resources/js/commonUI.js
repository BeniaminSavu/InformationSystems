function loadUserFirstAndLastname(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
    
	console.log("test");
    var request = arthubAPI.getUserFirstAndLastname();
	request.done(function( data ) {
		console.log(data);
    	document.getElementById("userdata").innerHTML = data.firstName + " " + data.lastName;
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}