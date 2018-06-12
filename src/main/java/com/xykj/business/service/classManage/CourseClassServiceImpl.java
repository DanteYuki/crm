package com.xykj.business.service.classManage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.campus.CampusDao;
import com.xykj.business.dao.campus.CityDao;
import com.xykj.business.dao.classManage.CourseClassDao;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.entity.classManage.CourseClass;

@Service("CourseClassService")
public class CourseClassServiceImpl extends BaseServiceImpl<CourseClass> implements CourseClassService{

	@Autowired 
	private CourseClassDao courseClassDao;
	@Autowired
	private CampusDao campusDao;
	@Autowired
	private CityDao cityDao;
	
	
	
	@Override
	public void insert(CourseClass o) {
		o.setId(UuidUtil.get32UUID());
		super.insert(o);
	}



	@Override
	public CourseClass find(CourseClass o) {
		CourseClass courseClass = courseClassDao.find(o);
		courseClass.setCampus(campusDao.find(o.getCampus()));
		courseClass.setCity(cityDao.find(o.getCity()));
		return courseClass;
	}



	@Override
	public List<CourseClass> findOne(CourseClass class1) {
		return courseClassDao.findOne(class1);
	}
	
	
}
