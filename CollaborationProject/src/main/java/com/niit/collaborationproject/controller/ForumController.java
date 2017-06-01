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

import com.niit.collaborationproject.dao.ForumDAO;
import com.niit.collaborationproject.model.Forum;

@RestController
public class ForumController {

	@Autowired ForumDAO forumDAO;
	
	//@Autowired Forum forum;
	
	@RequestMapping(value="/getForums", method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> getAllForums(){
		
		List<Forum> listforums = forumDAO.list();
		
		return new ResponseEntity<List<Forum>>(listforums, HttpStatus.OK);
	}
	
	//Create Forum
	@RequestMapping(value="/insertForum", method=RequestMethod.POST)
	public ResponseEntity<String> addForum(@RequestBody Forum forum){
		
		forum.setUserid(2);
		forum.setCreatedate(new Date());
		forumDAO.insertForum(forum);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteForum/{forumid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> addForum(@PathVariable("forumid") int forumid){
	
		forumDAO.deleteForum(forumid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateForum/{forumid}", method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@PathVariable("forumid") int forumid, @RequestBody Forum forum){
		Forum curr_forum = forumDAO.getForumById(forumid);
		curr_forum.setForumcontent(forum.getForumcontent());
		forumDAO.insertForum(curr_forum);
		return new ResponseEntity<Forum>(curr_forum,HttpStatus.OK);
	}
	
	/*
	@RequestMapping(value="/approveForum/{forumid}", method=RequestMethod.PUT)
	public ResponseEntity<Forum> approveForum(@PathVariable("forumid") int forumid){
		Forum forum = forumDAO.getForumById(forumid);
		forum.setStatus("A");
		forumDAO.insertForum(forum);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	*/
	
	
	
}
