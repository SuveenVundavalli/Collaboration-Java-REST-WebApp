package com.niit.collaborationproject.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.JobDAO;
import com.niit.collaborationproject.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertJob(Job job) {
		
		try {
			getCurrentSession().saveOrUpdate(job);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}