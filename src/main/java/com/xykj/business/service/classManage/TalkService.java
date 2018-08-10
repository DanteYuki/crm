package com.xykj.business.service.classManage;

import java.util.List;

import com.xykj.business.entity.classManage.Talk;

public interface TalkService {
	public void talk(Talk talk, String id);
	public List<Talk> findTalkById(String studentId);
}
