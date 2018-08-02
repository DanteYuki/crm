package com.xykj.business.service.channel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xykj.base.dao.sys.account.AccountDao;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.channel.ChannelStudentDao;
import com.xykj.business.entity.channel.ChannelStudent;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.service.classManage.ClassStudentService;

@Service("ChannelStudentService")
public class ChannelStudentServiceImpl extends BaseServiceImpl<ChannelStudent> implements ChannelStudentService{
	@Autowired
	private ChannelStudentDao channelStudentDao;
	@Autowired
	private ClassStudentService classStudentService;
	@Autowired
	private AccountDao accountDao;
	
	/**
	 * 新增的渠道学员直接指派班级
	 */
	@Transactional
	@Override
	public void insertStudent(ChannelStudent o,String classId) {
		o.setId(UuidUtil.get32UUID());
		
		String token = o.getToken();
		Account a = new Account();
		a.setAccountId(token.split("_")[0]);
		Account account = accountDao.find(a);
		o.setCreateBy(account.getAccountName());
		o.setCreateTime(new Date());
		ClassStudent classStudent = new ClassStudent();
		classStudent.setId(UuidUtil.get32UUID());
		classStudent.setName(o.getSname());
		classStudent.setAge(o.getSage());
		classStudent.setGender(o.getSgender().equals("男") ? 1 : 0);
		classStudent.setMobile(o.getMobile());
		classStudent.setQq(o.getQq());
		classStudent.setWx(o.getWx());
		classStudent.setEducation(o.getEducation());
		classStudent.setRemark(o.getRemark());
		classStudent.setClassId(classId);
		classStudent.setCredit(100);
		classStudent.setReputationId("");
		classStudent.setChannelId(o.getId());
		classStudent.setSocialId("");
		channelStudentDao.insert(o);
		classStudentService.insert(classStudent);
	}
	
	
}
