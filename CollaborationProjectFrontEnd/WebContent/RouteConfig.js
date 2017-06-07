var myapp = angular.module("myApp", [ ngRoute ]);

myapp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "index.html",
		controller : "HomeCtrl"
	}).when("#/Home", {
		templateUrl : "Template/Home.html",
		controller : "HomeCtrl"
	}).when("#/Register", {
		templateUrl : "Template/Register.html",
		controller : "HomeCtrl"
	}).when("#/Login", {
		templateUrl : "Template/Login.html",
		controller : "HomeCtrl"
	})
});