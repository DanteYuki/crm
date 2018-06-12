package com.xykj.business.entity.campus;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Campus")
public class Campus extends BaseEntity{
	private String id;
	private String campusName;
	private String cityId;
	private String campusLocation;
	private String manager;
	private String mobile;
	private String email;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getCampusLocation() {
		return campusLocation;
	}
	public void setCampusLocation(String campusLocation) {
		this.campusLocation = campusLocation;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
