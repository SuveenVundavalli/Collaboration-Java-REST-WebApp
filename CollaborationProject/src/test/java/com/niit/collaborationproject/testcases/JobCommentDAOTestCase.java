package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.JobDAO;
import com.niit.collaborationproject.model.Job;

public class JobCommentDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Job job;

	@Autowired
	static JobDAO jobDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		jobDAO = (JobDAO) context.getBean("jobDAO");

		// get the category from context

		job = (Job) context.getBean("job");

	}

	@Test
	public void insertJobTestCase() {
		job.setJobid(1);
		job.setJobdesc("Software Developer");
		job.setJobprofile("Developer");
		job.setQualification("Master of Science");
		job.setStatus("Single");
		job.setPostdate(new Date());

		System.out.println(job);

		boolean flag = jobDAO.insertJob(job);

		assertEquals("insertJobTestCase", true, flag);

	}
	
	@Test
	public void deteleJobTestCase(){
		boolean flag = jobDAO.deleteJob(1);
		assertEquals("deleteBlogTestCase", true, flag);
	}
	
	@Test
	public void listJobTestCase(){
		int size = jobDAO.list().size();
		assertEquals("listJobTestCase", 1, size);
	}

}
