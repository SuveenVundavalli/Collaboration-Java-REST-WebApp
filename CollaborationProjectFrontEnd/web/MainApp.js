var myApp = angular.module("myapp",["ngRoute","ngCookies"]);




myApp.run(function($rootScope, $http, $cookieStore){
	console.log("Starting of run method");
	
	//Getting loggedInUser details from cookies after page refresh
	$rootScope.loggedInUser = $cookieStore.get('loggedInUser') || {};
	if ($rootScope.loggedInUser) {
	    $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.loggedInUser; 
	};
	
	//Getting blogs details from cookies after page refresh
	$rootScope.blogs = $cookieStore.get('blogs') || {};
	if ($rootScope.blogs) {
		$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.blogs; 
	};
	
	//Getting forums details from cookies after page refresh
	$rootScope.forums = $cookieStore.get('forums') || {};
	if ($rootScope.blogs) {
		$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.forums; 
	};
	
	//Getting jobs details from cookies after page refresh
	$rootScope.jobs = $cookieStore.get('jobs') || {};
	if ($rootScope.blogs) {
		$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.jobs; 
	};
	
	//Getting user details from cookies after page refresh
	$rootScope.users = $cookieStore.get('users') || {};
	if ($rootScope.blogs) {
		$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.users; 
	}
	
	
	console.log('Ending of run method');
})