myApp.config(function($routeProvider) {

	$routeProvider
	.when("/", {
		templateUrl : "Template/Home.html"
	})
	.when("/Login", {
		templateUrl : "C_User/Login.html",
		controller : "UserController"
	})
	.when("/Register", {
		templateUrl : "C_User/Register.html",
		controller : "UserController"
	})
	.when("/Blog", {
		templateUrl : "C_Blog/Blog.html",
		controller : "BlogController"
	})
	.when("/Forum", {
		templateUrl : "C_Forum/Forum.html",
		controller : "ForumController"
	})
	.when("/Jobs", {
		templateUrl : "C_Jobs/Jobs.html",
		controller : "JobsController"
	})
	//Admin
	.when("/ManageNewBlogs", {
		templateUrl : "C_Blog/Admin_ManageNewBlogs.html",
		controller : "BlogController"
	})
	.when("/ManageUpdatedBlogs", {
		templateUrl : "C_Blog/Admin_ManageUpdatedBlogs.html",
		controller : "BlogController"
	})
	.when("/ManageRejectedBlogs", {
		templateUrl : "C_Blog/Admin_ManageRejectedBlogs.html",
		controller : "BlogController"
	})
	.otherwise({redirectTo:'/'});
});