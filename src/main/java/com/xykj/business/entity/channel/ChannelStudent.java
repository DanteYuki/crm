package com.xykj.business.entity.channel;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.xykj.base.entity.BaseEntity;

@Alias("ChannelStudent")
public class ChannelStudent extends BaseEntity{
	private String id;
	private String sname;			//姓名
	private int sage;				//年龄
	private String sgender;			//性别
	private String schoolName;		//学校
	private String education;		//就读学历   1.高中 2.大专 3.本科 4.研究生 5.博士 6.其他---基于配置
	private String mobile;			//移动电话
	private String email;			//电子邮箱
	private String qq;				//QQ号
	private String wx;				//微信号
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;		//报名时间
	private String createBy;		//创建人
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
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	
	
}
