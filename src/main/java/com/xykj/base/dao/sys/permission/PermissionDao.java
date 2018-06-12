package com.xykj.base.dao.sys.permission;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.util.Page;

@Repository
public interface PermissionDao extends BaseDao<Permission> {
	public List<Permission> findByPageAndLevel(Page<Permission> page,@Param("plevel")Integer plevel);

	public List<Permission> findAllPermission();

}