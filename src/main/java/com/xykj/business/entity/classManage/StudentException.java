package com.xykj.business.entity.classManage;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("StudentException")
public class StudentException extends BaseEntity{
	private int id;
	private String studentId;
	private int etype;
	private String cause;
	private String remark;
	private String classBefore;
	private String classAfter;
	private String operator;
	private String eTime;
	private String dTime;
	private int currentScore;
	private int change;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getEtype() {
		return etype;
	}
	public void setEtype(int etype) {
		this.etype = etype;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClassBefore() {
		return classBefore;
	}
	public void setClassBefore(String classBefore) {
		this.classBefore = classBefore;
	}
	public String getClassAfter() {
		return classAfter;
	}
	public void setClassAfter(String classAfter) {
		this.classAfter = classAfter;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
}
