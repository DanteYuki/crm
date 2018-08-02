package com.xykj.business.service.classManage;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.classManage.CourseClass;

public interface CourseClassService extends BaseService<CourseClass>{
	public List<CourseClass> findOne(CourseClass class1);
	/**
	 * 根据校区获取所有该 校区班级
	 *
	 * @params
	 * @return
	 */
	public List<CourseClass> findAllClassByCampusId(String campusId);
}
