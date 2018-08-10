package com.xykj.business.service.social2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.business.dao.social.SocialLogDao;
import com.xykj.business.entity.social.SocialLog;

@Service("SocialLogService")
public class SocialLogServiceImpl extends BaseServiceImpl<SocialLog> implements SocialLogService{

	@Autowired
	private SocialLogDao socialLogDao;
	
	/**
	 * 根据学生的上门ID查询该 上门人员所有的日志记录
	 */
	@Override
	public List<SocialLog> findLogsBySocialID(SocialLog socialLog) {
		return socialLogDao.findLogs(socialLog);
	}
	
}
