package com.xykj.base.service.sys.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.dao.sys.config.ConfigDao;
import com.xykj.base.entity.sys.config.Config;
import com.xykj.base.service.BaseServiceImpl;

@Service("ConfigService")
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements ConfigService{

	@Autowired
	private ConfigDao configDao;
	@Override
	public List<Config> findConfigs(Config config) {
		return configDao.findConfigs(config);
	}

}
