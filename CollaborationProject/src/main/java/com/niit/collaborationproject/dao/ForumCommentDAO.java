package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.ForumComment;

public interface ForumCommentDAO {

	public boolean insertForumComment(ForumComment forumComment);
	
	public boolean deleteForumComment(int id);
	public ForumComment getForumCommentById(int id);
	public List<ForumComment> list();
	public List<ForumComment> getAllCommentsByForumId(int forumid);
}
