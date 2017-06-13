package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.BlogCommentDAO;
import com.niit.collaborationproject.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(BlogCommentDAOImpl.class);
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean insertBlogComment(BlogComment blogComment) {
		log.debug("Starting of method insertBlogComment");
		try {
			getCurrentSession().saveOrUpdate(blogComment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method insertBlogComment");
		return true;
	}
	
	@Override
	public boolean deleteBlogComment(int id) {
		log.debug("Starting of method deleteBlogComment");
		try {
			getCurrentSession().delete(getBlogCommentById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of method deleteBlogComment");
		return true;
	}

	@Override
	public BlogComment getBlogCommentById(int id) {
		log.debug("Starting of method getBlogCommentById");
		log.debug("Ending of method getBlogCommentById");
		return (BlogComment) getCurrentSession().get(BlogComment.class, id);
	}

	@Override
	public List<BlogComment> list() {
		log.debug("Starting of method list in Blog Comment");
		log.debug("Ending of method list in Blog Comment");
		return getCurrentSession().createQuery("from BlogComment").list();
	}

	@Override
	public List<BlogComment> getAllCommentsByBlogId(int blogid) {
		log.debug("Starting of method getAllComments in Blog Comment");
		log.debug("Ending of method getAllComments in Blog Comment");
		return getCurrentSession().createQuery("from BlogComment where blogid = ?").setInteger(0, blogid).list();
	}

}
