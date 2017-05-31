package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.ForumCommentDAO;
import com.niit.collaborationproject.model.ForumComment;

public class ForumCommentDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ForumComment forumComment;

	@Autowired
	static ForumCommentDAO forumCommentDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		forumCommentDAO = (ForumCommentDAO) context.getBean("forumCommentDAO");

		// get the category from context

		forumComment = (ForumComment) context.getBean("forumComment");

	}

	@Test
	public void insertForumCommentTestCase() {
		forumComment.setForumcommentid(1);
		forumComment.setUserid(1);
		forumComment.setForumid(1);
		forumComment.setForumcomment("Awesome Forum");
		forumComment.setUsername("Suveen");
		forumComment.setCommentdate(new Date());

		System.out.println(forumComment);

		boolean flag = forumCommentDAO.insertForumComment(forumComment);

		assertEquals("insertForumCommentTestCase", true, flag);

	}
	
	//@Test
	public void deteleForumCommentTestCase(){
		boolean flag = forumCommentDAO.deleteForumComment(1);
		assertEquals("deleteForumTestCase", true, flag);
	}
	
	@Test
	public void listForumCommentTestCase(){
		int size = forumCommentDAO.list().size();
		assertEquals("listForumCommentTestCase", 1, size);
	}

}
