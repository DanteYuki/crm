package com.xykj.business.entity.financial;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Allowance")
public class Allowance extends BaseEntity{
	private String id;		
	private String cityId;			//城市
	private String campusId;		//校园
	private String classId;			//班级
	private int amount;				//补贴金额
	private String grantTime;		//发放时间
	private String grantType;		//发放方式
	private String granter;			//发放人
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCampusId() {
		return campusId;
	}
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getGrantTime() {
		return grantTime;
	}
	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getGranter() {
		return granter;
	}
	public void setGranter(String granter) {
		this.granter = granter;
	}
	
}
