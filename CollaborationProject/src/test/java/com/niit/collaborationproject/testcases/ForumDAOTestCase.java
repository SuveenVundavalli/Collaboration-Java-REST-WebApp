package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.ForumDAO;
import com.niit.collaborationproject.model.Forum;

public class ForumDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Forum forum;
	
	@Autowired
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		forumDAO = (ForumDAO) context.getBean("forumDAO");

		// get the category from context

		forum = (Forum) context.getBean("forum");

	}
	
	@Test
	public void insertForumTestCase(){
		forum.setForumid(1);
		forum.setUserid(1);
		forum.setCreatedate(new Date());
		forum.setForumname("Who am I?!!");
		forum.setForumcontent("A true story about my journey");
		
		System.out.println(forum);
		
		boolean flag = forumDAO.insertForum(forum);
		
		
		
		assertEquals("insertForumTestCase", true, flag);
		
		
	}
	
	@Test
	public void deteleForumTestCase(){
		boolean flag = forumDAO.deleteForum(2);
		assertEquals("deleteForumTestCase", true, flag);
	}
	
	@Test
	public void listForumTestCase(){
		int size = forumDAO.list().size();
		assertEquals("listForumTestCase", 1, size);
	}

}
