package com.xykj.business.service.classManage;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.classManage.StudentException;

public interface StudentExceptionService extends BaseService<StudentException>{
	/**
	 * 根据学生id查询加减学分异常
	 *
	 * @params
	 * @return
	 */
	public List<StudentException> findScoreException(String id);
	
}
