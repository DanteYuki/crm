package com.xykj.base.dao.sys.account;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.entity.sys.role.Role;

@Repository
public interface AccountDao extends BaseDao<Account>{
	
	public void insertAccount(String roleString,Account account);
	
	public List<Role> findRolesByAccount(Account account);
	
	public void deleteByAccount(Account account);
	
	public void insertAccountRoleBatch(@Param("roleId") String roleIds,@Param("accountId") String accountId);
	
	public Account findByNameAndPwd(Account account);
	
	public List<Account> findAllAdvisorByCampusId(@Param("campusId")String campusId);

}
