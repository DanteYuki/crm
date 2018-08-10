package com.xykj.base.dao.sys.config;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.base.entity.sys.config.Config;

@Repository
public interface ConfigDao extends BaseDao<Config>{
	public List<Config> findConfigs(Config config);
}
