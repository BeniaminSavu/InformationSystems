function loadUserInformation(){
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	var urlParams = new URLSearchParams(window.location.search);
	var id = urlParams.get('id');
	
    var request = arthubAPI.getUserInformation(id);
	request.done(function( data ) {
		console.log(data);
		document.getElementById("fullName").innerHTML = data.firstName + " " + data.lastName;
		document.getElementById("user-username").innerHTML = data.username;
		document.getElementById("user-password").innerHTML = data.password;
		document.getElementById("user-balance").innerHTML = "$"+data.balance;
		document.getElementById("role").innerHTML = data.role;
		
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
	var urlParams = new URLSearchParams(window.location.search);
	var id = urlParams.get('id');
	
	var elements = document.getElementById("updateUser").elements;
    var user ={};
    for(var i = 0 ; i < elements.length; i++){
        var item = elements.item(i);
        user[item.name] = item.value;
    }
    user["role"] = document.getElementById("roleChange").checked;
    console.log(user);
    
    var request = arthubAPI.saveChanges(id, user);
	request.done(function( data ) {
		window.location = "manageMembers";
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}