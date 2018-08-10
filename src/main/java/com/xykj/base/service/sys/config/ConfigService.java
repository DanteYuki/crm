package com.xykj.base.service.sys.config;

import java.util.List;

import com.xykj.base.entity.sys.config.Config;
import com.xykj.base.service.BaseService;

public interface ConfigService extends BaseService<Config>{
	public List<Config> findConfigs (Config config);
}
