package com.xykj.base.service.token;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.sys.account.AccountService;
import com.xykj.base.util.UuidUtil;

@Service("TokenManager")
public class TokenManagerImpl implements TokenManager{

	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private AccountService accountService;
	
	@Override
	public String createToken(String accountId) {
		String token = accountId + "_" + UuidUtil.get32UUID();
		/**
		 * 绑定值,并且设置缓存时间
		 */
		redisTemplate.boundValueOps(accountId).set(token, 7, TimeUnit.DAYS);
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		if(token == null || token.length() == 0) {
			return false;
		}
		String accountId = token.split("_")[0];
//		System.out.println("accountId : " + accountId);
		String checkToken = getToken(accountId);
//		System.out.println("redis中的token : " + checkToken);
		boolean flag = token != null && token.length() > 0 && token.equals(checkToken);
		//如果令牌通过,延长token时间
		if(flag) {
			redisTemplate.boundValueOps(accountId).expire(7, TimeUnit.DAYS);
		} else {
		//如果令牌没通过,删除掉redis缓存
//			deleteToken(accountId);
		}
		return flag;
	}

	@Override
	public String getToken(String accountId) {
		if (accountId != null && accountId.length() > 0) {
			return redisTemplate.boundValueOps(accountId).get();
		}
		return null;
	}

	@Override
	public void deleteToken(String accountId) {
		redisTemplate.delete(accountId);
	}

	@Override
	public Account getCurrentAccount(String token) {
		Account o = new Account();
		String accountId = token.split("_")[0];
		o.setAccountId(accountId);
		return accountService.find(o);
	}
}
