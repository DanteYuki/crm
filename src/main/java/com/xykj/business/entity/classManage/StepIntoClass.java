package com.xykj.business.entity.classManage;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("StepIntoClass")
public class StepIntoClass extends BaseEntity{
	private String id;
	private String name;
	private int gender;
	private String cityId;
	private String campusId;
	private String advisor;
	private String backgroundInfo;
	private String education;
	private int age;
	private String classId;
	private String headTeacher;
	private String courseTeacher;
	private String fbFromCT;
	private String fbFromHT;
	
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
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public String getBackgroundInfo() {
		return backgroundInfo;
	}
	public void setBackgroundInfo(String backgroundInfo) {
		this.backgroundInfo = backgroundInfo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getHeadTeacher() {
		return headTeacher;
	}
	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getFbFromCT() {
		return fbFromCT;
	}
	public void setFbFromCT(String fbFromCT) {
		this.fbFromCT = fbFromCT;
	}
	public String getFbFromHT() {
		return fbFromHT;
	}
	public void setFbFromHT(String fbFromHT) {
		this.fbFromHT = fbFromHT;
	}
	
}
