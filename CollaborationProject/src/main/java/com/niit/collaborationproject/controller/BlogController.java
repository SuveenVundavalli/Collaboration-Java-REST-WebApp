package com.niit.collaborationproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationproject.dao.BlogDAO;
import com.niit.collaborationproject.model.Blog;

@RestController
public class BlogController {

	@Autowired BlogDAO blogDAO;
	
	@RequestMapping(value="/getBlogs", method=RequestMethod.GET)
	public ResponseEntity<List<Blog>> getAllBlogs(){
		
		List<Blog> listblogs = blogDAO.list();
		
		return new ResponseEntity<List<Blog>>(listblogs, HttpStatus.OK);
	}
}
