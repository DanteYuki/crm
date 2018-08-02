package com.xykj.business.service.classManage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xykj.base.dao.BaseJoinSqlDao;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.BaseServiceImpl;
import com.xykj.base.service.token.TokenManager;
import com.xykj.base.util.Page;
import com.xykj.base.util.UuidUtil;
import com.xykj.business.dao.classManage.ClassStudentDao;
import com.xykj.business.dao.classManage.CourseClassDao;
import com.xykj.business.dao.classManage.StudentExceptionDao;
import com.xykj.business.entity.classManage.ClassStudent;
import com.xykj.business.entity.classManage.CourseClass;
import com.xykj.business.entity.classManage.StudentException;

@Service("ClassStudentService")
public class ClassStudentServiceImpl extends BaseServiceImpl<ClassStudent> implements ClassStudentService{

	private final static String excel2003L =".xls";    //2003- 版本的excel  
	private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
	
	@Autowired
	private ClassStudentDao classStudentDao;
	@Autowired
	private StudentExceptionDao studentExceptionDao;
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private BaseJoinSqlDao baseJoinSqlDao;
	@Autowired
	private CourseClassDao courseClassDao;
	
	
	@Override
	public Page<ClassStudent> findByPage(Page<ClassStudent> page, ClassStudent o) {
		String token = o.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		String campusId = account.getCampusId();
		o.setCampusId(campusId);
		return super.findByPage(page, o);
	}

	@Override
	public void insert(ClassStudent o) {
		o.setId(UuidUtil.get32UUID());
		o.setStatus(1);
		classStudentDao.insert(o);
	}
	
	/**
	 * 多学员跨学区调往同一个班级
	 */
	@Transactional
	@Override
	public void moveBatch(String ids, String classId) {
		if (ids != null && !ids.trim().equals("")) {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				ClassStudent classStudent = new ClassStudent();
				classStudent.setId(id);
				//查询学生信息
				classStudent = classStudentDao.find(classStudent);
				classStudent.setClassId(classId);
				//重新绑定ID
//				classStudent.setId(UuidUtil.get32UUID());
				//需要处理原班级信息?
				classStudentDao.delete(classStudent);
				//插入新班级资料
				classStudentDao.insert(classStudent);
			}
		}
	}

	/**
	 * 扣学分
	 */
	@Transactional
	@Override
	public void decreaseCredit(ClassStudent classStudent,StudentException studentException) {
		
		String token = classStudent.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		ClassStudent o = classStudentDao.find(classStudent);
		//修改学生现有学分
		o.setCredit(0 - classStudent.getCredit());
		classStudentDao.changeCredit(o); 
		//记录异常
		
		//异常学员ID
		studentException.setStudentId(o.getId());
		//异常类型
		studentException.setEtype(1);
		//之前班级
		studentException.setClassBefore(o.getClassId());
		//之后班级
		studentException.setClassAfter(o.getClassId());
		//operator
		studentException.setOperator(account.getRealName());
		//时间设置
		studentException.seteTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentException.setdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		studentExceptionDao.insert(studentException);
	}

	/**
	 * 加学分
	 */
	@Transactional
	@Override
	public void increaseCredit(ClassStudent classStudent,StudentException studentException) {
		String token = classStudent.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		ClassStudent o = classStudentDao.find(classStudent);
		o.setCredit(classStudent.getCredit());
		//修改学生现有学分
		classStudentDao.changeCredit(o);
		//记录异常
		//设置ID
		studentException.setStudentId(o.getId());
		//设置异常类型
		studentException.setEtype(2);
		//设置之前班级
		studentException.setClassBefore(o.getClassId());
		//设置之后班级
		studentException.setClassAfter(o.getClassId());
		//设置操作者
		studentException.setOperator(account.getRealName());
		//设置异常时间
		studentException.seteTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentException.setdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentExceptionDao.insert(studentException);
	}

	/**
	 * 留级或者转班
	 */
	@Transactional
	@Override
	public void downNext(ClassStudent classStudent, String classId,StudentException studentException) {
		String token = classStudent.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		ClassStudent o = classStudentDao.find(classStudent);
		//留级4,转班3
		//设置异常类型(转班或者留级需要传入异常类型studentException.etype)
		if (studentException.getEtype() == 3) {
			classStudent.setStatus(6);
		} else if (studentException.getEtype() == 4) {
			classStudent.setStatus(4);
		}
		
		
		classStudentDao.downNext(o, classId);
		//记录异常
		//设置ID
		studentException.setStudentId(o.getId());
		//设置之前班级
		studentException.setClassBefore(o.getClassId());
		//设置之后班级
		studentException.setClassAfter(classId);
		//设置操作者
		studentException.setOperator(account.getRealName());
		//设置异常时间
		studentException.seteTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentException.setdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentExceptionDao.insert(studentException);
	}

	/**
	 * 退学
	 */
	@Transactional
	@Override
	public void quit(ClassStudent classStudent,StudentException studentException) {
		String token = classStudent.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		ClassStudent o = classStudentDao.find(classStudent);
		o.setStatus(2);
		//退学
		classStudentDao.quit(o);
		//记录异常
		//设置ID
		studentException.setStudentId(o.getId());
		//设置异常类型
		studentException.setEtype(5);
		//设置之前班级
		studentException.setClassBefore(o.getClassId());
		//设置之后班级
		studentException.setClassAfter("");
		//设置操作者
		studentException.setOperator(account.getRealName());
		//设置异常时间
		studentException.seteTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentException.setdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentExceptionDao.insert(studentException);
	}

	/**
	 * 休学
	 */
	@Transactional
	@Override
	public void pause(ClassStudent classStudent,StudentException studentException) {
		String token = classStudent.getToken();
		Account account = tokenManager.getCurrentAccount(token);
		ClassStudent o = classStudentDao.find(classStudent);
		classStudentDao.quit(o);
		o.setStatus(3);
		//设置ID
		studentException.setStudentId(o.getId());
		//设置异常类型
		studentException.setEtype(6);
		//设置之前班级
		studentException.setClassBefore(o.getClassId());
		//设置之后班级
		studentException.setClassAfter("");
		//设置操作者
		studentException.setOperator(account.getRealName());
		//设置异常时间
		studentException.seteTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentException.setdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		studentExceptionDao.insert(studentException);
	}

	/**
	 * 上传阶段考试成绩
	 */
	@Override
	public void importExcel(MultipartFile file, String token,int signal) throws Exception {
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		Workbook workbook = null;
		InputStream in = file.getInputStream();
		//自适应2003以下或者 2007以上版本的Excel文件格式
		if(fileType.equals(excel2003L)) {
			workbook = new HSSFWorkbook(in);
		} else if (fileType.equals(excel2007U)) {
			workbook = new XSSFWorkbook(in);
		}
		Row row = null;
		Cell cell = null;
		//读取工作薄
		if (workbook != null) {
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1 ;i < sheet.getLastRowNum(); i++) {
				//读取行记录
				row = sheet.getRow(i);
				//获取 电话号码
				String phoneNumber = row.getCell(1).getStringCellValue();
				//获取 当次考试 成绩
				double score = row.getCell(2).getNumericCellValue();
				//根据电话获取 用户信息
				ClassStudent classStudent = classStudentDao.findByPhoneNumber(phoneNumber);
				if (signal == 1) {
					classStudent.setFirstScore(score);
					classStudentDao.insertFirst(classStudent);
				} else if (signal == 2) {
					classStudent.setSecondScore(score);
					classStudentDao.insertSecond(classStudent);
				} else if (signal == 3){
					classStudent.setThirdScore(score);
					classStudentDao.insertThird(classStudent);
				}
			}
		}
	}

	/**
	 * 导出该班空白成绩单
	 */
	@Override
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String classId) throws Exception {
		CourseClass courseClass = new CourseClass();
		courseClass.setId(classId);
		courseClass = courseClassDao.find(courseClass);
		//查询班级所有学生数据
		List<Map<String, Object>> mapList = baseJoinSqlDao.findByJoinSql("select * from tb_class_student where classId = '" + classId + "'");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		//创建表头
		XSSFRow headRow = sheet.createRow(0);
		//三列
		XSSFCell cell1 = headRow.createCell(0);
		XSSFCell cell2 = headRow.createCell(1);
		XSSFCell cell3 = headRow.createCell(2);
		cell1.setCellValue("学生姓名");
		cell2.setCellValue("学生电话");
		cell3.setCellValue("成绩");
		XSSFRow eveRow = null;
		XSSFCell firstCell = null;
		XSSFCell secondCell = null;
		XSSFCell thirdCell = null;
		int count = 1;
		for (Map<String, Object> map : mapList) {
			//学生姓名
			String studentName = (String)map.get("name");
			//学生电话号码
			String mobile = (String)map.get("mobile");
			eveRow = sheet.createRow(count++);
			//每 一行创建三个列
			firstCell = eveRow.createCell(0);
			firstCell.setCellValue(studentName);
			secondCell = eveRow.createCell(1);
			secondCell.setCellValue(mobile);
			thirdCell = eveRow.createCell(2);
			thirdCell.setCellValue("");
		}
		
		//设置文件下载头  
		BufferedOutputStream bous = new BufferedOutputStream(response.getOutputStream());
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + courseClass.getClassName() + ".xlsx");
        //设置文件ContentType类型，自动判断下载文件类型    
        response.setContentType("multipart/form-data");
		
		workbook.write(bous);
		bous.close();
	}

	@Override
	public void importInterview(MultipartFile file, String token, int signal) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportInterview(HttpServletRequest request, HttpServletResponse response, String classId)
			throws Exception {

		CourseClass courseClass = new CourseClass();
		courseClass.setId(classId);
		courseClass = courseClassDao.find(courseClass);
		//查询班级所有学生数据
		List<Map<String, Object>> mapList = baseJoinSqlDao.findByJoinSql("select * from tb_class_student where classId = '" + classId + "'");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		//创建表头
		XSSFRow headRow = sheet.createRow(0);
		Cell cell0 = headRow.createCell(0);
		Cell cell1 = headRow.createCell(1);
		Cell cell2 = headRow.createCell(2);
		Cell cell3 = headRow.createCell(3);
		Cell cell4 = headRow.createCell(4);
		Cell cell5 = headRow.createCell(5);
		Cell cell6 = headRow.createCell(6);
		Cell cell7 = headRow.createCell(7);
		Cell cell8 = headRow.createCell(8);
		Cell cell9 = headRow.createCell(9);
		Cell cell10 = headRow.createCell(10);
		Cell cell11 = headRow.createCell(11);
		Cell cell12 = headRow.createCell(12);
		Cell cell13 = headRow.createCell(13);
		Cell cell14 = headRow.createCell(14);
		
		//设置表头的值
		cell0.setCellValue("学生姓名");
		cell1.setCellValue("年龄");
		cell2.setCellValue("性别");
		cell3.setCellValue("电话");
		cell4.setCellValue("QQ");
		cell5.setCellValue("微信");
		cell6.setCellValue("学历");
		cell7.setCellValue("备注");
		cell8.setCellValue("班级名称");
		cell9.setCellValue("咨询反馈");
		cell10.setCellValue("试学反馈");
		cell11.setCellValue("第一次面试反馈");
		cell12.setCellValue("第一次面试成绩");
		cell13.setCellValue("第二次面试反馈");
		cell14.setCellValue("第二次面试成绩");
		
		//读取mapList中的内容
		int count = 1;
		for (Map<String, Object> map : mapList) {
			//学生姓名 
			String studentName = (String) map.get("name");
			//年龄
//			int age = map.get("")
		}
	}
	
	
}
