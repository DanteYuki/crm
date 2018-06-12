package com.xykj.base.service.sys.permission;

import java.util.List;

import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.service.BaseService;
import com.xykj.base.util.Page;

public interface PermissionService extends BaseService<Permission>{
	public Page<Permission> findByPageAndLevel(Page<Permission> page,Permission permission);
	
	public List<Permission> findAllPermission();
}
