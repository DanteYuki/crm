package com.xykj.base.service.token;

import com.xykj.base.entity.sys.account.Account;

/**
 * Redis Token生成验证
 * @author dante
 * @2018年6月13日
 */
public interface TokenManager {
	/**
	 * 创建token令牌
	 *
	 * @params
	 * @return
	 */
	public String createToken(String accountId);
	
	/**
	 * 验证token是否有效
	 *
	 * @params
	 * @return
	 */
	public boolean checkToken(String tokenId);
	
	/**
	 * 获取tokenId
	 *
	 * @params
	 * @return
	 */
	public String getToken(String accountId);
	
	/**
	 * 清除token
	 *
	 * @params
	 * @return
	 */
	public void deleteToken(String accountId);
	
	/**
	 * 获取当前用户
	 *
	 * @params
	 * @return
	 */
	public Account getCurrentAccount(String token);

}
