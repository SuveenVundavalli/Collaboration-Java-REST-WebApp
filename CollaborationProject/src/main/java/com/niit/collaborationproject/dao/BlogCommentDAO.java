package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.BlogComment;

public interface BlogCommentDAO {

	public boolean insertBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(int id);
	public BlogComment getBlogCommentById(int id);
	public List<BlogComment> getAllCommentsByBlogId(int blogid);
	
	public List<BlogComment> list();
}
