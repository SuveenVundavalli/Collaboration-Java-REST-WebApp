package com.niit.collaborationproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum {
	 
		@Id
		private int forumid;
		private int userid;
		private String forumname, forumcontent;
		private Date createdate;
		
		public int getForumid() {
			return forumid;
		}
		public void setForumid(int forumid) {
			this.forumid = forumid;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getForumname() {
			return forumname;
		}
		public void setForumname(String forumname) {
			this.forumname = forumname;
		}
		public String getForumcontent() {
			return forumcontent;
		}
		public void setForumcontent(String forumcontent) {
			this.forumcontent = forumcontent;
		}
		public Date getCreatedate() {
			return createdate;
		}
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}


}
