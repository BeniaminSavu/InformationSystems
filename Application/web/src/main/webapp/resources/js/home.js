jQuery(document).ready(function($) {

	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/web/arthub/user'

	}).done(function (data, textStatus, jqXHR) {
		$('#userdata').html(data.message);

	}).fail(function (jqXHR, textStatus, errorThrown) {

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			var cookie = JSON.stringify({method: 'GET', url: 'index'});
			Cookies.set('arthub', cookie);
			window.location = 'home';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
});