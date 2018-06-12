package com.xykj.business.entity.classManage;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("ClassStudent")
public class ClassStudent extends BaseEntity{
	private String id;
	private String name;
	private int gender;
	private int age;
	private String mobile;
	private String qq;
	private String wx;
	private String education;
	private String remark;
	private String classId;
	private int credit;
	private String socialId;
	private String reputationId;
	private String channelId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getSocialId() {
		return socialId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public String getReputationId() {
		return reputationId;
	}
	public void setReputationId(String reputationId) {
		this.reputationId = reputationId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
}
