package com.xykj.base.controller.sys.config;

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
import com.xykj.base.entity.sys.config.Config;
import com.xykj.base.service.sys.config.ConfigService;
import com.xykj.base.util.Page;

@Controller
@RequestMapping("/backstage/config/")
public class ConfigController extends BaseController<Config>{
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Config> page, Config config) {
        try {
            Page<Config> pageModel = configService.findByPage(page, config);
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
    public RsyResponse add(Config config) {
        try {
        	configService.insert(config);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Config config) {
        try {
        	configService.delete(config);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Config config) {
        try {
        	configService.update(config);
            return RsyResponse.success("更新成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新失败");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Config config) {
        try {
        	Config p = configService.find(config);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    /**
     * 获取配置文件
     *
     * @params
     * @return
     */
    @RequestMapping(value = {"findConfigs"} , method = {RequestMethod.GET})
    @ResponseBody
    public RsyResponse findEducation(Config config) {
    	try {
			List<Config> configs = configService.findConfigs(config);
			return RsyResponse.success("获取成功",configs);
		} catch (Exception e) {
		}
    	return RsyResponse.error("获取失败");
    }
}
