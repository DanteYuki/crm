package com.xykj.business.entity.classManage;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Talk")
public class Talk extends BaseEntity{
	private int id;
	private ClassStudent student;
	private String headTeacher;
	private String content;
	private String talkTime;
	private String cause;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClassStudent getStudent() {
		return student;
	}
	public void setStudent(ClassStudent student) {
		this.student = student;
	}
	public String getHeadTeacher() {
		return headTeacher;
	}
	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(String talkTime) {
		this.talkTime = talkTime;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	
}
