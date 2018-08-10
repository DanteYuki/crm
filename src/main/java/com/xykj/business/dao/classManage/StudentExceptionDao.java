package com.xykj.business.dao.classManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.classManage.StudentException;

@Repository
public interface StudentExceptionDao extends BaseDao<StudentException>{
	/**
	 * 根据学生id查询所有加减分记录
	 */
	public List<StudentException> findScoreException(@Param("studentId") String studentId);
	
}
