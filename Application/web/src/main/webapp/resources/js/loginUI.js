jQuery(document).ready(function ($) {
	$('#login').submit(function (event) {
		event.preventDefault();

		var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
		console.log(data);
		$.ajax({
			data: data,
			timeout: 1000,
			type: 'POST',
			url: 'http://localhost:8080/web/login'

		}).done(function(data, textStatus, jqXHR) {
			window.location = 'home';
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Booh! Wrong credentials, try again!');
		});
	});
});

