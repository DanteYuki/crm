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
import com.xykj.business.entity.classManage.StepIntoClass;
import com.xykj.business.service.classManage.StepIntoClassService;

@Controller
@RequestMapping("/backstage/stepIntoClass/")
public class StepIntoClassController extends BaseController<StepIntoClass>{
	@Autowired
	private StepIntoClassService stepIntoClassService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<StepIntoClass> page, StepIntoClass stepIntoClass) {
        try {
            Page<StepIntoClass> pageModel = stepIntoClassService.findByPage(page, stepIntoClass);
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
    public RsyResponse add(StepIntoClass stepIntoClass) {
        try {
        	stepIntoClassService.insert(stepIntoClass);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(StepIntoClass stepIntoClass) {
        try {
        	stepIntoClassService.delete(stepIntoClass);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(StepIntoClass stepIntoClass) {
        try {
        	stepIntoClassService.update(stepIntoClass);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(StepIntoClass stepIntoClass) {
        try {
        	StepIntoClass p = stepIntoClassService.find(stepIntoClass);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
