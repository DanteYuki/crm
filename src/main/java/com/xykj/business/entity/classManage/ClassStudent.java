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
	private int education;
	private String remark;
	private String classId;
	private int credit;
	private String socialId;
	private String reputationId;
	private String channelId;
	private int status;
	private String campusId;
	private String advisorFeedback;
	private double firstScore;
	private double secondScore;
	private double thirdScore;
	private String firstInterviewRemark;
	private double firstInterviewScore;
	private String secondInterviewRemark;
	private double secondInterviewScore;
	public String getFirstInterviewRemark() {
		return firstInterviewRemark;
	}
	public void setFirstInterviewRemark(String firstInterviewRemark) {
		this.firstInterviewRemark = firstInterviewRemark;
	}
	public double getFirstInterviewScore() {
		return firstInterviewScore;
	}
	public void setFirstInterviewScore(double firstInterviewScore) {
		this.firstInterviewScore = firstInterviewScore;
	}
	public String getSecondInterviewRemark() {
		return secondInterviewRemark;
	}
	public void setSecondInterviewRemark(String secondInterviewRemark) {
		this.secondInterviewRemark = secondInterviewRemark;
	}
	public double getSecondInterviewScore() {
		return secondInterviewScore;
	}
	public void setSecondInterviewScore(double secondInterviewScore) {
		this.secondInterviewScore = secondInterviewScore;
	}
	public double getFirstScore() {
		return firstScore;
	}
	public void setFirstScore(double firstScore) {
		this.firstScore = firstScore;
	}
	public double getSecondScore() {
		return secondScore;
	}
	public void setSecondScore(double secondScore) {
		this.secondScore = secondScore;
	}
	public double getThirdScore() {
		return thirdScore;
	}
	public void setThirdScore(double thirdScore) {
		this.thirdScore = thirdScore;
	}
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
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCampusId() {
		return campusId;
	}
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}
	public String getAdvisorFeedback() {
		return advisorFeedback;
	}
	public void setAdvisorFeedback(String advisorFeedback) {
		this.advisorFeedback = advisorFeedback;
	}
	
}
