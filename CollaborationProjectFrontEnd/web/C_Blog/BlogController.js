myApp.controller("BlogController", function($scope, $http, $route) {

	$scope.blog = {
		blogname : "",
		blogcontent : ""
	};

	$http.get("http://localhost:8080/CollaborationProject/getBlogs").then(
			function(response) {
				$scope.blogdata = response.data;
				console.log(response.data);
			});

	$scope.saveBlogPost = function() {
		$http.post('http://localhost:8080/CollaborationProject/insertBlog',
				$scope.blog).then(function(response) {
			console.log(response);
			$scope.message = response.data;
		});
	};

	$scope.reloadRoute = function() {
		$route.reload();
	};

});