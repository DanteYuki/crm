package com.xykj.business.service.channel;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.channel.ChannelStudent;

public interface ChannelStudentService extends BaseService<ChannelStudent>{
	public void insertStudent(ChannelStudent channelStudent,String classId);
}
