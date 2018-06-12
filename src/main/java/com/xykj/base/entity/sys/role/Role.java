package com.xykj.base.entity.sys.role;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Role")
public class Role extends BaseEntity{
	private String roleId;		//角色id
	private String roleName;	//角色名称
	private int status;			//角色状态
	private String description; //角色描述
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
