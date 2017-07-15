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
		},
		
		//approveForum
		approveForum : function(forumId){
			console.log("Starting of method approveForum in ForumService");
			
			return $http.put(BackendUrl+"/approveForum/"+forumId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while approving forum");
			}
			);
		},
		
		//rejectForum
		rejectForum : function(forumId){
			console.log("Starting of method rejectForum in ForumService");
			
			return $http.put(BackendUrl+"/rejectForum/"+forumId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while rejecting forum");
			}
			);
		},
		
		//deleteForum
		deleteForum : function(forumId){
			console.log("Starting of method deleteForum in ForumService");
			
			return $http.delete(BackendUrl+"/deleteForum/"+forumId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while deleting forum");
			}
			);
		}
	}
	
	
	console.log("Ending forum service");
	

});