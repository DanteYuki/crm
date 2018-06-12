package com.xykj.business.dao.channel;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xykj.base.dao.BaseDao;
import com.xykj.business.entity.channel.Contact;

@Repository
public interface ContactDao extends BaseDao<Contact>{
	public void deleteById(@Param("schoolId") String schoolId);
	public List<Contact> findBySchoolId(@Param("schoolId")String schoolId);
}
