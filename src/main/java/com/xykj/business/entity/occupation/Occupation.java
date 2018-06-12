package com.xykj.business.entity.occupation;

import com.xykj.base.entity.BaseEntity;

public class Occupation extends BaseEntity{
	private String id;
	private String realName;			//学员名称 
	private String nickName;			//学员昵称
	private int age;					//年龄
	private String graduateFrom;		//毕业学校
	private String graduateYear;		//毕业年限
	private String major;				//专业
	private String mobile;				//电话
	private String qq;					//QQ
	private String wx;					//微信
	private String offer;				//就职企业
	private int salary;					//薪资
	private String speech;				//就职感言
	private String vedio;				//视频
	private String remark;				//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGraduateFrom() {
		return graduateFrom;
	}
	public void setGraduateFrom(String graduateFrom) {
		this.graduateFrom = graduateFrom;
	}
	public String getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getVedio() {
		return vedio;
	}
	public void setVedio(String vedio) {
		this.vedio = vedio;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
