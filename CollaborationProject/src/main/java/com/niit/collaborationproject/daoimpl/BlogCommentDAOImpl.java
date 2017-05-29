package com.niit.collaborationproject.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.BlogCommentDAO;
import com.niit.collaborationproject.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean insertBlogComment(BlogComment blogComment) {
		try {
			getCurrentSession().saveOrUpdate(blogComment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
