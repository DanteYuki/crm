package com.xykj.business.dao.classManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.business.entity.classManage.Talk;

@Repository
public interface TalkDao{
	
	public void insert(Talk talk,@Param("studentId")String studentId);
	
	public List<Talk> findTalkById(@Param("studentId")String studentId);
}
