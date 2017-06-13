package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.BlogCommentDAO;
import com.niit.collaborationproject.model.BlogComment;

public class BlogCommentDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static BlogComment blogComment;

	@Autowired
	static BlogCommentDAO blogCommentDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");

		// get the category from context

		blogComment = (BlogComment) context.getBean("blogComment");

	}

	@Test
	public void insertBlogCommentTestCase() {
		blogComment.setBlogcommentid(10);
		blogComment.setUserid(1);
		blogComment.setBlogid(1);
		blogComment.setBlogcomment("Awesome Blog");
		blogComment.setUsername("Suveen");
		blogComment.setCommentdate(new Date());

		System.out.println(blogComment);

		boolean flag = blogCommentDAO.insertBlogComment(blogComment);

		assertEquals("insertBlogCommentTestCase", true, flag);

	}
	
	@Test
	public void deteleBlogCommentTestCase(){
		boolean flag = blogCommentDAO.deleteBlogComment(10);
		assertEquals("deleteBlogTestCase", true, flag);
	}
	
	
	@Test
	public void listBlogCommentTestCase(){
		int size = blogCommentDAO.list().size();
		assertEquals("listBlogCommentTestCase", 1, size);
	}
	
	@Test
	public void listAllBlogCommentTestCase(){
		int size = blogCommentDAO.getAllComments(1).size();
		assertEquals("listAllBlogCommentTestCase", 5, size);
	}

}
