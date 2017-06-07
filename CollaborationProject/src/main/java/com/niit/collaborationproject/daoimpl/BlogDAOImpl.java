package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.BlogDAO;
import com.niit.collaborationproject.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);

	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertBlog(Blog blog) {
		log.debug("Starting of method insertBlog");
		try {
			getCurrentSession().saveOrUpdate(blog);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method insertBlog");
		return true;
	}

	@Override
	public boolean deleteBlog(int id) {
		log.debug("Starting of method deleteBlog");
		try {
			getCurrentSession().delete(getBlogById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method deleteBlog");
		return true;
	}

	@Override
	public Blog getBlogById(int id) {
		log.debug("In method getBlogById");
		return (Blog) getCurrentSession().get(Blog.class, id);
	}

	@Override
	public List<Blog> list() {
		log.debug("In method list");
		return getCurrentSession().createQuery("from Blog").list();
	}

}
