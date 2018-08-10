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
//import com.xykj.business.entity.social.SocialDisable;
//import com.xykj.business.service.social2.SocialDisableService;
//
//@Controller
//@RequestMapping("/backstage/disable/")
//public class SocialDisableController extends BaseController<SocialDisable>{
//	@Autowired
//	private SocialDisableService socialDisableService;
//	
//	/**
//	 * 分布查询
//	 * 以及模糊匹配
//	 * @params
//	 * @return
//	 */
//	@RequestMapping(value = "findByPage")
//    @ResponseBody
//    public RsyResponse findByPage(Page<SocialDisable> page, SocialDisable socialDisable) {
//        try {
//            Page<SocialDisable> pageModel = socialDisableService.findByPage(page, socialDisable);
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
//    public RsyResponse add(SocialDisable socialDisable) {
//        try {
//        	socialDisableService.insert(socialDisable);
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
//    public RsyResponse delete(SocialDisable socialDisable) {
//        try {
//        	socialDisableService.delete(socialDisable);
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
//    public RsyResponse update(SocialDisable socialDisable) {
//        try {
//        	socialDisableService.update(socialDisable);
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
//    public RsyResponse find(SocialDisable socialDisable) {
//        try {
//        	SocialDisable p = socialDisableService.find(socialDisable);
//            return RsyResponse.success("", p);
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("查询失败");
//    }
//    
//    @RequestMapping(value = {"divide"},method = {RequestMethod.POST})
//    @ResponseBody
//    public RsyResponse divide (@RequestParam("disables")String disables,@RequestParam("advisor")String advisor) {
//    	try {
//			socialDisableService.divide(disables, advisor);
//			return RsyResponse.success("调配无效量成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return RsyResponse.error("调配无效量发生异常");
//    }
//    
//    
//    
//}
