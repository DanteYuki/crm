package com.xykj.business.dao.classManage;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.classManage.ClassStudent;

@Repository
public interface ClassStudentDao extends BaseDao<ClassStudent>{
	/**
	 * 改变学分
	 *
	 * @params
	 * @return
	 */
	public void changeCredit(ClassStudent classStudent);
	
	/**
	 * 留级或者转班
	 *
	 * @params
	 * @return
	 */
	public void downNext(ClassStudent classStudent,@Param("class_id")String classId);
	
	/**
	 * 退学,休学
	 *
	 * @params
	 * @return
	 */
	public void quit(ClassStudent classStudent);
	
	/**
	 * 第一次模拟面试
	 *
	 * @params
	 * @return
	 */
	public void interview1(ClassStudent classStudent);
	
	/**
	 * 第二次模拟面试
	 *
	 * @params
	 * @return
	 */
	public void interview2(ClassStudent classStudent);
	
	/**
	 * 第一次阶段考试
	 *
	 * @params
	 * @return
	 */
	public void exam1(ClassStudent classStudent);
	
	/**
	 * 第二次阶段考试
	 *
	 * @params
	 * @return
	 */
	public void exam2(ClassStudent classStudent);
	
	/**
	 * 第三次阶段考试
	 *
	 * @params
	 * @return
	 */
	public void exam3(ClassStudent classStudent);
	
	/**
	 * 根据电话号码获取信息
	 *
	 * @params
	 * @return
	 */
	public ClassStudent findByPhoneNumber(@Param("phoneNo") String phoneNumber);
	
	/**
	 * 添加考试成绩
	 *
	 * @params signal : 第一次考试成绩标志
	 * @return
	 */
	public void insertFirst(ClassStudent classStudent);
	
	/**
	 * 添加考试成绩
	 *
	 * @params signal : 第二次考试成绩标志
	 * @return
	 */
	public void insertSecond(ClassStudent classStudent);
	
	/**
	 * 添加考试成绩
	 *
	 * @params signal : 第三次考试成绩标志
	 * @return
	 */
	public void insertThird(ClassStudent classStudent);
}
