package com.xykj.business.dao.campus;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.entity.campus.City;

@Repository
public interface CityDao extends BaseDao<City>{
	public List<Campus> findCampusByCity(City city);
	public List<City> findAllCity();
}
