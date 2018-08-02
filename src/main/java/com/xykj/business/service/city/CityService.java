package com.xykj.business.service.city;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.entity.campus.City;

public interface CityService extends BaseService<City>{
	public List<Campus> findCampusByCity(City city);
	public List<City> findAllCity();
}
