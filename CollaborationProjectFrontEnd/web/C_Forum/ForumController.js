myApp.controller("ForumController", function($scope, $http, ForumService, $rootScope, $cookieStore, $location, $route){
console.log("Starting of ForumController");
	
	this.forum = {
			errorMessage: '',
	        errorCode: '',
	        forumId: '',
	        likes: '',
	        userId: '',
	        forumName: '',
	        forumContent: '',
	        remarks: '',
	        status: '',
	        createDate: ''
	}
	
	this.forumStatus = "";
	
	$scope.selectedSort = "forumId";
	
	this.forums=[];
	
	//getAllForums
	this.getAllForums = function(){
		console.log("Starting of method getAllForums");
		
		ForumService.getAllForums()
		.then(
				function(dataFromService){
					this.forums = dataFromService;
					$rootScope.forums = dataFromService;
					localStorage.setItem('forums', JSON.stringify(this.forums));
					
					
				},
				function(errResponse){
					console.error("Error while fetching forums!");
				}
		);
	};
	
	this.getAllForums();
	
	//approveForum
	this.approveForum = function(forumId){
		console.log("Starting of method approveForum in ForumController");
		ForumService.approveForum(forumId)
		.then(
				function(dataFromService){
					this.forum = dataFromService;
					this.getAllForums;
					console.log(this.forum.errorMessage);
					if(this.forum.errorCode == "404"){
						
						$rootScope.errorMessage = this.forum.errorMessage;
					} else {
						$rootScope.successMessage = this.forum.errorMessage;
						$route.reload();
						//$location.path("/ManageNewForums");
					}
				},
				null
		);
	};
	
	//rejectForum
	this.rejectForum = function(forumId){
		console.log("Starting of method rejectForum in ForumController");
		ForumService.rejectForum(forumId)
		.then(
				function(dataFromService){
					this.forum = dataFromService;
					this.getAllForums;
					console.log(this.forum.errorMessage);
					if(this.forum.errorCode == "404"){
						
						$rootScope.errorMessage = this.forum.errorMessage;
					} else {
						$rootScope.successMessage = this.forum.errorMessage;
						$route.reload();
						//$location.path("/ManageNewForums");
					}
				},
				null
		);
	};
	
	//deleteForum
	this.deleteForum = function(forumId){
		console.log("Starting of method deleteForum in ForumController");
		ForumService.deleteForum(forumId)
		.then(
				function(dataFromService){
					this.forum = dataFromService;
					this.getAllForums;
					console.log(this.forum.errorMessage);
					if(this.forum.errorCode == "404"){
						
						$rootScope.errorMessage = this.forum.errorMessage;
					} else {
						$rootScope.successMessage = this.forum.errorMessage;
						$route.reload();
						//$location.path("/ManageNewForums");
					}
				},
				null
		);
	};
	
	
	this.getManageAdminForumStatus = function(){
		console.log("Starting of manageAdminPage method");
		if($location.path() == "/ManageNewForums"){
			this.forumStatus = 'N';
			return 'N';
		}
		else if($location.path() == "/ManageUpdatedForums"){
			this.forumStatus = 'U';
			return 'U';
		}
		else if($location.path() == "/ManageRejectedForums"){
			this.forumStatus = 'R';
			return 'R';
		} else {
			this.forumStatus = "";
			//console.log("Invalid usage of method getManageAdminForumStatus");
		}
	};
	

});