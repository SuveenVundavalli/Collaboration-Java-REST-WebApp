package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
	
	@Override
	public boolean deleteUserTable(int id) {
		try {
			getCurrentSession().delete(getUserTableById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserTable getUserTableById(int id) {
		return (UserTable) getCurrentSession().get(UserTable.class, id);
	}

	@Override
	public List<UserTable> list() {
		return getCurrentSession().createQuery("from UserTable").list();
	}

	@Override
	public boolean validate(String email, String password) {
		Query query=	 sessionFactory.getCurrentSession().createQuery("from UserTable where email = ? and password = ?");
		query.setString(0, email);     //actually the index will start from zero  - will get once exception.
		query.setString(1, password);
		
		 if(  query.uniqueResult()  == null)
		 {
			 //means no row exist i.e., invalid credentials
			 return false;
		 }
		 else
		 {
			 //means row exist i.e., valid credentials
			 return true;
		 }
	}


}
