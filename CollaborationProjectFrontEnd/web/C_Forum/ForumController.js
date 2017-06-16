myApp.controller("ForumController", function($scope, $http, $route) {

	$scope.test = "test";
	
	$scope.forum = {
		forumname : "",
		forumcontent : ""
	};

	// getting Forums from rest controller
	$http.get("http://localhost:8080/CollaborationProject/getForums").then(
			function(response) {
				$scope.forumdata = response.data;
				console.log(response.data);
			});
	
	//Inserting new forum
	$scope.saveForumPost = function(){
		$http.post("http://localhost:8080/CollaborationProject/insertForum", $scope.forum).then(function(response){
			console.log(response);
			
		});
	};
	
	$scope.reloadRoute = function() {
		$route.reload();
	};

});