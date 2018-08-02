package com.xykj.business.service.reputation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xykj.base.dao.sys.account.AccountDao;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.reputation.ReputationDao;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.entity.reputation.Reputation;
import com.xykj.business.service.classManage.ClassStudentService;

@Service("Reputation")
public class ReputationServiceImpl extends BaseServiceImpl<Reputation> implements ReputationService {

	@Autowired
	private ReputationDao reputationDao;
	@Autowired
	private ClassStudentService classStudentService;
	@Autowired
	private AccountDao accountDao;
	/**
	 * 新增口碑的同时,需要指派班级
	 */
	@Transactional
	@Override
	public void insertStudent(Reputation o,String classId) {
		o.setId(UuidUtil.get32UUID());
		
		String token = o.getToken();
		Account a = new Account();
		a.setAccountId(token.split("_")[0]);
		Account account = accountDao.find(a);
		
		o.setCreateBy(account.getAccountName());
		o.setCreateTime(new Date());
		ClassStudent classStudent = new ClassStudent();
		classStudent.setId(UuidUtil.get32UUID());
		classStudent.setName(o.getName());
		classStudent.setAge(o.getAge());
		classStudent.setGender(o.getGender());
		classStudent.setMobile(o.getMobile());
		classStudent.setQq(o.getQq());
		classStudent.setWx(o.getWx());
		classStudent.setEducation(o.getEducation());
		classStudent.setRemark(o.getRemark());
		classStudent.setClassId(classId);
		classStudent.setCredit(100);
		classStudent.setReputationId(o.getId());
		classStudent.setChannelId("");
		classStudent.setSocialId("");
		reputationDao.insert(o);
		classStudentService.insert(classStudent);
	}
	
}
