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
		templateUrl : "C_Blog/Admin_ManageBlogs.html",
		controller : "BlogController"
	})
	.when("/ManageUpdatedBlogs", {
		templateUrl : "C_Blog/Admin_ManageBlogs.html",
		controller : "BlogController"
	})
	.when("/ManageRejectedBlogs", {
		templateUrl : "C_Blog/Admin_ManageBlogs.html",
		controller : "BlogController"
	})
	.when("/ManageNewForums", {
		templateUrl : "C_Forum/Admin_ManageForums.html",
		controller : "ForumController"
	})
	.when("/ManageUpdatedForums", {
		templateUrl : "C_Forum/Admin_ManageForums.html",
		controller : "ForumController"
	})
	.when("/ManageRejectedForums", {
		templateUrl : "C_Forum/Admin_ManageForums.html",
		controller : "ForumController"
	})
	.when("/CreateNewJob", {
		templateUrl : "C_Jobs/Admin_CreateJob.html",
		controller : "JobController"
	})
	.when("/ManageOpenJobs", {
		templateUrl : "C_Jobs/Admin_ManageJobs.html",
		controller : "JobController"
	})
	.when("/ManageClosedJobs", {
		templateUrl : "C_Jobs/Admin_ManageJobs.html",
		controller : "JobController"
	})
	.otherwise({redirectTo:'/'});
});