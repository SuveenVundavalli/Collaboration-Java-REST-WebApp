myApp.controller("UserController", function($scope,$http) {
	
	var baseURL = "http://localhost:8080/CollaborationProject/";
	
	$scope.userTable = {
			firstname : "",
			lastname : "",
			password : "",
			email : ""
	};
	$scope.testmessage= "message";
	
	
	$scope.insertUser = function(){
		$http.post("http://localhost:8080/CollaborationProject/insertUser",$scope.userTable)
		.then(function(response){
			$scope.message = "Registration Successful";
		});
	};
	
	$scope.userLogin = function(){
		//alert("userlogin");
		$http.post("http://localhost:8080/CollaborationProject/authenticateUser", $scope.userTable)
		.then(function(response){
			$scope.loggedInUserDetails = response.data;
			console.log(response.data);
		});
	};
})
