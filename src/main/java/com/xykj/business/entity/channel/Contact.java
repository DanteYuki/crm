package com.xykj.business.entity.channel;

import org.apache.ibatis.type.Alias;

@Alias("Contact")
public class Contact {
	private int id;					//id
	private String contactName;		//联系人
	private String mobile;			//联系电话
	private String schoolId;		//学校id
	private String post;			//学校担任职务
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	
}
