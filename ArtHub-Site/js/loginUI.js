


var doAsyncPost = function (URL, jsonDataToPost) {
        return $.ajax({
            url: URL,
            type: "POST",
            data: jsonDataToPost,
        });
};
	
function login(){
	var elements = document.getElementById("login").elements;
    var user ={};
    for(var i = 0 ; i < elements.length ; i++){
        var item = elements.item(i);
        user[item.name] = item.value;
    }
    
    console.log(user);
    var request = doAsyncPost("http://localhost:8080/web/login", user);
	
	
}