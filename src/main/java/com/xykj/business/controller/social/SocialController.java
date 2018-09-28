package com.xykj.business.controller.social;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.social.Social;
import com.xykj.business.entity.social.SocialLog;
import com.xykj.business.service.social.SocialService;
import com.xykj.business.service.social2.SocialLogService;

@Controller
@RequestMapping("/backstage/social/")
public class SocialController extends BaseController<Social>{
	@Autowired
	private SocialService socialService;
	
	@Autowired
	private SocialLogService socialLogService;
	
	/**
	 * 分布查询
	 * 以及模糊匹配
	 * @params
	 * @return
	 */
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Social> page, Social social) {
        try {
            Page<Social> pageModel = socialService.findByPage(page, social);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {

        }

        return RsyResponse.error("获取数据失败");
    }
	
	
	@RequestMapping(value = "findTryByPage")
    @ResponseBody
    public RsyResponse findTryByPage(Page<Social> page, Social social) {
        try {
            Page<Social> pageModel = socialService.findTry(page, social);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {
        	e.printStackTrace();

        }

        return RsyResponse.error("获取数据失败");
    }
	
	@RequestMapping(value = "findDisableByPage")
    @ResponseBody
    public RsyResponse findDisableByPage(Page<Social> page, Social social) {
        try {
            Page<Social> pageModel = socialService.findDisable(page, social);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {

        }

        return RsyResponse.error("获取数据失败");
    }
	
	@RequestMapping(value = "findEnrollByPage")
    @ResponseBody
    public RsyResponse findPayByPage(Page<Social> page, Social social) {
        try {
            Page<Social> pageModel = socialService.findPay(page, social);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return RsyResponse.error("获取数据失败");
    }
	
	
	//添加
    @RequestMapping(value = "insert")
    @ResponseBody
    public RsyResponse add(Social social) {
        try {
        	socialService.insert(social);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Social social) {
        try {
        	socialService.delete(social);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Social social) {
        try {
        	socialService.update(social);
            return RsyResponse.success("更新成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新失败");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Social social) {
        try {
        	Social p = socialService.find(social);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    /**
     * 试学
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"toTry"} ,method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse toTryLearn(Social social) {
    	try {
			socialService.tryLearn(social);
			return RsyResponse.success("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("操作发生错误");
    }
    
    /**
     * 报名
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"pay"} , method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse toPay(Social social) {
    	try {
			socialService.pay(social);
			return RsyResponse.success("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("操作发生错误");
    }
    
    /**
     * 将该信息转成无效量
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"disable"} , method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse disabled(Social social) {
    	try {
			socialService.disabled(social);
			return RsyResponse.success("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("操作发生错误");
    }
    
    @RequestMapping(value = {"download"} , method = {RequestMethod.GET})
    public void download(HttpServletRequest request,HttpServletResponse response) {
    	try {
			socialService.download(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = {"upload"}, method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse upload(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file
    		,@RequestParam("token") String token) {
    	try {
			socialService.upload(file,token);
			return RsyResponse.success("上传文件成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("上传文件发生错误");
    }
    
    /**
     * 指派无效量(批量)
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"divide"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse distribute(@RequestParam("socialIds")String socialIds,@RequestParam("advisor")String advisor
    		) {
    	try {
			socialService.divide(socialIds, advisor);
			return RsyResponse.success("指派成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("指派发生错误");
    }
    
    @RequestMapping(value = {"getLog"},method = {RequestMethod.GET})
    @ResponseBody
    public RsyResponse findLogsBySocialID(Social social) {
    	try {
    		SocialLog socialLog = new SocialLog();
    		socialLog.setSocialId(social.getId());
			List<SocialLog> list = socialLogService.findLogsBySocialID(socialLog);
			return RsyResponse.success("获取历史记录成功", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("获取历史记录发生错误");
    }
    
	@RequestMapping(value = {"chooseClass"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse chooseClass (@RequestParam("idString")String idString,
			@RequestParam("classId")String classId) {
		try {
			socialService.goIntoClass(idString, classId);
			return RsyResponse.success("调入班级成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RsyResponse.error("调入班级操作发生错误");
	}
	
	/**
	 * 添加试学反馈
	 *
	 * @params
	 * @return
	 */
	@RequestMapping(value = {"insertFeedback"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse insertAdvisorFeedback(Social social) {
		try {
			socialService.addAdvisorFeedback(social);
			return RsyResponse.success("添加成功");
		} catch (Exception e) {
			
		}
		return RsyResponse.error("添加发生错误");
	}
	
	public RsyResponse insertBackgroundInfo(Social social) {
		try {
			socialService.insertBackgroundInfo(social);
			return RsyResponse.success("添加背景信息成功");
		} catch (Exception e) {
		}
		return RsyResponse.error("添加背景信息发生错误");
	}
}
