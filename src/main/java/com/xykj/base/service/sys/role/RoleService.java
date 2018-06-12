package com.xykj.base.service.sys.role;

import java.util.List;

import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.service.BaseService;

public interface RoleService extends BaseService<Role>{
	public List<Permission> getPermissions(Role role);
	
	public void insertRolePermission(Role role,String permissions);
	
	public void updateRole(Role role,String permissionIds);
	
	public List<Role> findAllRoles();
}
