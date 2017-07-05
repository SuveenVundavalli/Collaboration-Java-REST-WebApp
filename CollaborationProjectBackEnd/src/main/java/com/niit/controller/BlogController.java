package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

//@RestController
public class BlogController {
	
	@Autowired BlogDAO blogDAO;
	@Autowired HttpSession session;
	
	@GetMapping("/getBlogs")
	public List<Blog> getBlogs(){
		
		return blogDAO.list("A");
	}
	
	@PostMapping("/insertBlog")
	public Blog insertBlog(@RequestBody Blog blog){
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		blog.setBlogId(getMaxId()+1);
		blog.setCreateDate(new Date(System.currentTimeMillis()));
		blog.setLikes(0);
		blog.setStatus("NA");
		blog.setUserId(loggedInUserId);
		if(loggedInUserId == null){
			blog.setErrorCode("404");
			blog.setErrorMessage("Please Login to Continue!");
			return blog;
		}
		else{
			if (blogDAO.save(blog)) {
				blog.setErrorCode("200");
				blog.setErrorMessage("Successfully Saved Blog");
				return blog;
			} else {
				blog.setErrorCode("404");
				blog.setErrorMessage("Failed to save Blog");
				return blog;
			}
		}
	}
	
	@PutMapping("/updateBlog/{blogId}")
	public Blog updateBlog(@PathVariable int blogId, @RequestBody Blog blog){
		Blog actualBlog = blogDAO.getBlogById(blogId);
		actualBlog.setBlogName(blog.getBlogName());
		actualBlog.setBlogContent(blog.getBlogContent());
		actualBlog.setStatus("NA");
		if(blogDAO.update(actualBlog)){
			actualBlog.setErrorCode("200");
			actualBlog.setErrorMessage("Update successfull!");
		} else {
			actualBlog.setErrorCode("404");
			actualBlog.setErrorMessage("Update failed! Please try again.");
		}
		return actualBlog;
	}
	
	@DeleteMapping("/deleteBlog/{blogId}")
	public String deleteBlog(@PathVariable int blogId){
		if(blogDAO.delete(blogId)){
			return "Delete blog successfull";
		} else {
			return "Delete blog failed";
		}
	}
	
	@PutMapping("/approveBlog/{blogId}")
	public Blog approveBlog(@PathVariable int blogId){
		Blog blog = blogDAO.getBlogById(blogId);
		if(changeStatus(blog, "A")){
			blog.setErrorCode("200");
			blog.setErrorMessage("Blog Approved Successfully!");
		} else {
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Approve Failed!");
		}
		
		return blog;
		
	}
	
	@PutMapping("/rejectBlog/{blogId}")
	public Blog rejectBlog(@PathVariable int blogId){
		Blog blog = blogDAO.getBlogById(blogId);
		if(changeStatus(blog, "R")){
			blog.setErrorCode("200");
			blog.setErrorMessage("Blog Rejected Successfully!");
		} else {
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Rejection Failed!");

		}
		return blog;
		
	}
	
	private boolean changeStatus(Blog blog, String status){
		blog.setStatus(status);
		return blogDAO.update(blog);
	}
	
	private int getMaxId(){
		return blogDAO.getMaxBlogId();
	}
}
