myApp.config(function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "Template/Home.html"
	})
	.when("/Login", {
		templateUrl : "Template/Login.html"
	})
	.when("/Register", {
		templateUrl : "Template/Register.html"
	})
	.when("/Blog", {
		templateUrl : "C_Blog/Blog.html",
		controller: "BlogController"
	})
	.when("/Forum", {
		templateUrl : "C_Forum/Forum.html",
		controller: "ForumController"
	})
	.when("/Jobs", {
		templateUrl : "C_Jobs/Jobs.html",
		controller: "C_Jobs/JobsController"
	})
});