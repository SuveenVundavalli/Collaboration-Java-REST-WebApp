package com.niit.collaborationproject.dao;

import java.util.List;

import com.niit.collaborationproject.model.UserTable;

public interface UserTableDAO {

	public boolean insertUserTable(UserTable userTable);

	public boolean deleteUserTable(int id);
	public UserTable getUserTableById(int id);
	public List<UserTable> list();
	
	public boolean validate(String email, String password);
}
