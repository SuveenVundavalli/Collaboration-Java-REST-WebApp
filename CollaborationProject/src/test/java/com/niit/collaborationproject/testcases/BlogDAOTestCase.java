package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.BlogDAO;
import com.niit.collaborationproject.model.Blog;

public class BlogDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Blog blog;
	
	@Autowired
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		blogDAO = (BlogDAO) context.getBean("blogDAO");

		// get the category from context

		blog = (Blog) context.getBean("blog");

	}
	
	@Test
	public void insertBlogTestCase(){
		blog.setBlogid(2);
		blog.setUserid(1);
		blog.setLikes(10);
		blog.setCreatedate(new Date());
		blog.setBlogname("Who am I?!!");
		blog.setBlogcontent("A true story about my journey");
		
		System.out.println(blog);
		
		boolean flag = blogDAO.insertBlog(blog);
		
		
		
		assertEquals("insertBlogTestCase", true, flag);
		
		
	}

}
