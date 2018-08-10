package com.xykj.business.service.classManage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.business.dao.classManage.StudentExceptionDao;
import com.xykj.business.entity.classManage.StudentException;

@Service("StudentExceptionService")
public class StudentExceptionServiceImpl extends BaseServiceImpl<StudentException> implements StudentExceptionService{

	@Autowired
	private StudentExceptionDao studentExceptionDao;
	
	@Override
	public List<StudentException> findScoreException(String studentId) {
		return studentExceptionDao.findScoreException(studentId);
	}

}
