package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.ForumCommentDAO;
import com.niit.collaborationproject.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(ForumCommentDAOImpl.class);
	
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

	@Override
	public boolean deleteForumComment(int id) {
		try {
			getCurrentSession().delete(getForumCommentById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ForumComment getForumCommentById(int id) {
		return (ForumComment) getCurrentSession().get(ForumComment.class, id);
	}

	@Override
	public List<ForumComment> list() {
		return getCurrentSession().createQuery("from ForumComment").list();
		}

	@Override
	public List<ForumComment> getAllCommentsByForumId(int forumid) {
		log.debug("Starting of method getAllComments in Forum Comment");
		log.debug("Ending of method getAllComments in Forum Comment");
		return getCurrentSession().createQuery("from ForumComment where forumid = ?").setInteger(0, forumid).list();
	}

}
