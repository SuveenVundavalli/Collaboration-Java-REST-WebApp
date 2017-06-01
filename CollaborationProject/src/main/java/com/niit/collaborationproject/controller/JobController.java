package com.niit.collaborationproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationproject.dao.JobDAO;
import com.niit.collaborationproject.model.Job;

@RestController
public class JobController {

	@Autowired JobDAO jobDAO;
	
	//@Autowired Job job;
	
	@RequestMapping(value="/getJobs", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs(){
		
		List<Job> listjobs = jobDAO.list();
		
		return new ResponseEntity<List<Job>>(listjobs, HttpStatus.OK);
	}
	
	//Create Job
	@RequestMapping(value="/insertJob", method=RequestMethod.POST)
	public ResponseEntity<String> addJob(@RequestBody Job job){
		
		
		job.setStatus("NA");
		job.setPostdate(new Date());
		jobDAO.insertJob(job);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteJob/{jobid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> addJob(@PathVariable("jobid") int jobid){
	
		jobDAO.deleteJob(jobid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/approveJob/{jobid}", method=RequestMethod.PUT)
	public ResponseEntity<Job> approveJob(@PathVariable("jobid") int jobid){
		Job job = jobDAO.getJobById(jobid);
		job.setStatus("A");
		jobDAO.insertJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	
	
	
}
