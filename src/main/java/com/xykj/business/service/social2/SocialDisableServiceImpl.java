//package com.xykj.business.service.social2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.xykj.base.service.BaseServiceImpl;
//import com.xykj.business.dao.social.SocialDisableDao;
//import com.xykj.business.entity.social.SocialDisable;
//
////@Service("SocialDisableService")
//public class SocialDisableServiceImpl extends BaseServiceImpl<SocialDisable> implements SocialDisableService{
//	
//	@Autowired
//	private SocialDisableDao socialDisableDao;
//	@Override
//	public void divide(String socialIds,String advisor) {
//		String[] ids = socialIds.split(",");
//		for (String id : ids) {
//			if (id != null && !id.trim().equals("")) {
//				SocialDisable o = new SocialDisable();
//				o.setId(id);
//				SocialDisable disable = socialDisableDao.find(o);
//				disable.setAdvisor(advisor);
//				if (o != null) {
//					socialDisableDao.divide(disable);
//				}
//			}
//		}
//	}
//}
