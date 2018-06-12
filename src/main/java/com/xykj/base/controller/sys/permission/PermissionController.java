package com.xykj.base.controller.sys.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.entity.sys.permission.Permission;
import com.xykj.base.service.sys.permission.PermissionService;
import com.xykj.base.util.Page;

@Controller
@RequestMapping("/backstage/permission/")
public class PermissionController extends BaseController<Permission>{
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 插入权限数据
	 * @param account 权限实体类对象
	 * @return 返回插入成功或者失败
	 */
	@RequestMapping(value = {"insert"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insert(Permission permission){
		try {
			permissionService.insert(permission);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("添加失败");
		}
		return RsyResponse.success("添加成功");
	}
	
	/**
	 * 分页查询权限列表
	 * @param page 分页实体类
	 * @param account 权限实体对象
	 * @return 返回查询成功或失败
	 */
	@RequestMapping(value = {"findByPage"}, method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findByPage(Page<Permission> page, Permission permission){
		try {
            Page<Permission> pageModel = permissionService.findByPage(page, permission);
            Map<String, Object> map = new HashMap<>();
            map.put("list", pageModel);
            return RsyResponse.success("查询列表成功", map);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return RsyResponse.error("查询列表失败");
	}
	
	/**
	 * 根据页面信息修改某个权限
	 * @param account 权限实体对象
	 * @return 返回更新成功或者失败
	 */
	@RequestMapping(value = {"update"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse update(Permission permission){
		try {
			permissionService.update(permission);
		} catch (Exception e) {
//			e.printStackTrace();
			return RsyResponse.error("更新发生错误,请检查");
		}
		return RsyResponse.success("更新成功");
	}
	
	/**
	 * 根据页面参数查询单个权限信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"find"} , method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse find(Permission permission){
		Permission o = null;
		try {
			o = permissionService.find(permission);
		} catch (Exception e) {
			return RsyResponse.error("查询账户失败");
		}
		return RsyResponse.success("查询成功",o);
	}
	
	/**
	 * 根据页面参数删除权限信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = {"delete"} , method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse delete(Permission permission) {
		try {
			permissionService.delete(permission);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("删除失败");
		}
		return RsyResponse.success("删除成功");
	}
	
	@RequestMapping(value = {"findByLevel"} , method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findByLevel(Page<Permission> page,Permission permission){
		try {
			Page<Permission> pageModel = permissionService.findByPageAndLevel(page, permission);
            Map<String, Object> map = new HashMap<>();
            map.put("list", pageModel);
			return RsyResponse.success("查询列表成功",map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RsyResponse.error("查询发生错误");
	}
	
	@RequestMapping(value = {"findAllPermission"},method = {RequestMethod.GET})
	@ResponseBody
	public RsyResponse findAllPermission() {
		try {
			List<Permission> list = permissionService.findAllPermission();
			return RsyResponse.success("",list);
		} catch (Exception e) {
		}
		
		return RsyResponse.error("查询发生错误");
	}
}
