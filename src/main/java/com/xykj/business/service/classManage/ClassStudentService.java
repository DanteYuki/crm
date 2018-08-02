package com.xykj.business.service.classManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.entity.classManage.StudentException;

public interface ClassStudentService extends BaseService<ClassStudent>{
	
	/**
	 * 
	 *
	 * @params
	 * @return
	 */
	public void moveBatch(String ids,String classId);
	
	/**
	 * 学生扣除学分
	 *
	 * @params
	 * @return
	 */
	public void decreaseCredit(ClassStudent classStudent,StudentException studentException);
	
	/**
	 * 学生获取学分
	 *
	 * @params
	 * @return
	 */
	public void increaseCredit(ClassStudent classStudent,StudentException studentException);
	
	/**
	 * 学生留级或者转班
	 *
	 * @params
	 * @return
	 */
	public void downNext(ClassStudent classStudent,String classId,StudentException studentException);
	
	/**
	 * 退学
	 *
	 * @params
	 * @return
	 */
	public void quit(ClassStudent classStudent,StudentException studentException);
	
	/**
	 * 休学
	 *
	 * @params
	 * @return
	 */
	public void pause(ClassStudent classStudent,StudentException studentException);
	
	/**
	 * 上传阶段考试成绩
	 *
	 * @params
	 * @return
	 */
	public void importExcel(MultipartFile file,String token,int signal) throws Exception;
	
	/**
	 * 导出阶段考试成绩表格模板
	 *
	 * @params
	 * @return
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String classId) throws Exception;
	
	/**
	 * 导入模拟面试文件
	 *
	 * @params
	 * @return
	 */
	public void importInterview(MultipartFile file,String token,int signal) throws Exception;
	
	/**
	 * 导出某班级学生模拟面试模板
	 * 包括该学生的基本信息
	 * @params
	 * @return
	 */
	public void exportInterview(HttpServletRequest request,HttpServletResponse response,String classId) throws Exception;
}
