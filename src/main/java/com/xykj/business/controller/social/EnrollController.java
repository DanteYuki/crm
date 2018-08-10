//package com.xykj.business.controller.social;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.xykj.base.commom.RsyResponse;
//import com.xykj.base.controller.BaseController;
//import com.xykj.base.util.Page;
//import com.xykj.business.entity.social.Enroll;
//import com.xykj.business.service.social2.EnrollService;
//
//@Controller
//@RequestMapping("/backstage/enroll/")
//public class EnrollController extends BaseController<Enroll>{
//	@Autowired
//	private EnrollService enrollService;
//	
//	/**
//	 * 分布查询
//	 * 以及模糊匹配
//	 * @params
//	 * @return
//	 */
//	@RequestMapping(value = "findByPage")
//    @ResponseBody
//    public RsyResponse findByPage(Page<Enroll> page, Enroll enroll) {
//        try {
//            Page<Enroll> pageModel = enrollService.findByPage(page, enroll);
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("list", pageModel);
//            return RsyResponse.success("", map);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//
//        return RsyResponse.error("");
//    }
//	
//	//添加
//    @RequestMapping(value = "insert")
//    @ResponseBody
//    public RsyResponse add(Enroll enroll) {
//        try {
//        	enrollService.insert(enroll);
//            return RsyResponse.success("添加成功");
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("添加失败");
//    }
//
//    //删除
//    @RequestMapping(value = "delete")
//    @ResponseBody
//    public RsyResponse delete(Enroll enroll) {
//        try {
//        	enrollService.delete(enroll);
//            return RsyResponse.success("删除成功");
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("删除失败");
//    }
//
//    //修改
//    @RequestMapping(value = "update")
//    @ResponseBody
//    public RsyResponse update(Enroll enroll) {
//        try {
//        	enrollService.update(enroll);
//            return RsyResponse.success("更新失败");
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("更新成功");
//    }
//
//    //查询单个
//    @RequestMapping(value = "find")
//    @ResponseBody
//    public RsyResponse find(Enroll enroll) {
//        try {
//        	Enroll p = enrollService.find(enroll);
//            return RsyResponse.success("", p);
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("查询失败");
//    }
//    
//    @RequestMapping(value = {"chooseClass"},method = {RequestMethod.POST})
//    @ResponseBody
//    private RsyResponse chooseClass (@RequestParam("idString")String idString,
//    		@RequestParam("classId")String classId) {
//    	try {
//			enrollService.goIntoClass(idString, classId);
//			return RsyResponse.success("调入班级成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return RsyResponse.error("调入班级操作发生错误");
//    }
//    
//}
