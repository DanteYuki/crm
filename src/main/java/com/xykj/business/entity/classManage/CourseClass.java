package com.xykj.business.entity.classManage;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.xykj.base.entity.BaseEntity;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.entity.campus.City;

@Alias("CourseClass")
public class CourseClass extends BaseEntity{
	private String id;
	private City city;					//城市
	private Campus campus;				//校区
	private String className;			//班级名
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date assistTime;			//辅导时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date prepareTime;			//预科时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date openTime;				//开班时间
	private int planCount;				//计划人数
	private int realCount;				//实际开班人数
	private String headTeacher;			//班主任
	private String courseTeacher;		//任课老师
	private String subject;				//科目
	private String description;			//其他描述
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getAssistTime() {
		return assistTime;
	}
	public void setAssistTime(Date assistTime) {
		this.assistTime = assistTime;
	}
	public Date getPrepareTime() {
		return prepareTime;
	}
	public void setPrepareTime(Date prepareTime) {
		this.prepareTime = prepareTime;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public int getPlanCount() {
		return planCount;
	}
	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	public int getRealCount() {
		return realCount;
	}
	public void setRealCount(int realCount) {
		this.realCount = realCount;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
