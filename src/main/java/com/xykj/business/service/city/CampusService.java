package com.xykj.business.service.city;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.campus.Campus;

public interface CampusService extends BaseService<Campus>{
	public List<Campus> findCampusByCity(Campus campus);
}
