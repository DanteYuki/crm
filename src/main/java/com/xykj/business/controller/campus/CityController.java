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
import com.xykj.business.entity.campus.City;
import com.xykj.business.service.city.CityService;

@Controller
@RequestMapping("/backstage/city/")
public class CityController extends BaseController<City>{
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<City> page, City city) {
        try {
            Page<City> pageModel = cityService.findByPage(page, city);
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
    public RsyResponse add(City city) {
        try {
            cityService.insert(city);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(City city) {
        try {
            cityService.delete(city);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(City city) {
        try {
            cityService.update(city);
            return RsyResponse.success("更新成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新失败");
    }

    //查询单个
    @RequestMapping(value = {"find"})
    @ResponseBody
    public RsyResponse find(City city) {
        try {
        	City p = cityService.find(city);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    @RequestMapping(value = {"findAllCity"},method = {RequestMethod.GET})
    @ResponseBody
    public RsyResponse findAllCity() {
    	try {
    		List<City> list = cityService.findAllCity();
			Map<String,Map<String,Object>> map = new HashMap<>();
			Map<String, Object> map1 = new HashMap<>();
			map1.put("results", list);
			map.put("list", map1);
			return RsyResponse.success("获取所有城市成功", map);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return RsyResponse.error("获取城市发生错误");
    }
}
