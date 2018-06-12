package com.xykj.business.dao.classManage;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.classManage.CourseClass;

@Repository
public interface CourseClassDao extends BaseDao<CourseClass>{
	public List<CourseClass> findOne(CourseClass courseClass);
}
