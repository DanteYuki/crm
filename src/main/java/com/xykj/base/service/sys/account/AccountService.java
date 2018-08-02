package com.xykj.base.service.sys.account;

import java.util.List;
import java.util.Map;

import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.exception.RsyLoginException;
import com.xykj.base.service.BaseService;

public interface AccountService extends BaseService<Account>{
	
	public void insertAccount(String roleString,Account account);
	
	public List<Role> getRoles(Account account);
	
	public void deleteByAccount(Account account);
	
	public void insertAccountRole(String roleString,String accountId);

	public Map<String, Object> login(Account account) throws RsyLoginException;
	
	public Account findByNameAndPwd(Account account);
	
	/**
	 * 获取校区所有咨询师
	 *
	 * @params
	 * @return
	 */
	public List<Account> findAllAdvisorByCampusId(String campusId);
}
