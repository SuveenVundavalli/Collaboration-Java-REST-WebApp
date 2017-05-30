package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.Blog;

public interface BlogDAO {

	public boolean insertBlog(Blog blog);
	public boolean deleteBlog(int id);
	public Blog getBlogById(int id);
	public List<Blog> list();
	
	
}
