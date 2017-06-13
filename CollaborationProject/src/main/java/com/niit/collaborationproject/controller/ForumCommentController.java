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

import com.niit.collaborationproject.dao.ForumCommentDAO;
import com.niit.collaborationproject.model.ForumComment;

@RestController
public class ForumCommentController {
	
	@Autowired
	ForumComment forumComment;
	
	@Autowired
	ForumCommentDAO forumCommentDAO;

	@RequestMapping(value = "/getForumComments", method = RequestMethod.GET)
	public ResponseEntity<List<ForumComment>> getAllForumComments(){
		List<ForumComment> listForumComment = forumCommentDAO.list();
		return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertForumComment", method = RequestMethod.POST)
	public ResponseEntity<String> insertForum(@RequestBody ForumComment forumComment){
		forumComment.setUserid(1);
		forumComment.setUsername("Suveen");
		forumComment.setCommentdate(new Date());
		if (forumCommentDAO.insertForumComment(forumComment)) {
			return new ResponseEntity<String>("Successfully Inserted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to Insert",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteForumComment/{forumcommentid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> addForumComment(@PathVariable("forumcommentid") int forumcommentid){
	
		forumCommentDAO.deleteForumComment(forumcommentid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateForumComment/{forumcommentid}", method=RequestMethod.PUT)
	public ResponseEntity<ForumComment> updateForumComment(@PathVariable("forumcommentid") int forumcommentid, @RequestBody ForumComment forumComment){
		ForumComment curr_forumComment = forumCommentDAO.getForumCommentById(forumcommentid);
		curr_forumComment.setForumcomment(forumComment.getForumcomment());
		forumCommentDAO.insertForumComment(curr_forumComment);
		return new ResponseEntity<ForumComment>(curr_forumComment,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllCommentsByForumId/{forumid}", method = RequestMethod.GET)
	public ResponseEntity<List<ForumComment>> getAllForumComments(@PathVariable("forumid") int forumid){
		List<ForumComment> getAllCommentsByForumId = forumCommentDAO.getAllCommentsByForumId(forumid);
		return new ResponseEntity<List<ForumComment>>(getAllCommentsByForumId,HttpStatus.OK);
	}
	
	
}
