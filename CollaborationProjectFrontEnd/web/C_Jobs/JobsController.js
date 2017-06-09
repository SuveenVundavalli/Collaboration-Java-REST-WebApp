myApp.controller("JobsController", function($scope, $http) {

	$scope.job = {
		jobprofile : "",
		jobdesc : "",
		qualification : ""
	};

	$http.get("http://localhost:8080/CollaborationProject/getJobs").then(
			function(response) {
				$scope.jobdata = response.data;
			});

	$scope.saveJobPost = function() {
		$http.post("http://localhost:8080/CollaborationProject/insertJob", $scope.job)
		.then(function(response) {
			$scope.message = "Successfully added job";
			console.log(response);
		});
	};

});