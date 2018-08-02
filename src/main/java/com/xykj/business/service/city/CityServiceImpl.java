package com.xykj.business.service.city;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.campus.CityDao;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.entity.campus.City;

@Service("CityService")
public class CityServiceImpl extends BaseServiceImpl<City> implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public void insert(City o) {
		String id = UuidUtil.get32UUID();
		o.setId(id);
		super.insert(o);
	}

	@Override
	public List<Campus> findCampusByCity(City city) {
		return cityDao.findCampusByCity(city);
	}

	@Override
	public List<City> findAllCity() {
		return cityDao.findAllCity();
	}
	
}
