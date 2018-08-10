package com.xykj.business.dao.social;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.social.SocialLog;

/**
 * 社招日志记录
 * @author dante
 * @2018年6月27日
 */
@Repository
public interface SocialLogDao extends BaseDao<SocialLog>{
	/**
	 * 获取该 学生的所有记录信息
	 *
	 * @params
	 * @return
	 */
	public List<SocialLog> findLogs(SocialLog socialLog);
}
