package com.xykj.base.service.sys.permission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xykj.base.dao.sys.permission.PermissionDao;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.Page;
import com.xykj.base.util.UuidUtil;

@Service("PermissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{
	
	@Autowired
	private PermissionDao permissionDao;
	@Override
	public void insert(Permission o) {
		String permissionId = UuidUtil.get32UUID();
		o.setPermissionId(permissionId);
		super.insert(o);
	}

	@Override
	public Page<Permission> findByPage(Page<Permission> page,Permission o) {
		return super.findByPage(page,o);
	}

	@Override
	public Page<Permission> findByPageAndLevel(Page<Permission> page,Permission permission) {
		List<Permission> permissions = this.permissionDao.findByPageAndLevel(page, permission.getPlevel());
		for(Permission p : permissions) {
			System.out.println(p.getPlevel());
		}
		page.setResults(this.permissionDao.findByPageAndLevel(page, permission.getPlevel()));
		return page;
	}

	@Override
	public List<Permission> findAllPermission() {
		return permissionDao.findAllPermission();
	}
}
