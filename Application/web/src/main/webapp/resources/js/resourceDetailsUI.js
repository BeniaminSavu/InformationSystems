function loadResourceDetails(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");	
	
	var urlParams = new URLSearchParams(window.location.search);
	var id = urlParams.get('id');
	
	var request = arthubAPI.getResourceDetails(id);
	request.done(function(data) {
		document.getElementById("title").innerHTML = data.name;
		document.getElementById("description").innerHTML = data.description;
		document.getElementById("price").innerHTML = "$"+data.price;
		document.getElementById("capacity").innerHTML = "Available seats " + data.capacity;
		
		request = arthubAPI.getBusyDates(data.name);
		request.done(function( response ) {
			console.log(response);
			eventsBusy = [];
			for ( var i in response){
				eventsBusy[ new Date(response[i].month + "/" + response[i].day + "/" + response[i].year)] = new Date(response[i].month + "/" + response[i].day + "/" + response[i].year);
			}
			console.log(eventsBusy);
			$('#date').datepicker({
				beforeShowDay : function(date){
					var highlight = eventsBusy[date];
					if(highlight){
						return [true, "event", "Tooltip text"];
					} else {
						return [true, '', ''];
					}
				}
			});
			
			
		})
		
		
	}).fail(function(jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'login.html';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
	
}