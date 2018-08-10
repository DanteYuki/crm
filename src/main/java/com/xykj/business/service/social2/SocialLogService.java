package com.xykj.business.service.social2;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.social.SocialLog;

public interface SocialLogService extends BaseService<SocialLog>{
	public List<SocialLog> findLogsBySocialID(SocialLog socialLog);
}
