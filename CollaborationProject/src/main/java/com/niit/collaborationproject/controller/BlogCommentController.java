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

import com.niit.collaborationproject.dao.BlogCommentDAO;
import com.niit.collaborationproject.model.BlogComment;

@RestController
public class BlogCommentController {
	
	@Autowired
	BlogComment blogComment;
	
	@Autowired
	BlogCommentDAO blogCommentDAO;

	@RequestMapping(value = "/getBlogComments", method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getAllBlogComments(){
		List<BlogComment> listBlogComment = blogCommentDAO.list();
		return new ResponseEntity<List<BlogComment>>(listBlogComment,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertBlogComment", method = RequestMethod.POST)
	public ResponseEntity<String> insertBlog(@RequestBody BlogComment blogComment){
		blogComment.setUserid(3);
		blogComment.setUsername("user");
		blogComment.setCommentdate(new Date());
		if (blogCommentDAO.insertBlogComment(blogComment)) {
			return new ResponseEntity<String>("Successfully Inserted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to Insert",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteBlogComment/{blogcommentid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> addBlogComment(@PathVariable("blogcommentid") int blogcommentid){
	
		blogCommentDAO.deleteBlogComment(blogcommentid);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateBlogComment/{blogcommentid}", method=RequestMethod.PUT)
	public ResponseEntity<BlogComment> updateBlogComment(@PathVariable("blogcommentid") int blogcommentid, @RequestBody BlogComment blogComment){
		BlogComment curr_blogComment = blogCommentDAO.getBlogCommentById(blogcommentid);
		curr_blogComment.setBlogcomment(blogComment.getBlogcomment());
		blogCommentDAO.insertBlogComment(curr_blogComment);
		return new ResponseEntity<BlogComment>(curr_blogComment,HttpStatus.OK);
	}
	
	
}
