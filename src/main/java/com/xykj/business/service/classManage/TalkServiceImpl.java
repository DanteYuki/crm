package com.xykj.business.service.classManage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.token.TokenManager;
import com.xykj.business.dao.classManage.TalkDao;
import com.xykj.business.entity.classManage.Talk;

@Service("TalkService")
public class TalkServiceImpl implements TalkService{

	@Autowired
	private TalkDao talkDao;
	@Autowired
	private TokenManager tokenManager;
	
	@Override
	public void talk(Talk talk, String id) {
		String token = talk.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		talk.setHeadTeacher(account.getRealName());
		talk.setTalkTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		talkDao.insert(talk, id);
	}
	@Override
	public List<Talk> findTalkById(String studentId) {
		return talkDao.findTalkById(studentId);
	}

}
