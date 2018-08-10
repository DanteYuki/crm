package com.xykj.business.controller.financial;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.financial.Allowance;
import com.xykj.business.service.financial.AllowanceService;

@Controller
@RequestMapping("/backstage/allowance/")
public class AllowanceController extends BaseController<Allowance>{
	@Autowired
	private AllowanceService allowanceService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<Allowance> page, Allowance allowance) {
        try {
            Page<Allowance> pageModel = allowanceService.findByPage(page, allowance);
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
    public RsyResponse add(Allowance allowance) {
        try {
        	allowanceService.insert(allowance);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(Allowance allowance) {
        try {
        	allowanceService.delete(allowance);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(Allowance allowance) {
        try {
        	allowanceService.update(allowance);
            return RsyResponse.success("更新成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新失败");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(Allowance allowance) {
        try {
        	Allowance p = allowanceService.find(allowance);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
