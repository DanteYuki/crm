package com.xykj.business.controller.channel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.channel.ChannelStudent;
import com.xykj.business.service.channel.ChannelStudentService;

@Controller
@RequestMapping("/backstage/channelStudent/")
public class ChannelStudentController extends BaseController<ChannelStudent>{
	@Autowired
	private ChannelStudentService channelStudentService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<ChannelStudent> page, ChannelStudent channelStudent) {
        try {
            Page<ChannelStudent> pageModel = channelStudentService.findByPage(page, channelStudent);
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
    public RsyResponse add(ChannelStudent channelStudent,@RequestParam("classId")String classId) {
        try {
        	channelStudentService.insertStudent(channelStudent, classId);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(ChannelStudent channelStudent) {
        try {
        	channelStudentService.delete(channelStudent);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(ChannelStudent channelStudent) {
        try {
        	channelStudentService.update(channelStudent);
            return RsyResponse.success("更新失败");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新成功");
    }

    //查询单个
    @RequestMapping(value = "find")
    @ResponseBody
    public RsyResponse find(ChannelStudent channelStudent) {
        try {
        	ChannelStudent p = channelStudentService.find(channelStudent);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
}
