package com.xykj.business.controller.channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.channel.Contact;
import com.xykj.business.entity.channel.School;
import com.xykj.business.service.channel.SchoolService;

@Controller
@RequestMapping("/backstage/school/")
public class SchoolController extends BaseController<School>{
	
	@Autowired
	private SchoolService schoolService;
	@InitBinder("school")
	private void initBindFormData1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("school.");
	};
	@InitBinder("contact")
	private void initBindFormData2(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("contact.");
	}
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<School> page, School school) {
        try {
            Page<School> pageModel = schoolService.findByPage(page, school);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", pageModel);
            return RsyResponse.success("", map);
        } catch (Exception e) {

        }

        return RsyResponse.error("");
    }
	
	//添加
    @RequestMapping(value = "insert",method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse add(School school) {
        try {
        	System.out.println(school.getToken());
        	System.out.println(school.getSchoolName() + "," + school.getAddress() + "," + school.getFee());
        	
        	schoolService.insert(school);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(School school) {
        try {
        	schoolService.delete(school);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(School school) {
        try {
        	schoolService.update(school);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(School school) {
        try {
        	School p = schoolService.find(school);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    //查询所有学校
    @RequestMapping(value = "findSchools")
    @ResponseBody
    public RsyResponse findSchools() {
        try {
        	List<School> list = schoolService.findSchools();
            return RsyResponse.success("", list);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    //添加联系人
    @RequestMapping(value = {"insertContact"},method = {RequestMethod.POST})
    @ResponseBody
    public RsyResponse insertContact (School school,Contact contact) {
    	try {
			schoolService.insertContact(school, contact);
			return RsyResponse.success("添加联系人成功");
		} catch (Exception e) {
		}
    	return RsyResponse.error("添加操作发生错误");
    }
}
