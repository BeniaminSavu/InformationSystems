
var resource;
var eventsBusy = [];
var picker;

$('#resource').keyup(function() {
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");

	resource = this.value;
	
	var request = arthubAPI.getBusyDates(resource);
	request.done(function( data ) {
		console.log(data);
		for ( var i in data){
			var date = new Date(data[i].year + "-" + data[i].month + "-" + data[i].day);
			eventsBusy[i] = date.toDateString();
		}
		console.log(eventsBusy);
		picker = new Pikaday({
		    field: document.getElementById('datePicker'),
		    format: 'D MMM YYYY',
		    firstDay: 1,
			minDate: new Date('2000-01-01'),
			maxDate: new Date('2020-12-31'),
			yearRange: [2000,2020],
			events: eventsBusy,
			numberOfMonths: 1
		});
		
	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			window.location = 'signin';

		} else {
			console.error('Houston, we have a problem...');
		}
	});

});


function getBusyDates(){
	
	picker = new Pikaday({
	    field: document.getElementById('datePicker'),
	    format: 'D MMM YYYY',
	    firstDay: 1,
		minDate: new Date('2000-01-01'),
		maxDate: new Date('2020-12-31'),
		yearRange: [2000,2020],
		events: eventsBusy,
		numberOfMonths: 1
	});
	
}

