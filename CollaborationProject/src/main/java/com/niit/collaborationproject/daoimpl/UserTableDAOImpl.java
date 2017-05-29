package com.niit.collaborationproject.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.UserTableDAO;
import com.niit.collaborationproject.model.UserTable;

@Repository("userTableDAO")
@Transactional
public class UserTableDAOImpl implements UserTableDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserTableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertUserTable(UserTable userTable) {
		
		try {
			getCurrentSession().saveOrUpdate(userTable);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
