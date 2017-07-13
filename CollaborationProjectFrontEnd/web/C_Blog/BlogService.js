myApp.service("BlogService", function($http, $q) {
	console.log("Starting blog service");
	
	var BackendUrl = 'http://localhost:8080/CollaborationProjectBackEnd';

	return {
		//getAllBlogs
		getAllBlogs : function(){
			console.log("Starting of getAllBlogs method in BlogService");
			
			return $http.get(BackendUrl+"/getAllBlogs")
			.then(
					function(response) {
						return response.data;
					}, 
					null
			);
		},
		
		//approveBlog
		approveBlog : function(blogId){
			console.log("Starting of method approveBlog in BlogService");
			
			return $http.put(BackendUrl+"/approveBlog/"+blogId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while approving blog");
			}
			);
		},
		
		//rejectBlog
		rejectBlog : function(blogId){
			console.log("Starting of method rejectBlog in BlogService");
			
			return $http.put(BackendUrl+"/rejectBlog/"+blogId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while rejecting blog");
			}
			);
		},
		
		//deleteBlog
		deleteBlog : function(blogId){
			console.log("Starting of method deleteBlog in BlogService");
			
			return $http.delete(BackendUrl+"/deleteBlog/"+blogId)
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error("Error while deleting blog");
			}
			);
		}
		
		
	}

	console.log("Ending blog service");
	

});