package com.xykj.business.controller.occupation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.occupation.Occupation;
import com.xykj.business.service.occupation.OccupationService;

@Controller
@RequestMapping("/backstage/occupation/")
public class OccupationController extends BaseController<Occupation>{
	@Autowired
	private OccupationService occupationService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Occupation> page, Occupation occupation) {
        try {
            Page<Occupation> pageModel = occupationService.findByPage(page, occupation);
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
    public RsyResponse add(Occupation occupation) {
        try {
        	occupationService.insert(occupation);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Occupation occupation) {
        try {
        	occupationService.delete(occupation);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Occupation occupation) {
        try {
        	occupationService.update(occupation);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Occupation occupation) {
        try {
        	Occupation p = occupationService.find(occupation);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
