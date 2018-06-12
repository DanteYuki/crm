package com.xykj.business.entity.channel;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.xykj.base.entity.BaseEntity;

@Alias("School")
public class School extends BaseEntity{
	private String id;
	private String schoolName;		//渠道名称
	private String address;			//校园地址
	private int fee;				//提成金额
	private List<Contact> contacts;	//渠道对接人
	private String remark;			//备注
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;		//创建时间
	private String createBy;		//创建人
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
