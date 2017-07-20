var myApp = angular.module("myapp",["ngRoute","ngCookies"]);

myApp.directive('checkImage', function($http) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            attrs.$observe('ngSrc', function(ngSrc) {
                $http.get(ngSrc).success(function(){
                }).error(function(){
                    element.attr('src', 'resources/ProfilePics/default.png'); // set default image
                });
            });
        }
    };
});

myApp.run(function($rootScope, $http, $cookieStore){
	console.log("Starting of run method");
	
	//Getting loggedInUser details from cookies after page refresh
	$rootScope.loggedInUser = $cookieStore.get('loggedInUser') || {};
	if ($rootScope.loggedInUser) {
	    $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.loggedInUser; 
	};
	
	//Getting blogs details from localStorage after page refresh
	if(localStorage.getItem('blogs') != "undefined")
	$rootScope.blogs = JSON.parse(localStorage.getItem('blogs')) || {};
	
	//Getting forums details from localStorage after page refresh
	if(localStorage.getItem('forums') != "undefined")
	$rootScope.forums = JSON.parse(localStorage.getItem('forums')) || {};
	
	
	if(localStorage.getItem('forumComments') != "undefined")
	$rootScope.forumComments = JSON.parse(localStorage.getItem('forumComments')) || {};

	if(localStorage.getItem('forum1') != "undefined")
	$rootScope.forum1 = JSON.parse(localStorage.getItem('forum1')) || {};

	
	
	//Getting jobs details from local Storage after page refresh
	if(localStorage.getItem('jobs') != "undefined")
	$rootScope.jobs = JSON.parse(localStorage.getItem('jobs')) || {};
	
	//Getting jobApplications details from local Storage after page refresh
	if(localStorage.getItem('jobApplications') != "undefined")
	$rootScope.jobApplications = JSON.parse(localStorage.getItem('jobApplications')) || {};
	
	
	//Getting user details from localStorage after page refresh
	if(localStorage.getItem('users') != "undefined")
	$rootScope.users = JSON.parse(localStorage.getItem('users')) || {};
	
	
	console.log('Ending of run method');
})