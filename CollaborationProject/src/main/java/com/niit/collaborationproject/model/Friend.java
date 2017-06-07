package com.niit.collaborationproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Friend {
	
	@Id
	private int tableid;
	private int userid;
	private int friendid;
	private String status;
	
	
	
	public int getTableid() {
		return tableid;
	}
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
