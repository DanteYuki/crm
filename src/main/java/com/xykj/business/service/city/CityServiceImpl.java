package com.xykj.business.service.city;

import org.springframework.stereotype.Service;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.entity.campus.City;

@Service("CityService")
public class CityServiceImpl extends BaseServiceImpl<City> implements CityService{

	@Override
	public void insert(City o) {
		String id = UuidUtil.get32UUID();
		o.setId(id);
		super.insert(o);
	}
	
}
