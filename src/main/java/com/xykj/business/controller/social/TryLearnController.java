//package com.xykj.business.controller.social;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.xykj.base.commom.RsyResponse;
//import com.xykj.base.controller.BaseController;
//import com.xykj.base.util.Page;
//import com.xykj.business.entity.social.TryLearn;
//import com.xykj.business.service.social2.TryLearnService;
//
//@Controller
//@RequestMapping("/backstage/tryLearn/")
//public class TryLearnController extends BaseController<TryLearn>{
//	@Autowired
//	private TryLearnService tryLearnService;
//	
//	/**
//	 * 分布查询
//	 * 以及模糊匹配
//	 * @params
//	 * @return
//	 */
//	@RequestMapping(value = "findByPage")
//    @ResponseBody
//    public RsyResponse findByPage(Page<TryLearn> page, TryLearn tryLearn) {
//        try {
//            Page<TryLearn> pageModel = tryLearnService.findByPage(page, tryLearn);
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
//    public RsyResponse add(TryLearn tryLearn) {
//        try {
//        	tryLearnService.insert(tryLearn);
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
//    public RsyResponse delete(TryLearn tryLearn) {
//        try {
//        	tryLearnService.delete(tryLearn);
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
//    public RsyResponse update(TryLearn tryLearn) {
//        try {
//        	tryLearnService.update(tryLearn);
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
//    public RsyResponse find(TryLearn tryLearn) {
//        try {
//        	TryLearn p = tryLearnService.find(tryLearn);
//            return RsyResponse.success("", p);
//        } catch (Exception e) {
//
//        }
//        return RsyResponse.error("查询失败");
//    }
//    
//    /**
//     * 试学转报名 
//     */
//    @RequestMapping(value = {"pay"},method = {RequestMethod.POST})
//    @ResponseBody
//    public RsyResponse pay(TryLearn tryLearn) {
//    	try {
//			tryLearnService.pay(tryLearn);
//			return RsyResponse.success("转报名成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return RsyResponse.error("转报名失败");
//    }
//    
//    /**
//     * 试学量转无效量
//     *
//     * @params
//     * @return
//     */
//    @RequestMapping(value = {"disable"},method = {RequestMethod.POST})
//    @ResponseBody
//    public RsyResponse disable(TryLearn tryLearn) {
//    	try {
//			tryLearnService.disable(tryLearn);
//			return RsyResponse.success("试学转无效量成功");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	return RsyResponse.error("试学转无效量失败");
//    }
//    
//}
