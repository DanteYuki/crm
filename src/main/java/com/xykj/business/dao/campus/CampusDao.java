package com.xykj.business.dao.campus;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.campus.Campus;

@Repository
public interface CampusDao extends BaseDao<Campus>{
	public List<Campus> findByCity(Campus campus);
}
