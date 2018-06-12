package com.xykj.business.controller.campus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.campus.Campus;
import com.xykj.business.service.city.CampusService;

@Controller
@RequestMapping("/backstage/campus/")
public class CampusController extends BaseController<Campus>{
	@Autowired
	private CampusService campusService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Campus> page, Campus campus) {
        try {
            Page<Campus> pageModel = campusService.findByPage(page, campus);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {

        }

        return RsyResponse.error("");
    }
	
	@RequestMapping(
		value = {"findByCity"},
		method = {RequestMethod.GET}
	)
	@ResponseBody
	public RsyResponse findByCity(Campus campus){
		List<Campus> list = null;
		try {
			list = campusService.findCampusByCity(campus);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("查询出错了");
		}
		return RsyResponse.success("查询成功",list);
	}
	
	//添加
    @RequestMapping(value = "insert")
    @ResponseBody
    public RsyResponse add(Campus campus) {
        try {
        	campusService.insert(campus);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Campus campus) {
        try {
        	campusService.delete(campus);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Campus campus) {
        try {
        	campusService.update(campus);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Campus campus) {
        try {
        	Campus p = campusService.find(campus);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
