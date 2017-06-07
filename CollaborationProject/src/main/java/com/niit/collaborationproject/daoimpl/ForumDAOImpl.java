package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.ForumDAO;
import com.niit.collaborationproject.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertForum(Forum forum) {
		
		try {
			getCurrentSession().saveOrUpdate(forum);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteForum(int id) {
		
		try {
			getCurrentSession().delete(getForumById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Forum getForumById(int id) {
		
		return (Forum) getCurrentSession().get(Forum.class, id);
	}

	@Override
	public List<Forum> list() {
		return getCurrentSession().createQuery("from Forum").list();
		}


}
