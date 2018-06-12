package com.xykj.business.controller.reputation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.reputation.Reputation;
import com.xykj.business.service.reputation.ReputationService;

@Controller
@RequestMapping("/backstage/reputation/")
public class ReputationController extends BaseController<Reputation>{
	@Autowired
	private ReputationService reputationService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Reputation> page, Reputation reputation) {
        try {
            Page<Reputation> pageModel = reputationService.findByPage(page, reputation);
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
    public RsyResponse add(Reputation reputation) {
        try {
        	reputationService.insert(reputation);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Reputation reputation) {
        try {
        	reputationService.delete(reputation);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Reputation reputation) {
        try {
        	reputationService.update(reputation);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Reputation reputation) {
        try {
        	Reputation p = reputationService.find(reputation);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
