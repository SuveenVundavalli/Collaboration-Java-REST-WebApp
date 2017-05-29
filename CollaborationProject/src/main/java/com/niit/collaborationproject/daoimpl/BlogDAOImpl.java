package com.niit.collaborationproject.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.BlogDAO;
import com.niit.collaborationproject.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertBlog(Blog blog) {
		
		try {
			getCurrentSession().saveOrUpdate(blog);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
