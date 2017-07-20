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
	.when("/viewForum", {
		templateUrl : "C_Forum/ViewForum.html",
		controller : "ForumController"
	})
	.when("/Jobs", {
		templateUrl : "C_Jobs/Jobs.html",
		controller : "JobController"
	})
	.when("/MyProfile", {
		templateUrl : "C_User/MyProfile.html",
		controller : "UserController"
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
	.when("/ManageForums", {
		templateUrl : "C_Forum/Admin_ManageForums.html",
		controller : "ForumController"
	})
	.when("/CreateNewForum", {
		templateUrl : "C_Forum/Admin_CreateForum.html",
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
	.when("/ManageJobApplications", {
		templateUrl : "C_Jobs/Admin_ManageJobApplications.html",
		controller : "JobController"
	})
	.when("/ManageNewUsers", {
		templateUrl : "C_User/Admin_ManageUsers.html",
		controller : "UserController"
	})
	.when("/ManageExistingUsers", {
		templateUrl : "C_User/Admin_ManageUsers.html",
		controller : "UserController"
	})
	.when("/ManageRejectedUsers", {
		templateUrl : "C_User/Admin_ManageUsers.html",
		controller : "UserController"
	})
	.when("/CreateNewUsers", {
		templateUrl : "C_User/Register.html",
		controller : "UserController"
	})
	.otherwise({redirectTo:'/'});
});