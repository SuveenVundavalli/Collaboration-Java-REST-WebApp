package com.niit.collaborationproject.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationproject.dao.UserTableDAO;
import com.niit.collaborationproject.model.UserTable;

public class UserTableDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserTable userTable;

	@Autowired
	static UserTableDAO userTableDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationproject");
		context.refresh();

		// get the categoryDAO from context
		userTableDAO = (UserTableDAO) context.getBean("userTableDAO");

		// get the category from context

		userTable = (UserTable) context.getBean("userTable");

	}

	@Test
	public void insertUserTableTestCase() {
		userTable.setEmail("suveenkumar.vundavalli@gmail.com");
		userTable.setFirstname("Suveen Kumar");
		userTable.setIsonline("true");
		userTable.setLastname("Vundavalli");
		userTable.setPassword("Suveen");
		userTable.setRole("ROLE_ADMIN");
		userTable.setStatus("Single");
		userTable.setUserid(1);

		System.out.println(userTable);

		boolean flag = userTableDAO.insertUserTable(userTable);

		assertEquals("insertUserTableTestCase", true, flag);

	}
	
	@Test
	public void listUserTableTestCase(){
		int size = userTableDAO.list().size();
		assertEquals("listUserTableTestCase", 1, size);
	}
	
	@Test
	public void validateUserTableTestCase(){
		boolean flag = userTableDAO.validate("suveenkumar.vundavalli@gmail.com", "Suveen");
		assertEquals("validateUserTableTestCase", true, flag);
	}

}
