var myApp = angular.module("myapp",["ngRoute","ngCookies"]);




myApp.run(function($rootScope, $http, $cookieStore){
	// keep user logged in after page refresh
	$rootScope.loggedInUser = $cookieStore.get('loggedInUser') || {};
	if ($rootScope.loggedInUser) {
	    $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.loggedInUser; 
	}
})