myApp.service('UserService', function($http, $q) {
	
	console.log('Starting of UserService');
	var BackendUrl = 'http://localhost:8080/CollaborationProjectBackEnd';
	
	return {
		//Validate 
		validate : function(user){
			console.log("Starting of validate method in UserService");
			
			return $http.post(BackendUrl+'/validate', user)
			.then(
					function(response) {
						return response.data; //returning user json object
					},
					null
			);
		},
	
		//SignOut
		signOut : function(){
			console.log("Starting signout method in UserService");
			
			return $http.get(BackendUrl+"/signOut")
			.then(
					function(response) {
						return response.data;
					},
					null
			);
		},
		
		//Register
		register : function(user){
			console.log("Starting of register method in UserService");
			
			return $http.post(BackendUrl+"/register", user)
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.log("Error while registering");
						return $q.reject(errResponse);
					});
		}
		
		
		
		
		
	};
	
});