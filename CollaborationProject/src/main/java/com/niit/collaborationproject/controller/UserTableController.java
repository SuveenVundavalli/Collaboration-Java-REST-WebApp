package com.niit.collaborationproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationproject.dao.UserTableDAO;
import com.niit.collaborationproject.model.UserTable;

@RestController
public class UserTableController {

	@Autowired UserTableDAO userTableDAO;
	
	//@Autowired UserTable userTable;
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public ResponseEntity<List<UserTable>> getAllUserTables(){
		
		List<UserTable> listuserTables = userTableDAO.list();
		
		return new ResponseEntity<List<UserTable>>(listuserTables, HttpStatus.OK);
	}
	
	//Create UserTable
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public ResponseEntity<String> addUserTable(@RequestBody UserTable userTable){
		
		userTable.setRole("ROLE_USER");
		userTable.setStatus("NA");
		userTable.setIsonline("flase");
		userTableDAO.insertUserTable(userTable);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUserToAdmin/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateUserToAdmin(@PathVariable("userid") int userid){
		UserTable curr_userTable = userTableDAO.getUserTableById(userid);
		curr_userTable.setRole("ROLE_ADMIN");
		userTableDAO.insertUserTable(curr_userTable);
		return new ResponseEntity<UserTable>(curr_userTable,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateAdminToUser/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateAdminToUser(@PathVariable("userid") int userid){
		UserTable curr_userTable = userTableDAO.getUserTableById(userid);
		curr_userTable.setRole("ROLE_USER");
		userTableDAO.insertUserTable(curr_userTable);
		return new ResponseEntity<UserTable>(curr_userTable,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUserStatusToOnline/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateUserTableToOnline(@PathVariable("userid") int userid){
		UserTable curr_userTable = userTableDAO.getUserTableById(userid);
		curr_userTable.setIsonline("true");
		userTableDAO.insertUserTable(curr_userTable);
		return new ResponseEntity<UserTable>(curr_userTable,HttpStatus.OK);
	}
	@RequestMapping(value="/updateUserStatusToOffline/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateUserTableToOffline(@PathVariable("userid") int userid){
		UserTable curr_userTable = userTableDAO.getUserTableById(userid);
		curr_userTable.setIsonline("false");
		userTableDAO.insertUserTable(curr_userTable);
		return new ResponseEntity<UserTable>(curr_userTable,HttpStatus.OK);
	}
	@RequestMapping(value="/approveUser/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<UserTable> approveUser(@PathVariable("userid") int userid){
		UserTable curr_userTable = userTableDAO.getUserTableById(userid);
		curr_userTable.setStatus("A");
		userTableDAO.insertUserTable(curr_userTable);
		return new ResponseEntity<UserTable>(curr_userTable,HttpStatus.OK);
	}
	
	
	
}
