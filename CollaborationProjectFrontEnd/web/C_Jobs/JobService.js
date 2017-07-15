myApp.service("JobService", function($http, $q) {
	console.log("Starting job service");
	
	var BackendUrl = 'http://localhost:8080/CollaborationProjectBackEnd';
	
	return{
		//getAllJobs
		getAllJobs : function(){
			console.log("Starting of getAllJobs method in JobService");
			
			return $http.get(BackendUrl+"/getAllJobs")
			.then(
					function(response){
						return response.data;
					},
					null
			);
		},
		
		closeJob : function(jobId){
			console.log("Starting of closeJob method in JobService");
			
			return $http.put(BackendUrl+"/closeJob/"+jobId)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while closing job");
					}
			);
		},
		openJob : function(jobId){
			console.log("Starting of openJob method in JobService");
			
			return $http.put(BackendUrl+"/openJob/"+jobId)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while closing job");
					}
			);
		},
		postNewJob : function(job) {
			console.log("Starting of postNewJob() in JobService");
			
			return $http.post(BackendUrl+"/postNewJob", job)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while posting new job");
					}
			);
		}
	
		
	}
	
	console.log("Ending job service");

});