package com.xykj.business.service.channel;

import java.util.List;

import com.xykj.base.service.BaseService;
import com.xykj.business.entity.channel.Contact;
import com.xykj.business.entity.channel.School;

public interface SchoolService extends BaseService<School>{
	public List<School> findSchools();
	public void insertContact(School school,Contact contact);
}
