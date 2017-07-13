myApp.controller("ForumController", function($scope, $http, ForumService, $rootScope, $cookieStore, $location){
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
	
	this.forums=[];
	
	//getAllForums
	this.getAllForums = function(){
		console.log("Starting of method getAllForums");
		
		ForumService.getAllForums()
		.then(
				function(dataFromService){
					this.forums = dataFromService;
					$rootScope.forums = dataFromService;
					$cookieStore.put("forums",this.forums);
					$http.defaults.headers.common['Authorization'] = 'Basic ' +$rootScope.forums;
					
				},
				function(errResponse){
					console.error("Error while fetching forums!");
				}
		);
	};
	
	this.getAllForums();
	
	
	

});