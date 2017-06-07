package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.FriendDAO;
import com.niit.collaborationproject.model.Friend;

public class FriendDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Friend friend;
	
	@Autowired
	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		friendDAO = (FriendDAO) context.getBean("friendDAO");

		// get the category from context

		friend = (Friend) context.getBean("friend");

	}
	
	@Test
	public void insertFriendTestCase(){
		friend.setTableid(1);
		friend.setFriendid(4);
		friend.setUserid(1);
		friend.setStatus("Best Friends");
		
		System.out.println(friend);
		
		boolean flag = friendDAO.insertFriend(friend);
		
		
		
		assertEquals("insertFriendTestCase", true, flag);
		
		
	}
	
	//@Test
	public void deteleFriendTestCase(){
		boolean flag = friendDAO.deleteFriend(1);
		assertEquals("deleteFriendTestCase", true, flag);
	}
	/*
	 @Test
	public void deteleFriendTestCase(){
		boolean flag = friendDAO.deleteFriend(1,4);
		assertEquals("deleteFriendTestCase", true, flag);
	}
	
	 */
	@Test
	public void listFriendTestCase(){
		int size = friendDAO.list().size();
		assertEquals("listFriendTestCase", 2, size);
	}

}
