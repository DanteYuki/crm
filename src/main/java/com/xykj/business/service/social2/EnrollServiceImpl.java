//package com.xykj.business.service.social2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.xykj.base.service.BaseServiceImpl;
//import com.xykj.base.util.UuidUtil;
//import com.xykj.business.dao.social.EnrollDao;
//import com.xykj.business.entity.classManage.ClassStudent;
//import com.xykj.business.entity.social.Enroll;
//import com.xykj.business.service.classManage.ClassStudentService;
//
////@Service("EnrollService")
//public class EnrollServiceImpl extends BaseServiceImpl<Enroll> implements EnrollService{
//
//	@Autowired
//	private EnrollDao enrollDao;
//	@Autowired
//	private ClassStudentService classStudentService;
//	
//	/**
//	 * 将选定的学生指派到某个班级,此处需要先选择城市校区,再选择班级
//	 */
//		
//
//	@Override
//	public void goIntoClass(String idString, String classId) {
//		if (idString != null && !idString.trim().equals("")) {
//			String[] ids = idString.split(",");
//			for (String id : ids) {
//				Enroll enroll = new Enroll();
//				enroll.setId(id);
//				//查询出当个学生的社招信息
//				enroll = enrollDao.find(enroll);
//				ClassStudent classStudent = new ClassStudent();
//				classStudent.setId(UuidUtil.get32UUID());
//				classStudent.setName(enroll.getSname());
//				classStudent.setAge(enroll.getSage());
//				classStudent.setGender(enroll.getSgender().trim().equals("男") ? 1 : 0);
//				classStudent.setMobile(enroll.getMobile());
//				classStudent.setQq(enroll.getQq());
//				classStudent.setWx(enroll.getWx());
//				classStudent.setEducation(enroll.getEducation());
//				classStudent.setRemark("");
//				classStudent.setClassId(classId);
//				classStudent.setCredit(100);
//				classStudent.setSocialId(enroll.getId());
//				classStudent.setChannelId("");
//				classStudent.setReputationId("");
//				classStudentService.insert(classStudent);
//			}
//		}
//	}
//
//}
