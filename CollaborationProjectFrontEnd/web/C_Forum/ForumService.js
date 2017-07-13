myApp.service("ForumService", function($http, $q) {
	console.log("Starting forum service");
	
	var BackendUrl = 'http://localhost:8080/CollaborationProjectBackEnd';

	return {
		//getAllForums
		getAllForums : function(){
			console.log("Starting of getAllForums method in ForumService");
			
			return $http.get(BackendUrl+"/getAllForums")
			.then(
					function(response) {
						return response.data;
					}, 
					null
			);
		}
		
		
	}
	
	
	console.log("Ending forum service");
	

});