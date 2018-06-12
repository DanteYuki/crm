package com.xykj.business.controller.classManage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.service.classManage.ClassStudentService;

@Controller
@RequestMapping("/backstage/classStudent/")
public class ClassStudentController extends BaseController<ClassStudent>{
	@Autowired
	private ClassStudentService classStudentService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<ClassStudent> page, ClassStudent classStudent) {
        try {
            Page<ClassStudent> pageModel = classStudentService.findByPage(page, classStudent);
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
}
