myApp.controller("BlogController", function($scope, $http, BlogService, $rootScope, $cookieStore, $location, $route) {
	
	console.log("Starting of BlogController");
	
	this.blog = {
			errorMessage: '',
	        errorCode: '',
	        blogId: '',
	        likes: '',
	        userId: '',
	        blogName: '',
	        blogContent: '',
	        remarks: '',
	        status: '',
	        createDate: ''
	}
	
	$scope.selectedSort = "blogId";
	
	this.blogs=[];
	
	//getAllBlogs
	this.getAllBlogs = function(){
		console.log("Starting of method getAllBlogs");
		
		BlogService.getAllBlogs()
		.then(
				function(dataFromService){
					this.blogs = dataFromService;
					$rootScope.blogs = dataFromService;
					$cookieStore.put("blogs",this.blogs);
					$http.defaults.headers.common['Authorization'] = 'Basic ' +$rootScope.blogs;
					
				},
				function(errResponse){
					console.error("Error while fetching blogs!");
				}
		);
	};
	
	this.getAllBlogs();
	
	//approveBlog
	this.approveBlog = function(blogId){
		console.log("Starting of method approveBlog in BlogController");
		BlogService.approveBlog(blogId)
		.then(
				function(dataFromService){
					this.blog = dataFromService;
					this.getAllBlogs;
					console.log(this.blog.errorMessage);
					if(this.blog.errorCode == "404"){
						
						$rootScope.errorMessage = this.blog.errorMessage;
					} else {
						$rootScope.successMessage = this.blog.errorMessage;
						$route.reload();
						//$location.path("/ManageNewBlogs");
					}
				},
				null
		);
	};
	
	//rejectBlog
	this.rejectBlog = function(blogId){
		console.log("Starting of method rejectBlog in BlogController");
		BlogService.rejectBlog(blogId)
		.then(
				function(dataFromService){
					this.blog = dataFromService;
					this.getAllBlogs;
					console.log(this.blog.errorMessage);
					if(this.blog.errorCode == "404"){
						
						$rootScope.errorMessage = this.blog.errorMessage;
					} else {
						$rootScope.successMessage = this.blog.errorMessage;
						$route.reload();
						//$location.path("/ManageNewBlogs");
					}
				},
				null
		);
	};
	
	//deleteBlog
	this.deleteBlog = function(blogId){
		console.log("Starting of method deleteBlog in BlogController");
		BlogService.deleteBlog(blogId)
		.then(
				function(dataFromService){
					this.blog = dataFromService;
					this.getAllBlogs;
					console.log(this.blog.errorMessage);
					if(this.blog.errorCode == "404"){
						
						$rootScope.errorMessage = this.blog.errorMessage;
					} else {
						$rootScope.successMessage = this.blog.errorMessage;
						$route.reload();
						//$location.path("/ManageNewBlogs");
					}
				},
				null
		);
	};
	

	

});