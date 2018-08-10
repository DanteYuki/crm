//package com.xykj.business.service.channel;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.xykj.base.service.BaseServiceImpl;
//import com.xykj.base.util.Page;
//import com.xykj.base.util.UuidUtil;
//import com.xykj.business.dao.channel.ContactDao;
//import com.xykj.business.dao.channel.SchoolDao;
//import com.xykj.business.entity.channel.Contact;
//import com.xykj.business.entity.channel.School;
//
////@Service("SchoolService")
//public class SchoolServiceImpl2 extends BaseServiceImpl<School> implements SchoolService{
//	@Autowired 
//	private SchoolDao schoolDao;
//	
//	@Autowired 
//	private ContactDao contactDao;
//	
//	@Transactional
//	@Override
//	public void insert(School o) {
//		List<Contact> contacts = o.getContacts();
//		o.setCreateTime(new Date());
//		o.setId(UuidUtil.get32UUID());
//		for(Contact c : contacts) {
//			c.setSchoolId(o.getId());
//			contactDao.insert(c);
//		}
//		schoolDao.insert(o);
//	}
//
//	@Transactional
//	@Override
//	public void delete(School o) {
//		String schoolId = o.getId();
//		contactDao.deleteById(schoolId);
//		schoolDao.delete(o);
//	}
//
//	@Override
//	public Page<School> findByPage(Page<School> page, School o) {
//		List<School> list = schoolDao.findByPage(o, page);
//		for(School s : list) {
//			List<Contact> contacts = contactDao.findBySchoolId(s.getId());
//			s.setContacts(contacts);
//		}
//		page.setResults(list);
//		return page;
//	}
//
//	@Override
//	public School find(School o) {
//		School school = schoolDao.find(o);
//		List<Contact> contacts = contactDao.findBySchoolId(o.getId());
//		school.setContacts(contacts);
//		return school;
//	}
//
//	@Override
//	public List<School> findSchools() {
//		return schoolDao.findSchools();
//	}
//
//	
//	
//	
//	
//}
