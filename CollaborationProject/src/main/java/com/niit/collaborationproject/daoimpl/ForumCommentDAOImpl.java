package com.niit.collaborationproject.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.ForumCommentDAO;
import com.niit.collaborationproject.model.ForumComment;

@Repository("ForumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public ForumCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean insertForumComment(ForumComment forumComment) {
		try {
			getCurrentSession().saveOrUpdate(forumComment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
