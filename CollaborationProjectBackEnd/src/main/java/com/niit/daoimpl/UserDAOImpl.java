package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	private static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(User user) {
		log.debug("---> Starting of User Save method");

		try {
			getCurrentSession().save(user);
		} catch (Exception e) {
			log.debug("---> Exception arised in User Save method");
			e.printStackTrace();
			return false;
		}

		log.debug("---> Ending of User Save method");
		return true;
	}

	public boolean update(User user) {
		log.debug("---> Starting of User update method");

		try {
			getCurrentSession().update(user);
		} catch (Exception e) {
			log.debug("---> Exception arised in User update method");
			e.printStackTrace();
			return false;
		}

		log.debug("---> Ending of User update method");
		return true;
	}

	public boolean delete(String userId) {
		log.debug("---> Starting of User delete method");

		try {
			getCurrentSession().delete(getUserById(userId));
		} catch (Exception e) {
			log.debug("---> Exception arised in User delete method");
			e.printStackTrace();
			return false;
		}

		log.debug("---> Ending of User delete method");
		return true;
	}

	public User getUserById(String userId) {
		log.debug("---> Starting of getUserById method");
		return (User) getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userId", userId))
				.uniqueResult();
	}

	public List<User> list() {
		log.debug("---> Starting of list method in User");
		return getCurrentSession().createCriteria(User.class).list();
	}
	
	public List<User> list(String status) {
		log.debug("---> Starting of list by status method in User");
		return getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("status", status))
				.list();
	}

	public User validate(String userId, String password) {
		log.debug("---> Starting of method User Validate");
		return (User) getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userId", userId))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
		

	}
	
	public void setOnline(String userId) {
		getCurrentSession().createQuery("UPDATE User SET isOnline = 'Y' where userId = ?").setString(0, userId).executeUpdate();
	}

	public void setOffline(String userId) {
		getCurrentSession().createQuery("UPDATE User SET isOnline = 'N' where userId = ?").setString(0, userId).executeUpdate();
		}


	public List<User> notMyFriendList(String userId) {
		String hql = "FROM USER WHERE userId NOT IN (SELECT friendId FROM CFRIEND WHERE userId='" + userId
				+ "' OR friendId='" + userId + "'";
		log.debug("Query : "+hql);
		return getCurrentSession().createQuery(hql).list();

	}

	
}
