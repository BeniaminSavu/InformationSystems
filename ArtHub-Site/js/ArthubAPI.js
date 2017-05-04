function ArthubAPI() {

    if (typeof ArthubAPI.instance === 'object') {
        return ArthubAPI.instance;
    }

    var baseURL = "localhost";
	
    var doAsyncGet = function (partialUrl) {
        var fullUrl = baseURL + partialUrl;
        return $.ajax({
            url: fullUrl,
            dataType: "json"
        });
    };

    var doAsyncPost = function (partialURL, jsonDataToPost) {
        var fullUrl = baseURL + partialURL;
        return $.ajax({
            url: fullUrl,
            type: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            data: JSON.stringify(jsonDataToPost),
            dataType: "json"
        });
    };
	
	this.setBaseURL = function (strBaseURL) {
        baseURL = strBaseURL;
    };
	
	this.registerUser = function(user){
		var postURL = "/web/signup";
        return doAsyncPost(postURL, user);
	};

	ArthubAPI.instance = this;
}