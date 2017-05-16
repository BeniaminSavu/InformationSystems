function createResource(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var elements = document.getElementById("newResource").elements;
    var resource ={};
    for(var i = 0 ; i < elements.length- 1 ; i++){
        var item = elements.item(i);
        resource[item.name] = item.value;
    }
    
    console.log(resource);
    var request = arthubAPI.createResource(resource);
    request.done(function( data ) {
    	document.getElementById("log").innerHTML = data.message;
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
;
	
	
}