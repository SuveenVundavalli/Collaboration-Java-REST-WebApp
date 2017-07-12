myApp.service('UserService', function($http, $q) {
	
	console.log('Starting of UserService');
	var BackendUrl = 'http://localhost:8080/CollaborationProjectBackEnd';
	
	return {
		validate : function(user){
			console.log("Starting of validate method");
			
			return $http.post(BackendUrl+'/validate', user)
			.then(
					function(response) {
						return response.data; //returning user json object
					},
					null
			);
		}
	};
	
});