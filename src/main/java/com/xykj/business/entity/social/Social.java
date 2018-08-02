package com.xykj.business.entity.social;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

/**
 * 上门信息登记
 * @author dante
 * @2018年5月29日
 */
@Alias("Social")
public class Social extends BaseEntity{
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
	private int graduateYear;	//毕业年限
	private String graduateFrom;	//毕业学校
	private String address;			//地址
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private String createTime;		//创建时间
	private String createBy;		//创建人
	private String advisor;			//咨询师
	private int source;				//简历来源---基于配置管理
	private int grade;				//评判等级---基于配置管理
	private int job;				//面试岗位---基于配置管理
	private String invitor;			//邀约人
	private String teacher;			//视听老师
	private String feedback;		//咨询反馈
	private int status;				//上门人状态	1.2天之内关单  2.1周之内关单 3.长期跟单 4.无效量 5.已关单
	private int isTry;				//是否已经参与试学   1.是  0.否
	private int isPay;				//是否已报名       1.是  0.否
	private String updateBy;		//操作者
	private String updateTime;		//操作时间
	private String campusId;		//上门校区ID
	private String tryTime;			//试学时间 
	private String enrollTime;		//报名时间
	private int signal;				//标志
	private String tryLearnFeedback;	//咨询师反馈
	
	public String getTryTime() {
		return tryTime;
	}
	public void setTryTime(String tryTime) {
		this.tryTime = tryTime;
	}
	public String getEnrollTime() {
		return enrollTime;
	}
	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
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
	public int getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(int graduateYear) {
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
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
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
	@Override
	public String toString() {
		return "Social [id=" + id + ", sname=" + sname + ", sage=" + sage + ", sgender=" + sgender + ", mobile="
				+ mobile + ", email=" + email + ", qq=" + qq + ", wx=" + wx + ", arriveTime=" + arriveTime
				+ ", education=" + education + ", graduateYear=" + graduateYear + ", graduateFrom=" + graduateFrom
				+ ", address=" + address + ", createTime=" + createTime + ", createBy=" + createBy + ", advisor="
				+ advisor + ", source=" + source + ", grade=" + grade + ", job=" + job + ", invitor=" + invitor
				+ ", teacher=" + teacher + ", feedback=" + feedback + ", status=" + status + ", isTry=" + isTry
				+ ", isPay=" + isPay + ", toString()=" + super.toString() + "]";
	}
	public String getCampusId() {
		return campusId;
	}
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}
	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	public String getTryLearnFeedback() {
		return tryLearnFeedback;
	}
	public void setTryLearnFeedback(String tryLearnFeedback) {
		this.tryLearnFeedback = tryLearnFeedback;
	}
}
