package com.xykj.business.controller.classManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xykj.base.commom.RsyResponse;
import com.xykj.base.controller.BaseController;
import com.xykj.base.util.Page;
import com.xykj.business.entity.classManage.StudentException;
import com.xykj.business.service.classManage.StudentExceptionService;

@Controller
@RequestMapping("/backstage/studentException/")
public class StudentExceptionController extends BaseController<StudentException>{
	@Autowired
	private StudentExceptionService studentExceptionService;
	
	@RequestMapping(value = "findByPage")
    @ResponseBody
    public RsyResponse findByPage(Page<StudentException> page, StudentException studentException) {
        try {
            Page<StudentException> pageModel = studentExceptionService.findByPage(page, studentException);
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
    public RsyResponse add(StudentException studentException) {
        try {
        	studentExceptionService.insert(studentException);
            return RsyResponse.success("添加成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("添加失败");
    }

    //删除
    @RequestMapping(value = "delete")
    @ResponseBody
    public RsyResponse delete(StudentException studentException) {
        try {
        	studentExceptionService.delete(studentException);
            return RsyResponse.success("删除成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("删除失败");
    }

    //修改
    @RequestMapping(value = "update")
    @ResponseBody
    public RsyResponse update(StudentException studentException) {
        try {
        	studentExceptionService.update(studentException);
            return RsyResponse.success("更新成功");
        } catch (Exception e) {

        }
        return RsyResponse.error("更新失败");
    }

    //查询单个
    @RequestMapping(value = {"find"})
    @ResponseBody
    public RsyResponse find(StudentException studentException) {
        try {
        	StudentException p = studentExceptionService.find(studentException);
            return RsyResponse.success("", p);
        } catch (Exception e) {

        }
        return RsyResponse.error("查询失败");
    }
    
    /**
     * 获取学生个人学分信息
     *
     * @params
     * @return
     */
    @RequestMapping(value={"findScoreException"},method={RequestMethod.GET})
    @ResponseBody
    public RsyResponse findScoreException(StudentException studentException) {
    	try {
			List<StudentException> list = studentExceptionService.findScoreException(studentException.getStudentId());
			return RsyResponse.success("获取学分信息成功", list);
		} catch (Exception e) {
		}
    	return RsyResponse.error("获取学分信息错误");
    }

}
