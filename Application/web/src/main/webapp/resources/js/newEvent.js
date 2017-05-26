
var resource;
var eventsBusy = {};

$('#resource').keyup(function() {
	resource = this.value;

});

$('#duration').keyup(function() {
	var duration = this.value;
	
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var request = arthubAPI.getResource(resource);
	request.done(function( data ) {
		console.log(data);
		var computedPrice = duration * data.price;
		document.getElementById("computed-price").innerHTML = "Resource costs: " + data.price + "$<br> Total cost is: " + computedPrice +"$";
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});

});


$(function(){
	$('#datePicker').datepicker({
		dateFormat: 'dd-mm-yy',
		beforeShowDay : function(date){
			var highlight = eventsBusy[date];
			if(highlight){
				return [true, "event", "Tooltip text"];
			} else {
				return [true, '', ''];
			}
		}
	});
});

function getBusyDates(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");

	var request = arthubAPI.getBusyDates(resource);
	request.done(function( data ) {
		console.log(data);
		eventsBusy = [];
		for ( var i in data){
			eventsBusy[ new Date(data[i].month + "/" + data[i].day + "/" + data[i].year)] = new Date(data[i].month + "/" + data[i].day + "/" + data[i].year);
		}
		console.log(eventsBusy);
		
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
	
}



function loadUsernames(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var request = arthubAPI.getUsernames();
	request.done(function( data ) {
		console.log(data);
		
		
		for (var field in data) {
            var html = '<option value = "'+ data[field].username +'">' + data[field].username + '</option>';
            $('#chkveg').append(html);
        }
		
		$('#chkveg').multiselect({

	        includeSelectAllOption: true
	    });
       
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
}

function eventNew(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
	
	var elements = document.getElementById("newEvent").elements;
    var event ={};
    for(var i = 0 ; i < elements.length; i++){
        var item = elements.item(i);
        event[item.name] = item.value;
    }
    event["participants"] = $('#chkveg').val();
    
    console.log(event);
    
    var request = arthubAPI.newEvent(event);
}
