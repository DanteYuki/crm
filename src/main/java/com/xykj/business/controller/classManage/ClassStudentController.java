package com.xykj.business.controller.classManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.entity.classManage.StudentException;
import com.xykj.business.entity.classManage.Talk;
import com.xykj.business.service.classManage.ClassStudentService;
import com.xykj.business.service.classManage.TalkService;

/**
 * 班主任日常工作接口
 * @author dante
 * @2018年7月5日
 */
@Controller
@RequestMapping("/backstage/classStudent/")
public class ClassStudentController extends BaseController<ClassStudent>{
	@Autowired
	private ClassStudentService classStudentService;
	@Autowired
	private TalkService talkService;
	
	//页面pojo绑定
	@InitBinder("talk")
	private void initDataBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("talk.");
	}
	@InitBinder("studentException")
	private void initDataBinder2(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("studentException.");
	}
	@InitBinder("classStudent")
	private void initDataBinder3(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("student.");
	}
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<ClassStudent> page, ClassStudent classStudent) {
        try {
            Page<ClassStudent> pageModel = classStudentService.findByPage(page, classStudent);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return RsyResponse.error("");
    }
	
	//添加
    @RequestMapping(value = "insert")
    @ResponseBody
    public RsyResponse add(ClassStudent classStudent) {
        try {
        	classStudentService.insert(classStudent);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(ClassStudent classStudent) {
        try {
        	classStudentService.delete(classStudent);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(ClassStudent classStudent) {
        try {
        	classStudentService.update(classStudent);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(ClassStudent classStudent) {
        try {
        	ClassStudent p = classStudentService.find(classStudent);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    //多学员跨校区调动
    @RequestMapping(value = {"moveBatch"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse moveBatch(@RequestParam("ids")String ids,@RequestParam("classId")String classId) {
    	try {
			classStudentService.moveBatch(ids, classId);
			return RsyResponse.success("调动成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("学员调动发生错误,请检查");
    }
    
    /**
     * 班主任谈话
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"talk"} , method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse talk(Talk talk,ClassStudent classStudent) {
    	try {
    		talkService.talk(talk, classStudent.getId());
			return RsyResponse.success("谈话记录成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("谈话记录发生错误");
    }
    
    @RequestMapping(value = {"getTalk"},method = {RequestMethod.GET})
    @ResponseBody
    public RsyResponse getTalkById(ClassStudent classStudent) {
    	try {
			List<Talk> list = talkService.findTalkById(classStudent.getId());
			return RsyResponse.success("获取记录成功", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("获取记录发生错误");
    }
    
    /**
     * 扣学分
     */
    @RequestMapping(value = {"decrease"} , method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse decrease(ClassStudent classStudent,StudentException studentException) {
    	try {
			classStudentService.decreaseCredit(classStudent,studentException);
			return RsyResponse.success("扣分完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("操作发生异常");
    }
    
    /**
     * 加学分
     */
    @RequestMapping(value = {"increase"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse increase(ClassStudent classStudent,StudentException studentException) {
		try {
			classStudentService.increaseCredit(classStudent, studentException);
			return RsyResponse.success("加分完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RsyResponse.error("操作发生异常");
    }
    
    /**
     * 转班 留级
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"downNext"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse downNext(ClassStudent classStudent,@RequestParam("class_id")String classId,StudentException studentException) {
    	try {
			classStudentService.downNext(classStudent, classId, studentException);
			return RsyResponse.success("转班成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("转班操作异常");
    }
    
    /**
     * 休学
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"pause"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse pause(ClassStudent classStudent,StudentException studentException){
    	try {
			classStudentService.pause(classStudent, studentException);
			return RsyResponse.success("休学办理成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("休学操作异常");
    }
    
    /**
     * 退学
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"quit"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse quit(ClassStudent classStudent,StudentException studentException) {
    	try {
			classStudentService.quit(classStudent, studentException);
			return RsyResponse.success("退学办理成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("退学操作异常");
    }
    
    @RequestMapping(value = {"export"} , method = {RequestMethod.GET})
    public void export(HttpServletRequest request,HttpServletResponse response,@RequestParam("classId")String classId) {
    	try {
			classStudentService.exportExcel(request,response,classId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = {"importFile"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse importExcel (HttpServletRequest request,HttpServletResponse response,
    		@RequestParam("scoreFile")MultipartFile file,@RequestParam("token")String token,@RequestParam("signal")int signal) {
    	try {
			classStudentService.importExcel(file, token, signal);
			return RsyResponse.success("上传文件成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RsyResponse.error("上传文件失败");
    }
}
