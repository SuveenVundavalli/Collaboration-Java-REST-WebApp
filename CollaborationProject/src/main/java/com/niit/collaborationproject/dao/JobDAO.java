package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.Job;

public interface JobDAO {

	public boolean insertJob(Job job);
	
	public boolean deleteJob(int id);
	public Job getJobById(int id);
	public List<Job> list();
}
