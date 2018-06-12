package com.xykj.base.dao.sys.role;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.entity.sys.role.Role;

@Repository
public interface RoleDao extends BaseDao<Role>{
	
	public List<Permission> getPermissions(Role role);
	
	public void insertRolePermission(@Param("roleId")String roleId,@Param("pid")String permissionId);

	public void deleteRolePermission(Role role);
	
	public List<Role> findAllRole();
	
}
