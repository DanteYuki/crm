package com.xykj.business.controller.attendance;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.xykj.base.commom.RsyResponse;
import com.xykj.business.service.attendance.AttendanceService;

@Controller
@RequestMapping("/backstage/attendance/")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping(value = {"upload"},method = {RequestMethod.POST})
	@ResponseBody
	public RsyResponse upload(@RequestParam("file")MultipartFile file) throws Exception{
		try {
			attendanceService.readExcel(file);
		} catch (Exception e) {
			e.printStackTrace();
			return RsyResponse.error("上传文件发生异常");
		}
		return RsyResponse.success("上传文件成功");
	}
}
