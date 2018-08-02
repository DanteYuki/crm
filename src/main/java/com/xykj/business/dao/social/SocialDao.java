package com.xykj.business.dao.social;

import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.social.Social;

@Repository
public interface SocialDao extends BaseDao<Social>{
	/**
	 * 参与试学
	 *
	 * @params
	 * @return
	 */
	public void tryLearn(Social social);
	
	/**
	 * 报名
	 *
	 * @params
	 * @return
	 */
	public void pay(Social social);
	
	/**
	 * 无效量
	 *
	 * @params
	 * @return
	 */
	public void disabled(Social social);
	
	/**
	 * 根据电话号码判断是否有重复
	 *
	 * @params
	 * @return
	 */
	public Social findByPhone(Social social);
	
	/**
	 * 分配无效量
	 *
	 * @params
	 * @return
	 */
	public void divide(Social social);
	
	public void insertFeedback(Social social);
}
