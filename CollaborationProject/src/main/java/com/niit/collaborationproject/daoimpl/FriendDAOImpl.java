package com.niit.collaborationproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationproject.dao.FriendDAO;
import com.niit.collaborationproject.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean insertFriend(Friend friend) {

		try {
			getCurrentSession().saveOrUpdate(friend);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteFriend(int userid) {
		try {
			getCurrentSession().delete(getFriendById(userid));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Friend getFriendById(int userid) {
		return (Friend) getCurrentSession().get(Friend.class, userid);
	}

	@Override
	public List<Friend> list() {
		return getCurrentSession().createQuery("from Friend").list();
	}
	
	/*
	 @Override
	public boolean deleteFriend(int userid, int friendid) {
		try {
			getCurrentSession().delete(getFriendById(userid, friendid));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Friend getFriendById(int userid, int friendid) {
		return (Friend) getCurrentSession().createQuery("from Friend where userid = ? and friendid = ?").setInteger(0, userid).setInteger(1, friendid).uniqueResult();
	}

	@Override
	public List<Friend> list() {
		return getCurrentSession().createQuery("from Friend").list();
	}
	 */

}
