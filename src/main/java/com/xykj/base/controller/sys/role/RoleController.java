package com.xykj.base.controller.sys.role;

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
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.entity.sys.role.Role;
import com.xykj.base.service.sys.role.RoleService;
import com.xykj.base.util.Page;

@Controller
@RequestMapping("/backstage/role/")
public class RoleController extends BaseController<Role>{
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = {"insert"}, method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insert(Role role){
		try {
			roleService.insert(role);
		} catch (Exception e) {
			return RsyResponse.error("添加请求操作错误");
		}
		return RsyResponse.success("添加成功");
	}
	/**
	 * 插入角色数据
	 * @param account 角色实体类对象
	 * @return 返回插入成功或者失败
	 */
	@RequestMapping(value = {"insertRolePermission"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insertRole(Role role,@RequestParam("permissions")String permissionString){
		try {
			roleService.insertRolePermission(role, permissionString);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("添加失败");
		}
		return RsyResponse.success("添加成功");
	}
	
	/**
	 * 分页查询角色列表
	 * @param page 分页实体类
	 * @param account 角色实体对象
	 * @return 返回查询成功或失败
	 */
	@RequestMapping(value = {"findByPage"}, method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findByPage(Role role,Page<Role> page){
		try {
            Page<Role> pageModel = roleService.findByPage(page,role);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("查询列表成功", map);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return RsyResponse.error("查询列表失败");
	}
	
	/**
	 * 根据页面信息修改某个角色
	 * @param account 角色实体对象
	 * @return 返回更新成功或者失败
	 */
	@RequestMapping(value = {"update"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse updateAccount(Role role,@RequestParam("permissionIds")String permissionIds){
		try {
			System.out.println(permissionIds);
			roleService.updateRole(role, permissionIds);
		} catch (Exception e) {
//			e.printStackTrace();
			return RsyResponse.error("更新发生错误,请检查");
		}
		return RsyResponse.success("更新成功");
	}
	
	/**
	 * 根据页面参数查询单个角色信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"find"} , method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findAccount(Role role){
		Role o = null;
		Map<String, Object> map = new HashMap<>();
		try {
			o = roleService.find(role);
			List<Permission> list = roleService.getPermissions(role);
			map.put("role", o);
			map.put("permissionList", list);
		} catch (Exception e) {
			return RsyResponse.error("查询账户失败");
		}
		return RsyResponse.success("查询成功",map);
	}
	
	/**
	 * 根据页面参数删除角色信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"delete"} , method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse deleteAccount(Role role) {
		try {
			roleService.delete(role);
		} catch (Exception e) {
			return RsyResponse.error("删除失败");
		}
		return RsyResponse.success("删除成功");
	}
	
	@RequestMapping(value = {"findAllRole"},method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findAllPermission() {
		try {
			List<Role> list = roleService.findAllRoles();
			return RsyResponse.success("",list);
		} catch (Exception e) {
		}
		
		return RsyResponse.error("查询发生错误");
	}
}
