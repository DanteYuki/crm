package com.xykj.base.entity.sys.permission;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Permission")
public class Permission extends BaseEntity{
	private String permissionId;
	private String permissionName;
	private int permissionType;
	private String permissionUrl;
	private String parentId;
	private int status;
	private String sortNumber;
	private String description;
	private int plevel;
	public int getPlevel() {
		return plevel;
	}
	public void setPlevel(int plevel) {
		this.plevel = plevel;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public int getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(int permissionType) {
		this.permissionType = permissionType;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(String sortNumber) {
		this.sortNumber = sortNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionType="
				+ permissionType + ", permissionUrl=" + permissionUrl + ", parentId=" + parentId + ", status=" + status
				+ ", sortNumber=" + sortNumber + ", description=" + description + ", plevel=" + plevel + "]";
	}
	
}
