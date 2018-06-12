package com.xykj.business.controller.social;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.social.Social;
import com.xykj.business.service.social.SocialService;

@Controller
@RequestMapping("/backstage/social/")
public class SocialController extends BaseController<Social>{
	@Autowired
	private SocialService socialService;
	
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

        return RsyResponse.error("");
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
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
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
}
