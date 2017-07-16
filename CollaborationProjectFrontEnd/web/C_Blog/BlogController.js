myApp.controller("BlogController", function($scope, $http, BlogService, $rootScope, $cookieStore, $location, $route) {
	
	console.log("Starting of BlogController");
	
	this.blogStatus = "";
	
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
					localStorage.setItem('blogs', JSON.stringify(this.blogs));
					
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
	
	this.getManageAdminBlogStatus = function(){
		console.log("Starting of manageAdminPage method");
		if($location.path() == "/ManageNewBlogs"){
			this.blogStatus = 'N';
			return 'N';
		}
		else if($location.path() == "/ManageUpdatedBlogs"){
			this.blogStatus = 'U';
			return 'U';
		}
		else if($location.path() == "/ManageRejectedBlogs"){
			this.blogStatus = 'R';
			return 'R';
		} else {
			this.blogStatus = "";
			//console.log("Invalid usage of method getManageAdminBlogStatus");
		}
	};
	

});