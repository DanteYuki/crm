//package com.xykj.business.service.social2;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.xykj.base.service.BaseService;
//import com.xykj.base.util.Page;
//import com.xykj.business.entity.social.Social;
//
//public interface SocialService extends BaseService<Social>{
//	/**
//	 * 试学接口
//	 *
//	 * @params
//	 * @return
//	 */
//	public void tryLearn(Social social);
//	
//	/**
//	 * 报名接口
//	 *
//	 * @params
//	 * @return
//	 */
//	public void pay(Social social);
//	
//	/**
//	 * 变为无效量
//	 *
//	 * @params
//	 * @return
//	 */
//	public void disabled(Social social);
//	/**
//	 * 下载
//	 *
//	 * @params
//	 * @return
//	 */
//	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception;
//	
//	/**
//	 * 上传
//	 *
//	 * @params
//	 * @return
//	 */
//	public void upload(MultipartFile file,String token) throws Exception;
//	
//	
//	
//	/**
//	 * 判断上传的记录是否有重复
//	 *
//	 * @params
//	 * @return
//	 */
//	public boolean isDumplicated(Social social);
//
//}
