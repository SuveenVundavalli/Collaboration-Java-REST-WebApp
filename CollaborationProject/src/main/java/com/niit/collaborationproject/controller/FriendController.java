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

import com.niit.collaborationproject.dao.FriendDAO;
import com.niit.collaborationproject.model.Friend;

@RestController
public class FriendController {

	@Autowired FriendDAO friendDAO;
	
	//@Autowired Friend friend;
	
	@RequestMapping(value="/getFriends", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getAllFriends(){
		
		List<Friend> listfriends = friendDAO.list();
		
		return new ResponseEntity<List<Friend>>(listfriends, HttpStatus.OK);
	}
	
	//Create Friend
	@RequestMapping(value="/insertFriend", method=RequestMethod.POST)
	public ResponseEntity<String> addFriend(@RequestBody Friend friend){
		
		friend.setStatus("NA");
		friendDAO.insertFriend(friend);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteFriend/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> addFriend(@PathVariable("userid") int userid){
	
		friendDAO.deleteFriend(userid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateFriendStatus/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<Friend> approveFriend(@PathVariable("userid") int userid){
		Friend friend = friendDAO.getFriendById(userid);
		friend.setStatus("A");
		friendDAO.insertFriend(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	/*
	 @RequestMapping(value="/deleteFriend/{userid,friendid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> addFriend(@PathVariable("userid") int userid, @PathVariable("friendid") int friendid){
	
		friendDAO.deleteFriend(userid, friendid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateStatus/{userid,friendid}", method=RequestMethod.PUT)
	public ResponseEntity<Friend> approveFriend(@PathVariable("userid") int userid, @PathVariable("friendid") int friendid){
		Friend friend = friendDAO.getFriendById(userid, friendid);
		friend.setStatus("A");
		friendDAO.insertFriend(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	 */
	
	
	
	
}
