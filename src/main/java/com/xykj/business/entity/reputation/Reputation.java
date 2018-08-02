package com.xykj.business.entity.reputation;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

/**
 * 口碑学员管理
 * @author dante
 * @2018年6月8日
 */
@Alias("Reputation")
public class Reputation extends BaseEntity{
	private String id;
	private String name;				//学员姓名
	private int age;					//年龄
	private int gender;					//性别
	private String mobile;				//移动电话
	private String email;				//电邮
	private String qq;					//QQ
	private String wx;					//微信
	private int status;					//状态
	private String subject;				//报名科目
	private int entryFee;				//报名费
	private int tuitionFee;				//学费
	private String advisor;				//咨询师
	private int recommonendFee;			//推荐费
	private String graduateFrom;		//毕业学校
	private int graduateYear;			//毕业年限
	private int education;				//学历
	private String createBy;			//创建人
	private Date createTime;			//创建时间
	private String remark;				//备注
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public int getRecommonendFee() {
		return recommonendFee;
	}
	public void setRecommonendFee(int recommonendFee) {
		this.recommonendFee = recommonendFee;
	}
	public String getGraduateFrom() {
		return graduateFrom;
	}
	public void setGraduateFrom(String graduateFrom) {
		this.graduateFrom = graduateFrom;
	}
	public int getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(int graduateYear) {
		this.graduateYear = graduateYear;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
