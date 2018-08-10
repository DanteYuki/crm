//package com.xykj.business.service.social2;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.xykj.base.dao.sys.account.AccountDao;
//import com.xykj.base.entity.sys.account.Account;
//import com.xykj.base.service.BaseServiceImpl;
//import com.xykj.business.dao.social.TryLearnDao;
//import com.xykj.business.entity.social.SocialLog;
//import com.xykj.business.entity.social.TryLearn;
//
////@Service("TryLearnService")
//public class TryLearnServiceImpl extends BaseServiceImpl<TryLearn> implements TryLearnService{
//
//	@Autowired
//	private TryLearnDao tryLearnDao;
//	@Autowired
//	private AccountDao accountDao;
//	@Autowired
//	private SocialLogService socialLogService;
//	
//	/**
//	 * 试学量转报名量
//	 */
//	@Transactional
//	@Override
//	public void pay(TryLearn o) {
//		String token = o.getToken();
//		o = tryLearnDao.find(o);
//		Account a = new Account();
//		System.out.println(o.getToken());
//		a.setAccountId(token.split("_")[0]);
//		Account account = accountDao.find(a);
//		//从原试学量表中删除 
//		tryLearnDao.delete(o);
//		
//		//插入报名表
//		o.setIsPay(1);
//		tryLearnDao.pay(o);
//		
//		//插入日志记录
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		socialLogService.insert(socialLog);
//		
//
//		
//	}
//
//	@Transactional
//	@Override
//	public void disable(TryLearn o) {
//		
//		String token = o.getToken();
//		Account a = new Account();
//		a.setAccountId(token.split("_")[0]);
//		Account account = accountDao.find(a);
//		
//		o = tryLearnDao.find(o);
//		//从原试学量表中删除
//		tryLearnDao.delete(o);
//		//设为无效量
//		o.setStatus(4);
//		tryLearnDao.disable(o);
//		
//		//插入日志记录
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		socialLogService.insert(socialLog);
//	}
//}
