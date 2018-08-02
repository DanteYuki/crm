package com.xykj.base.controller.sys.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.service.sys.account.AccountService;
import com.xykj.base.util.Page;

@Controller
@RequestMapping("/backstage/account/")
public class AccountController extends BaseController<Account>{
	@Autowired
	private AccountService accountService;
	/**
	 * 插入账户数据
	 * @param account 账户实体类对象
	 * @return 返回插入成功或者失败
	 */
	@RequestMapping(value = {"insert"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insert(Account account) {
		try {
			accountService.insert(account);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("创建账户发生错误");
		}
		return RsyResponse.success("创建账户成功");
	}
	
	
	@RequestMapping(value = {"insertAccount"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insertAccount(Account account,@RequestParam("roles") String roles){
		try {
//			System.out.println(account);
			System.out.println(roles);
			accountService.insertAccount(roles,account);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("添加失败");
		}
		return RsyResponse.success("添加成功");
	}
	
	/**
	 * 分页查询账户列表
	 * @param page 分页实体类
	 * @param account 账号实体对象
	 * @return 返回查询成功或失败
	 */
	@RequestMapping(value = {"findByPage"}, method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findByPage(Page<Account> page, Account account){
		try {
            Page<Account> pageModel = accountService.findByPage(page,account);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("查询列表成功", map);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return RsyResponse.error("查询列表失败");
	}
	
	/**
	 * 根据页面信息修改某个账户
	 * @param account 账户实体对象
	 * @return 返回更新成功或者失败
	 */
	@RequestMapping(value = {"update"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse updateAccount(Account account){
		try {
			accountService.update(account);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("更新发生错误,请检查");
		}
		return RsyResponse.success("更新成功");
	}
	
	/**
	 * 根据页面参数查询单个账户信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"find"} , method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findAccount(Account account){
		Account o = null;
		try {
			o = accountService.find(account);
		} catch (Exception e) {
			return RsyResponse.error("查询账户失败");
		}
		return RsyResponse.success("查询成功",o);
	}
	
	/**
	 * 根据页面参数删除账户信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"delete"} , method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse deleteAccount(Account account) {
		try {
			accountService.delete(account);
		} catch (Exception e) {
			return RsyResponse.error("删除失败");
		}
		return RsyResponse.success("删除成功");
	}
	
	@RequestMapping(value = {"getRoles"},method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse getRolesByAccount(Account account) {
		List<Role> roles = null;
		try {
			roles = accountService.getRoles(account);
		} catch (Exception e) {
			return RsyResponse.error("获取数据失败");
		}
		return RsyResponse.success("获取数据成功",roles);
	}
	
	/**
	 * 登录路径映射
	 *
	 * @params 账户
	 * @return 返回用户信息的封装
	 */
	@RequestMapping(value = {"login"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse login(Account account) {
		Map<String, Object> loginMap = null;
		try {
			loginMap = accountService.login(account);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error(e.getMessage());
		}
		return RsyResponse.success("登录成功", loginMap);
	}
	
	@RequestMapping(value = {"findAllAdvisor"},method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findAllAdvisor(@RequestParam("campusId")String campusId){
		try {
			List<Account> list = accountService.findAllAdvisorByCampusId(campusId);
			return RsyResponse.success("获取信息成功",list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return RsyResponse.error("获取咨询师发生错误");
	}
}
