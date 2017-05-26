function ArthubAPI() {

    if (typeof ArthubAPI.instance === 'object') {
        return ArthubAPI.instance;
    }

    var baseURL = "localhost";
	
    var doAsyncGet = function (partialUrl) {
        var fullUrl = baseURL + partialUrl;
        return $.ajax({
            url: fullUrl,
            type:"GET",
            headers: {
                "Content-Type":"application/json"
            },
            dataType: "json"
        });
    };

    var doAsyncDelete = function (partialURL)
    {
        var fullUrl = baseURL + partialURL;
        return $.ajax({
            url: fullUrl,
            type: "DELETE",
            headers: {
            	"Content-Type":"application/json"            
            },            
            dataType: "json"
        });
    }
    
    var doAsyncPost = function (partialURL, jsonDataToPost) {
        var fullUrl = baseURL + partialURL;
        console.log(jsonDataToPost);
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
	
	this.loginUser = function(user){
		var postURL = "/web/login";
        return doAsyncPost(postURL, user);
	};
	
	this.getUserFirstAndLastname = function(){
		var apiURL = "/web/arthub/user/fullname";
		return doAsyncGet(apiURL);
	};

	this.createResource = function(resource){
		var postURL = "/web/arthub/resource/add";
		return doAsyncPost(postURL, resource);
	};
	
	this.getAllUsers = function(){
		var apiURL = "/web/arthub/user/all";
		return doAsyncGet(apiURL);
	};
	
	this.deleteUser = function(username){
		var postURL = "/web/arthub/user/delete";
		return doAsyncPost(postURL, username);
	};
	
	this.getBusyDates = function(resource){
		var apiURL = "/web/arthub/resource/available/" + resource;
		return doAsyncGet(apiURL);
	};
	
	this.getUsernames = function(){
		var apiURL = "/web/arthub/user/all/username";
		return doAsyncGet(apiURL);
	};
	
	this.newEvent = function(event){
		var postURL = "/web/arthub/event/add";
		return doAsyncPost(postURL, event);
	};
	
	this.getUserInformation = function(id){
		var apiURL = "/web/arthub/user/info/" + id;
		return doAsyncGet(apiURL);
	};
	
	this.saveChanges = function(id, user){
		var postURL = "/web/arthub/user/update/" + id;
		return doAsyncPost(postURL, user);
	};
	
	this.getAllResources = function(){
		var apiURL = "/web/arthub/resource/all";
		return doAsyncGet(apiURL);
	};
	
	this.getResourceDetails = function(id){
		var apiURL = "/web/arthub/resource/" + id;
		return doAsyncGet(apiURL);
	};
	
	this.getComingEvents = function(){
		var apiURL = "/web/arthub/event/coming";
		return doAsyncGet(apiURL);
	};
	
	this.getResource = function(resource){
		var apiURL = "/web/arthub/resource/name/" + resource;
		return doAsyncGet(apiURL);
	};
	
	ArthubAPI.instance = this;
}