package com.xykj.business.service.attendance;

import org.springframework.web.multipart.MultipartFile;


public interface AttendanceService {
	
	public void readExcel(MultipartFile file) throws Exception;
	
}
