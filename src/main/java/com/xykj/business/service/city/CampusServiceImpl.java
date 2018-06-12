package com.xykj.business.service.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.campus.CampusDao;
import com.xykj.business.entity.campus.Campus;

@Service("CampusService")
public class CampusServiceImpl extends BaseServiceImpl<Campus> implements CampusService{

	@Autowired
	private CampusDao campusDao;
	
	@Override
	public void insert(Campus o) {
		o.setId(UuidUtil.get32UUID());
		super.insert(o);
	}

	/**
	 * 获取一个城市所有的校区
	 * 传入校区的id
	 */
	@Override
	public List<Campus> findCampusByCity(Campus campus) {
		List<Campus> list = campusDao.findByCity(campus);
		return list;
	}
	
}
