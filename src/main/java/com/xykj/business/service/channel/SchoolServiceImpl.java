package com.xykj.business.service.channel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.service.token.TokenManager;
import com.xykj.base.util.Page;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.channel.ContactDao;
import com.xykj.business.dao.channel.SchoolDao;
import com.xykj.business.entity.channel.Contact;
import com.xykj.business.entity.channel.School;

@Service("SchoolService")
public class SchoolServiceImpl extends BaseServiceImpl<School> implements SchoolService{
	@Autowired 
	private SchoolDao schoolDao;
	@Autowired 
	private ContactDao contactDao;
	@Autowired
	private TokenManager tokenManager;
	
	
	/**
	 * 插入渠道校园
	 */
	@Transactional
	@Override
	public void insert(School o) {
		o.setId(UuidUtil.get32UUID());
		String accountName = tokenManager.getCurrentAccount(o.getToken().split("_")[0]).getAccountName();
		o.setCreateBy(accountName);
		o.setCreateTime(new Date());
		schoolDao.insert(o);
	}

	/**
	 * 删除渠道校园
	 */
	@Transactional
	@Override
	public void delete(School o) {
		String schoolId = o.getId();
		contactDao.deleteById(schoolId);
		schoolDao.delete(o);
	}

	@Override
	public Page<School> findByPage(Page<School> page, School o) {
		List<School> list = schoolDao.findByPage(o, page);
		for(School s : list) {
			List<Contact> contacts = contactDao.findBySchoolId(s.getId());
			s.setContacts(contacts);
		}
		page.setResults(list);
		return page;
	}

	/**
	 * 查询某个渠道校园,包括联系人信息
	 */
	@Override
	public School find(School o) {
		School school = schoolDao.find(o);
		List<Contact> contacts = contactDao.findBySchoolId(o.getId());
		school.setContacts(contacts);
		return school;
	}

	@Override
	public List<School> findSchools() {
		return schoolDao.findSchools();
	}

	/**
	 * 添加校园联系人
	 *
	 * @params
	 * @return
	 */
	@Override
	public void insertContact(School school,Contact contact) {
		contact.setSchoolId(school.getId());
		contactDao.insert(contact);
	}

	
	
	
	
}
