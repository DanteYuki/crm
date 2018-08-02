package com.xykj.business.service.social;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.xykj.base.service.BaseService;
import com.xykj.base.util.Page;
import com.xykj.business.entity.social.Social;

public interface SocialService extends BaseService<Social>{
	/**
	 * 试学接口
	 *
	 * @params
	 * @return
	 */
	public void tryLearn(Social social);
	
	/**
	 * 报名接口
	 *
	 * @params
	 * @return
	 */
	public void pay(Social social);
	
	/**
	 * 变为无效量
	 *
	 * @params
	 * @return
	 */
	public void disabled(Social social);
	/**
	 * 下载
	 *
	 * @params
	 * @return
	 */
	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	/**
	 * 上传
	 *
	 * @params
	 * @return
	 */
	public void upload(MultipartFile file,String token) throws Exception;
	
	
	
	/**
	 * 判断上传的记录是否有重复
	 *
	 * @params
	 * @return
	 */
	public boolean isDumplicated(Social social);
	
	/**
	 * 查询试学量
	 *
	 * @params
	 * @return
	 */
	public Page<Social> findTry(Page<Social> page,Social social);
	
	/**
	 * 查询无效量
	 *
	 * @params
	 * @return
	 */
	public Page<Social> findDisable(Page<Social> page,Social social);
	
	
	/**
	 * 查询报名量
	 *
	 * @params
	 * @return
	 */
	public Page<Social> findPay(Page<Social> page,Social social);
	
	/**
	 * 已报名的学员由咨询师分配到班级里
	 *
	 * @params
	 * @return
	 */
	public void goIntoClass(String idString,String classId);
	
	
	/**
	 * 添加咨询师反馈
	 *
	 * @params
	 * @return
	 */
	public void addAdvisorFeedback(Social social);
	
	/**
	 * 指派无效量
	 *
	 * @params
	 * @return
	 */
	public void divide(String socialIds,String advisor);
}
