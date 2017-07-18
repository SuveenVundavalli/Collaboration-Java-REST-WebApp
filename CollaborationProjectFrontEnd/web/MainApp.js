var myApp = angular.module("myapp",["ngRoute","ngCookies"]);




myApp.run(function($rootScope, $http, $cookieStore){
	console.log("Starting of run method");
	
	//Getting loggedInUser details from cookies after page refresh
	$rootScope.loggedInUser = $cookieStore.get('loggedInUser') || {};
	if ($rootScope.loggedInUser) {
	    $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.loggedInUser; 
	};
	
	//Getting blogs details from localStorage after page refresh
	$rootScope.blogs = JSON.parse(localStorage.getItem('blogs')) || {};
	
	//Getting forums details from localStorage after page refresh
	$rootScope.forums = JSON.parse(localStorage.getItem('forums')) || {};
	
	$rootScope.forumComments = JSON.parse(localStorage.getItem('forumComments')) || {};
	$rootScope.forum1 = JSON.parse(localStorage.getItem('forum1')) || {};
	console.log("Forum Comments");
	console.log($rootScope.forumComments);
	
	
	//Getting jobs details from local Storage after page refresh
	$rootScope.jobs = JSON.parse(localStorage.getItem('jobs')) || {};
	
	//Getting jobApplications details from local Storage after page refresh
	$rootScope.jobApplications = JSON.parse(localStorage.getItem('jobApplications')) || {};
	
	
	//Getting user details from localStorage after page refresh
	$rootScope.users = JSON.parse(localStorage.getItem('users')) || {};
	
	
	console.log('Ending of run method');
})