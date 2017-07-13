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
	
	this.loggedInUser = {	
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
	
	this.successMessage = "";
	this.errorMessage = "";
	
	this.isUserLoggedIn = false;
	
	this.users = [];
	
	//validate
	this.validate = function (user){
		console.log("Starting of validate method");
		
		UserService.validate(user)
		.then(
				function(dataFromService){
					this.user = dataFromService;
					console.log("Validate error code : "+this.user.errorCode);
					
					if(this.user.errorCode == "404"){
						//
						$rootScope.errorMessage = this.user.errorMessage;
						this.user.userId = "";
						this.user.password = "";
					} else {
						//valid credentials
						console.log("Valid credentials! Returning to home page");
						$rootScope.successMessage = this.user.errorMessage+" Welcome "+this.user.firstname+" "+this.user.lastname;
						$rootScope.isUserLoggedIn = true;
						console.log("Logged is as : "+this.user);
						$rootScope.loggedInUser = this.user;
						$cookieStore.put('loggedInUser', this.user);
						$http.defaults.headers.common['Authorization'] = 'Basic ' +$rootScope.loggedInUser;
						if(this.user.role == "ROLE_ADMIN"){
							console.log("Redirecting to admin page");
							$location.path('/AdminHome');
						} else {
							console.log("Redirecting to home page");
							$location.path('/');
						}
						
					}
				}, function(errResponse){
					console.error('Error while authentication user');
				}
				
				
		);
	};
	
	//signout
	this.signOut = function(){
		console.log("Starting of method signOut in UserController");
		$rootScope.loggedInUser = {};
		$rootScope.isUserLoggedIn = false;
		$cookieStore.remove("loggedInUser");
		UserService.signOut();
		$rootScope.successMessage = "Successfully Signed Out! Welcome Back!!";
		$location.path("/");
	}
	
	//register user
	this.register = function(user){
		console.log("Starting of registration method");
		UserService.register(user)
		.then(function(dataFromService) {
			this.user = dataFromService;
			if(this.user.errorCode == "404"){
				console.log(this.user.errorMessage);
				$rootScope.errorMessage = this.user.errorMessage;
			} else {
				console.log(this.user.errorMessage);
				$rootScope.successMessage = this.user.errorMessage+" Please login to continue!";
				
				$location.path('/Login');
				
			}
		}, function(reason) {
			console.log("Error occured during registration");
			
			
		});
		
	} 
	
	
	
	
	
	
});
