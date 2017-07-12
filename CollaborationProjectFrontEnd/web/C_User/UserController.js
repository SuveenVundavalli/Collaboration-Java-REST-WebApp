myApp.controller("UserController", function($scope,$http, UserService, $rootScope, $cookieStore, $location) {
	
	console.log('Starting of UserController');
	
	this.user = {	
		userId 		: '',
		firstname 	: '',
		lastname 	: '',
		password 	: '',
		email 		: '',
		role 		: '',
		status 		: '',
		
		isOnline 	: '',
		remarks 	: '',
		errorMessage: '',
		errorCode	: ''		
	};
	
	$rootScope.loggedInUser = {	
			userId 		: '',
			firstname 	: '',
			lastname 	: '',
			password 	: '',
			email 		: '',
			role 		: '',
			status 		: '',
			
			isOnline 	: '',
			remarks 	: '',
			errorMessage: '',
			errorCode	: ''		
	};
	
	$rootScope.message = "";
	
	$rootScope.isUserLoggedIn = false;
	
	this.users = [];
	
	this.validate = function (user){
		console.log("Starting of validate method");
		
		UserService
		.validate(user)
		.then(
				function(dataFromService){
					this.user = dataFromService;
					console.log("Validate error code : "+this.user.errorCode);
					
					if(this.user.errorCode == "404"){
						//
						$rootScope.message = this.user.errorMessage;
						this.user.userId = "";
						this.user.password = "";
					} else {
						//valid credentials
						console.log("Valid credentials! Returning to home page");
						$rootScope.message = this.user.errorMessage;
						$rootScope.isUserLoggedIn = true;
						console.log("Logged is as : "+this.user);
						$rootScope.loggedInUser = this.user;
						$cookieStore.put('loggedInUser', this.user);
						$http.defaults.headers.common['Authorization'] = 'Basic ' +$rootScope.loggedInUser;
						$location.path('/');
						
					}
				}, function(errResponse){
					console.error('Error while authentication user');
				}
				
				
		);
	};
	
	
	
	
	
});
