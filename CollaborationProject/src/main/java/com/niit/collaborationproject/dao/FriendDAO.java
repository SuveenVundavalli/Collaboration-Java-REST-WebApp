package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.Friend;

public interface FriendDAO {

	public boolean insertFriend(Friend friend);
	
	public boolean deleteFriend(int tableid);
	public Friend getFriendById(int tableid);
	
	/*
	public boolean deleteFriend(int userid, int friendid);
	public Friend getFriendById(int userid, int friendid);
	 */
	
	public List<Friend> list();
}
