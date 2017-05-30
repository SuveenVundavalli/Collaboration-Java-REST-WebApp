package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.Forum;

public interface ForumDAO {

	public boolean insertForum(Forum forum);
	
	public boolean deleteForum(int id);
	public Forum getForumById(int id);
	public List<Forum> list();
}
