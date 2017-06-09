package com.niit.collaborationproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int forumcommentid;
	private int userid, forumid;
	private String username, forumcomment;
	private Date commentdate;
	
	public int getForumcommentid() {
		return forumcommentid;
	}
	public void setForumcommentid(int forumcommentid) {
		this.forumcommentid = forumcommentid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getForumcomment() {
		return forumcomment;
	}
	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	
	
}
