package com.xykj.base.service.sys.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xykj.base.dao.sys.account.AccountDao;
import com.xykj.base.dao.sys.permission.PermissionDao;
import com.xykj.base.dao.sys.role.RoleDao;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.exception.RsyLoginException;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.RsySession;
import com.xykj.base.util.RsySessionUtil;
import com.xykj.base.util.UuidUtil;

@Service("AccountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private RsySessionUtil rsySessionUtil;
	
	
	
	
	@Override
	public void insert(Account o) {
		String accountId = UuidUtil.get32UUID();
		o.setAccountId(accountId);
		o.setCreateTime(new Date());
		//由session取到的用户读取到创建人
		RsySession rsySession = rsySessionUtil.getRsySession();
		System.out.println(rsySession);
		o.setCreateBy(rsySession.getAccount().getAccountName());
		o.setUpdateBy("");
		o.setUpdateTime(null);
		accountDao.insert(o);
	}

	/**
	 * 给用户分配角色
	 */
	@Override
	@Transactional
	public void insertAccount(String roleString,Account o) {
		insertAccountRole(o.getAccountId(),roleString );
	}
	
	public void update(Account o) {
		String updateBy = rsySessionUtil.getRsySession().getAccount().getAccountName();
		o.setUpdateBy(updateBy);
		o.setUpdateTime(new Date());
		super.update(o);
	};
	
	/**
	 * 获取该账户拥有的角色列表
	 */
	@Override
	public List<Role> getRoles(Account account) {
		return accountDao.findRolesByAccount(account);
	}

	/**
	 * 级联删除所有与该账户有关的角色
	 */
	@Override
	public void deleteByAccount(Account account) {
		accountDao.deleteByAccount(account);
	}
	
	/**
	 * 插入账户角色信息
	 */
	@Transactional
	public void insertAccountRole(String accountId,String roleString) {
		Account a = new Account();
		a.setAccountId(accountId);
		accountDao.deleteByAccount(a);
		String[] roleIds = roleString.split(",");
		System.out.println(Arrays.toString(roleIds));
		for(String roleId : roleIds) {
			accountDao.insertAccountRoleBatch(roleId, accountId);
		}
	}

	/**
	 * 登录接口
	 */
	@Override
	public Map<String, Object> login(Account account) throws RsyLoginException{
		Account checkAccount = accountDao.findByNameAndPwd(account);
//		System.out.println(checkAccount);
		if(checkAccount == null){
			throw new RsyLoginException("账户密码不匹配,请检查");
		}
		Map<String, Object> loginMap = new HashMap<>();
		loginMap.put("account", checkAccount);
		List<Role> roles = getRoles(checkAccount);
		loginMap.put("roles", roles);
		
		List<Permission> permissions = new ArrayList<>();
		for(Role role : roles){
			List<Permission> child = roleDao.getPermissions(role);
			permissions.addAll(child);
		}
		loginMap.put("permissions", permissions);
		RsySession rsySession = new RsySession();
		System.out.println(rsySession);
		rsySession.setAccount(checkAccount);
		System.out.println(request.getSession().getId());
		request.getSession().setAttribute("session", rsySession);
		return loginMap;
	}

	@Override
	public Account findByNameAndPwd(Account account) {
		return accountDao.findByNameAndPwd(account);
	}
	
	
}
