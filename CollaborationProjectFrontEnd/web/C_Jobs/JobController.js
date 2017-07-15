myApp.controller("JobController", function($scope, $http, JobService, $rootScope, $cookieStore, $location, $route) {

	console.log("Starting of JobController");
	
	this.job = {
			errorMessage: "",
	        errorCode: "",
	        jobId: "",
	        jobTitle: "",
	        jobQualification: "",
	        jobStatus: "",
	        jobDescription: "",
	        createDate: ""
	}
	
	this.jobs = [];
	
	this.jobStatus = "";
	
	$scope.selectedSort = "jobId";
	
	//getAllJobs
	this.getAllJobs = function(){
		console.log("Starting of method getAllJobs");
		
		JobService.getAllJobs()
		.then(
				function(dataFromService) {
					this.jobs = dataFromService;
					$rootScope.jobs = dataFromService;
					$cookieStore.put("jobs", this.jobs);
					$http.defaults.headers.common['Authorization'] = 'Basic ' +$rootScope.blogs;
				}, 
				function(errResponse) {
					console.error("Error wile fetching jobs");
				}
		);
	};
	this.getAllJobs();
	
	
	this.postNewJob = function(job, insertjob){
		console.log("Starting of postNewJob() in JobController");
		
		JobService.postNewJob(job)
		.then(
				function(response){
					if(response.errorCode=="404"){
						$rootScope.errorMessage = response.errorMessage;
						console.error(response.errorMessage)
					} else {
						this.getAllJobs;
						console.log(response.errorMessage);
						$rootScope.successMessage = response.errorMessage;
						$scope.resetForm(insertjob);
						$route.reload();
						
					}
				}
		)
		
	}
	

	
	this.closeJob = function(jobId){
		console.log("Starting of method closeJob() in JobController");
		
		JobService.closeJob(jobId)
		.then(
				function(dataFromService){
					this.job = dataFromService;
					this.getAllJobs;
					console.log(this.job.errorMessage);
					if(this.job.errorCode == "404"){
						$rootScope.errorMessage = this.job.errorMessage;
					} else {
						$rootScope.successMessage = this.job.errorMessage;
						$route.reload();
					}
				},
				null
		);
	};
	
	this.openJob = function(jobId){
		console.log("Starting of method openJob() in JobController");
		
		JobService.openJob(jobId)
		.then(
				function(dataFromService){
					this.job = dataFromService;
					this.getAllJobs;
					console.log(this.job.errorMessage);
					if(this.job.errorCode == "404"){
						$rootScope.errorMessage = this.job.errorMessage;
					} else {
						$rootScope.successMessage = this.job.errorMessage;
						$route.reload();
					}
				},
				null
		);
	};
	
	this.getManageAdminJobStatus = function(){
		console.log("Starting of getManageAdminJobStatus method");
		if($location.path() == "/ManageOpenJobs"){
			this.jobStatus = 'O';
			return 'O';
		}
		else if($location.path() == "/ManageClosedJobs"){
			this.jobStatus = 'C';
			return 'C';
		}
		else {
			this.jobStatus = "";
			//console.log("Invalid usage of method getManageAdminJobStatus");
		}
	};
	
	$scope.resetForm = function(insertjob){
		console.log("Starting reserForm method");
		console.log(insertjob);
		this.job = {
				errorMessage: '',
		        errorCode: '',
		        jobId: '',
		        jobTitle: '',
		        jobQualification: '',
		        jobStatus: '',
		        jobDescription: '',
		        createDate: ''
		};
		insertjob.$setPristine();
		insertjob.$setUntouched();
	}
	
	console.log("Ending of JobController");

});