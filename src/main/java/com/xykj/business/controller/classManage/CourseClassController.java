package com.xykj.business.controller.classManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.classManage.CourseClass;
import com.xykj.business.service.classManage.CourseClassService;

@Controller
@RequestMapping("/backstage/classManage/")
public class CourseClassController extends BaseController<CourseClass>{
	@Autowired
	private CourseClassService courseClassService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<CourseClass> page, CourseClass courseClass) {
        try {
            Page<CourseClass> pageModel = courseClassService.findByPage(page, courseClass);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {

        }

        return RsyResponse.error("");
    }
	
	//添加
    @RequestMapping(value = "insert")
    @ResponseBody
    public RsyResponse add(CourseClass courseClass) {
        try {
        	courseClassService.insert(courseClass);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(CourseClass courseClass) {
        try {
        	courseClassService.delete(courseClass);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(CourseClass courseClass) {
        try {
        	courseClassService.update(courseClass);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "findOne")
    @ResponseBody
    public RsyResponse find(CourseClass courseClass) {
        try {
        	CourseClass p = courseClassService.find(courseClass);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse findOne(CourseClass courseClass) {
    	try {
    		List<CourseClass> list = courseClassService.findOne(courseClass);
    		return RsyResponse.success("", list.get(0));
    	} catch (Exception e) {
    		
    	}
    	return RsyResponse.error("查询失败");
    }
}
