package com.xykj.base.service.sys.role;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xykj.base.dao.sys.role.RoleDao;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;

@Service("RoleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	
	
	@Override
	public void insert(Role o) {
		o.setRoleId(UuidUtil.get32UUID());
		roleDao.insert(o);
	}

	/**
	 * 插入数据
	 */
	@Transactional
	@Override
	public void insertRolePermission(Role o,String permissionIdString) {
		System.out.println(permissionIdString);
		if(!StringUtils.isBlank(permissionIdString)){
			String[] permissionIds = permissionIdString.split(",");
			for(String permissionId : permissionIds)
			roleDao.insertRolePermission(o.getRoleId(), permissionId);
		}
	}

	/**
	 * 获取该角色所有权限对象
	 */
	@Override
	public List<Permission> getPermissions(Role role) {
		return roleDao.getPermissions(role);
	}

	@Override
	public Role find(Role o) {
		// TODO Auto-generated method stub
		return super.find(o);
	}
	

	@Override
	public void delete(Role o) {
		super.delete(o);
	}

	@Transactional
	@Override
	public void updateRole(Role role, String permissionIds) {
		//删除该 角色所有的权限
		roleDao.update(role);
		roleDao.deleteRolePermission(role);
		//再添加 权限
		String[] ids = permissionIds.split(",");
		for(String id : ids) {
			roleDao.insertRolePermission(role.getRoleId(), id);
		}
	}

	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAllRole();
	}
}
