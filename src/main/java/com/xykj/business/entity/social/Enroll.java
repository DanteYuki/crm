package com.xykj.business.entity.social;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

/**
 * 上门信息登记
 * @author dante
 * @2018年5月29日
 */
@Alias("Enroll")
public class Enroll extends BaseEntity{
	private String id;				//id
	private String sname;			//上门人姓名
	private int sage;				//上门人年龄
	private String sgender;			//性别 0女 1男
	private String mobile;			//上门人联系方式
	private String email;			//上门人邮箱
	private String qq;				//上门人QQ
	private String wx;				//上门人微信
	/**
	 * yyyy-MM-dd
	 */
	private String arriveTime;		//上门时间
	private int education;		//上门人学历   1.高中 2.大专 3.本科 4.研究生 5.博士 6.其他---基于配置
	private String graduateYear;	//毕业年限
	private String graduateFrom;	//毕业学校
	private String address;			//地址
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private String createTime;		//创建时间
	private String createBy;		//创建人
	private String advisor;			//咨询师
	private String source;			//简历来源---基于配置管理
	private String grade;			//评判等级---基于配置管理
	private String job;				//面试岗位---基于配置管理
	private String invitor;			//邀约人
	private String teacher;			//视听老师
	private String feedback;		//咨询反馈
	private int status;				//上门人状态	1.2天之内关单  2.1周之内关单 3.长期跟单 4.无效量 5.已关单
	private int isTry;				//是否已经参与试学   1.是  0.否
	private int isPay;				//是否已报名       1.是  0.否
	private String backgroundInfo;	//背景信息
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}
	public String getGraduateFrom() {
		return graduateFrom;
	}
	public void setGraduateFrom(String graduateFrom) {
		this.graduateFrom = graduateFrom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInvitor() {
		return invitor;
	}
	public void setInvitor(String invitor) {
		this.invitor = invitor;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsTry() {
		return isTry;
	}
	public void setIsTry(int isTry) {
		this.isTry = isTry;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public String getBackgroundInfo() {
		return backgroundInfo;
	}
	public void setBackgroundInfo(String backgroundInfo) {
		this.backgroundInfo = backgroundInfo;
	}
}
