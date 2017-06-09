myApp.controller("UserController", function($scope,$http) {
	
	$scope.userTable = {
			firstname : "",
			lastname : "",
			password : "",
			email : ""
	};
	
	
	$scope.insertUser = function(){
		$http.post("http://localhost:8080/CollaborationProject/insertUser",$scope.userTable)
		.then(function(response){
			$scope.message = "Registration Successful";
		});
	};
	
})
