package com.xykj.business.dao.channel;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.channel.School;

@Repository
public interface SchoolDao extends BaseDao<School>{
	public List<School> findSchools();
}
