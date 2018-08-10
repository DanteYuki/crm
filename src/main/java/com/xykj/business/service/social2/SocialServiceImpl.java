//package com.xykj.business.service.social2;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.xykj.base.dao.BaseJoinSqlDao;
//import com.xykj.base.dao.sys.account.AccountDao;
//import com.xykj.base.entity.sys.account.Account;
//import com.xykj.base.service.BaseServiceImpl;
//import com.xykj.base.service.token.TokenManager;
//import com.xykj.base.util.Page;
//import com.xykj.base.util.UuidUtil;
//import com.xykj.business.dao.social.SocialDao;
//import com.xykj.business.entity.social.Social;
//import com.xykj.business.entity.social.SocialLog;
//import com.xykj.business.service.classManage.ClassStudentService;
//
////@Service("SocialService")
//public class SocialServiceImpl extends BaseServiceImpl<Social> implements SocialService{
//	private final static String excel2003L =".xls";    //2003- 版本的excel  
//	private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
//	@Autowired
//	private SocialDao socialDao;
//	@Autowired
//	private AccountDao accountDao;
//	@Autowired
//	private TokenManager tokenManager;
//	@Autowired
//	private BaseJoinSqlDao baseJoinSqlDao;
//	@Autowired
//	private SocialLogService socialLogService;
//	
//	@Autowired
//	private ClassStudentService classStudentService;
//	
//	@Override
//	public Page<Social> findByPage(Page<Social> page, Social o) {
//		Account account = tokenManager.getCurrentAccount(o.getToken());
//		o.setCampusId(account.getCampusId());
//		return super.findByPage(page, o);
//	}
//
//	
//	@Override
//	public Social find(Social o) {
//		Account account = tokenManager.getCurrentAccount(o.getToken());
//		o.setCampusId(account.getCampusId());
//		return super.find(o);
//	}
//
//
//	/**
//	 * 新增上门量
//	 */
//	@Transactional
//	@Override
//	public void insert(Social o) {
//		o.setId(UuidUtil.get32UUID());
//		String token = o.getToken();
//		Account a = new Account();
//		a.setAccountId(token.split("_")[0]);
//		Account account = accountDao.find(a);
//		//系统当前用户
//		if(account != null) {
//			o.setCreateBy(account.getAccountName());
//		} else {
//			o.setCreateBy("");
//		}
//		//创建时间 格式 为 yyyy-MM-dd
//		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		o.setCreateTime(createTime);
//		o.setCampusId(account.getCampusId());
//		socialDao.insert(o);
//		//插入日志记录
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(createTime);
//		socialLog.setCampusId(o.getCampusId());
//		socialLogService.insert(socialLog);
//	}
//
//	@Transactional
//	@Override
//	public void tryLearn(Social social) {
//		Account account = tokenManager.getCurrentAccount(social.getToken());
//		Social o = socialDao.find(social);
//		
//		o.setIsTry(1);
//		socialDao.delete(o);
//		socialDao.tryLearn(o);
//		//插入日志记录
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		socialLog.setCampusId(o.getCampusId());
//		socialLogService.insert(socialLog);
//	}
//
//	/**
//	 * 报名
//	 */
//	@Transactional
//	@Override
//	public void pay(Social social) {
//		Account account = tokenManager.getCurrentAccount(social.getToken());
//		Social o = socialDao.find(social);
//		
//		o.setIsPay(1);
//		socialDao.delete(o);
//		socialDao.pay(o);
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		socialLog.setCampusId(o.getCampusId());
//		socialLogService.insert(socialLog);
//		
//	}
//
//	@Transactional
//	@Override
//	public void disabled(Social social) {
//		Account account = tokenManager.getCurrentAccount(social.getToken());
//		Social o = socialDao.find(social);
//		o.setStatus(4);
//		socialDao.delete(o);
//		socialDao.disabled(o);
//		
//		SocialLog socialLog = new SocialLog();
//		socialLog.setSocialId(o.getId());
//		socialLog.setSname(o.getSname());
//		socialLog.setSgender(o.getSgender());
//		socialLog.setSage(o.getSage());
//		socialLog.setMobile(o.getMobile());
//		socialLog.setEmail(o.getEmail());
//		socialLog.setQq(o.getQq());
//		socialLog.setWx(o.getWx());
//		socialLog.setArriveTime(o.getArriveTime());
//		socialLog.setEducation(o.getEducation());
//		socialLog.setGraduateYear(o.getGraduateYear());
//		socialLog.setGraduateFrom(o.getGraduateFrom());
//		socialLog.setAddress(o.getAddress());
//		socialLog.setCreateBy(o.getCreateBy());
//		socialLog.setCreateTime(o.getCreateTime());
//		socialLog.setAdvisor(o.getAdvisor());
//		socialLog.setGrade(o.getGrade());
//		socialLog.setJob(o.getJob());
//		socialLog.setFeedback(o.getFeedback());
//		socialLog.setTeacher(o.getTeacher());
//		socialLog.setStatus(o.getStatus());
//		socialLog.setIsTry(o.getIsPay());
//		socialLog.setIsTry(o.getIsTry());
//		socialLog.setOperator(account.getAccountName());
//		socialLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		socialLog.setCampusId(o.getCampusId());
//		socialLogService.insert(socialLog);
//	}
//
//	@Override
//	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		//开发环境
//		String filePath =  request.getSession().getServletContext().getRealPath("demo")+"\\"+"demo.xlsx";
////		System.out.println(filePath);
//		//服务器
////		String filePath = "/root/crm_version1.0/tomcat8/webapps/ruisiyuan/demo/demo.xlsx";
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
//		byte[] buffer = new byte[10240];
//		int len = 0;
//		//设置文件下载头  
//		BufferedOutputStream bous = new BufferedOutputStream(response.getOutputStream());
//		response.setCharacterEncoding("utf-8");
//		response.setHeader("Content-Disposition", "attachment;filename=demo.xlsx");
//        //设置文件ContentType类型，自动判断下载文件类型    
//        response.setContentType("multipart/form-data");
//		
//		while ((len = bis.read(buffer)) != -1) {
//			bous.write(buffer, 0, len);
//			bous.flush();
//		}
//		bis.close();
//		bous.close();
//	}
//
//	/**
//	 * 读取上传Excel文件,可以识别2003,2007各种版本格式
//	 *
//	 * @params
//	 * @return
//	 */
//	@Override
//	public void upload(MultipartFile file,String token) throws Exception {
//		String fileName = file.getOriginalFilename();
//		String fileType = fileName.substring(fileName.lastIndexOf("."));
//		Workbook workbook = null;
//		InputStream in = file.getInputStream();
//		//自适应2003以下或者 2007以上版本的Excel文件格式
//		if(fileType.equals(excel2003L)) {
//			workbook = new HSSFWorkbook(in);
//		} else if (fileType.equals(excel2007U)) {
//			workbook = new XSSFWorkbook(in);
//		}
//		Row row = null;
//		Cell cell = null;
//		if(workbook != null) {
//			//获取学历配置
//			List<Map<String, Object>> educationListMap = baseJoinSqlDao.findByJoinSql("select * from tb_config where ktype = 'education'");
//			//获取简历来源配置
//			List<Map<String, Object>> sourceListMap = baseJoinSqlDao.findByJoinSql("select * from tb_config where ktype = 'source'");
//			//获取咨询师评判等级
//			List<Map<String, Object>> gradeListMap = baseJoinSqlDao.findByJoinSql("select * from tb_config where ktype = 'grade'");
//			//获取面试岗位配置
//			List<Map<String, Object>> occupationListMap = baseJoinSqlDao.findByJoinSql("select * from tb_config where ktype = 'occupation'");
//			//获取所有状态配置
//			List<Map<String, Object>> statusListMap = baseJoinSqlDao.findByJoinSql("select * from tb_config where ktype = 'social_status'");
//			Sheet sheet = workbook.getSheetAt(0);
//			for (int i = 1 ; i <= sheet.getLastRowNum(); i++) {
//				row = sheet.getRow(i);
//				if(row != null) {
//					Social social = new Social();
//					//获取上门人员名称
//					cell = row.getCell(0);
//					if (cell != null) {
//						String sname = cell.getStringCellValue();
//						if (sname != null && !sname.trim().equals("")) {
//							social.setSname(sname);
//						}
//					}
//					//获取上门人年龄
//					cell = row.getCell(1);
//					if (cell != null) {
//						int sage = (int)cell.getNumericCellValue();
//						social.setSage(sage);
//					}
//					//获取上门人性别
//					cell = row.getCell(2);
//					if (cell != null) {
//						String sgender = cell.getStringCellValue();
//						if (sgender != null && !sgender.trim().equals("")) {
//							social.setSgender(sgender);
//						}
//					}
//					//获取 上门人的联系方式
//					cell = row.getCell(3);
//					if (cell != null) {
//						long phone = (long)cell.getNumericCellValue();
//						social.setMobile(String.valueOf(phone));
//					}
//					//获取上门人的email
//					cell = row.getCell(4);
//					if (cell != null) {
//						String email = cell.getStringCellValue();
//						if (email != null && !email.trim().equals("")) {
//							social.setEmail(email);
//						}
//					}
//					//获取 上门人qq号码
//					cell = row.getCell(5);
//					if (cell != null) {
//						long qq = (long)cell.getNumericCellValue();
//						social.setQq(String.valueOf(qq));
//					}
//					//获取 上门的微信号
//					//微信 号 有可能输入的是numeric 有可能输入的是string,要分开处理
//					cell = row.getCell(6);
//					if (cell != null) {
//						switch (cell.getCellType()) {
//							//cellType=0,number类型
//							case 0:
//								long wx1 = (long)cell.getNumericCellValue();
//								social.setWx(String.valueOf(wx1));
//								break;
//							//cellType=1,string类型
//							case 1:
//								String wx2 = cell.getStringCellValue();
//								social.setWx(wx2);
//								break;
//							default :
//								social.setWx("");
//								break;
//						}
//					}
//					//获取 上门人员的登记时间
//					cell = row.getCell(7);
//					if (cell != null) {
//						String arriveTime = cell.getStringCellValue();
//						if (arriveTime != null && !arriveTime.trim().equals("")) {
//							social.setArriveTime(arriveTime);
//						}
//					}
//					//获取上门人员的学历
//					cell = row.getCell(8);
//					if (cell != null) {
//						label : for(Map<String, Object> map : educationListMap) {
//							if (map.get("kvalue").equals(cell.getStringCellValue())) {
//								social.setEducation((int)map.get("kkey"));
//								break label;
//							}
//						}
//					}
//					//获取上门人员毕业年限
//					cell = row.getCell(9);
//					if (cell != null) {
//						social.setGraduateYear((int)cell.getNumericCellValue());
//					}
//					//获取 上门人员毕业学校
//					cell = row.getCell(10);
//					if (cell != null) {
//						String graduateFrom = cell.getStringCellValue();
//						if (graduateFrom != null && !graduateFrom.trim().equals("")) {
//							social.setGraduateFrom(graduateFrom);
//						}
//					}
//					//获取上门人员地址
//					cell = row.getCell(11);
//					if (cell != null) {
//						String address = cell.getStringCellValue();
//						if (address != null && !address.trim().equals("")) {
//							social.setAddress(address);
//						}
//					}
//					//获取上门人员对应的咨询师
//					cell = row.getCell(12);
//					if (cell != null) {
//						String advisor = cell.getStringCellValue();
//						if (advisor != null && !advisor.trim().equals("")) {
//							social.setAdvisor(advisor);
//						}
//					}
//					//获取上门人员的简历来源
//					cell = row.getCell(13);
//					if (cell != null) {
//						label : for (Map<String, Object> map : sourceListMap) {
//							if (map.get("kvalue").equals(cell.getStringCellValue())) {
//								social.setSource((int)map.get("kkey"));
//								break label;
//							}
//						}
//					}
//					//获取咨询师评判等级
//					cell = row.getCell(14);
//					if (cell != null) {
//						label : for (Map<String, Object> map : gradeListMap) {
//							if (map.get("kvalue").equals(cell.getStringCellValue())) {
//								social.setGrade((int)map.get("kkey"));
//								break label;
//							}
//						}
//					}
//					//获取上门人员前来面试岗位
//					cell = row.getCell(15);
//					if (cell != null) {
//						label : for (Map<String, Object> map : occupationListMap) {
//							if (map.get("kvalue").equals(cell.getStringCellValue())) {
//								social.setJob((int)map.get("kkey"));
//								break label;
//							}
//						}
//					}
//					//获取邀约上门人员的工作人员
//					cell = row.getCell(16);
//					if (cell != null) {
//						String invitor = cell.getStringCellValue();
//						if (invitor != null && !invitor.trim().equals("")) {
//							social.setInvitor(invitor);
//						}
//					}
//					//获取咨询师对该上门人员的反馈
//					cell = row.getCell(17);
//					if (cell != null) {
//						String feedback = cell.getStringCellValue();
//						if (feedback != null && !feedback.trim().equals("")) {
//							social.setFeedback(feedback);
//						}
//					}
//					//获取视听老师名字
//					cell = row.getCell(18);
//					if (cell != null) {
//						String teacher = cell.getStringCellValue();
//						if (teacher != null && !teacher.trim().equals("")) {
//							social.setTeacher(teacher);
//						}
//					}
//					//获取上门人员目前状态
//					cell = row.getCell(19);
//					if (cell != null) {
//						System.out.println(cell.getStringCellValue());
//						label : for (Map<String, Object> map : statusListMap) {
//							if (map.get("kvalue").equals(cell.getStringCellValue())) {
//								social.setStatus((int)map.get("kkey"));
//								break label;
//							}
//						}
//					}
//					//获取是否参与试学
//					cell = row.getCell(20);
//					if (cell != null) {
//						System.out.println(cell.getStringCellValue());
//						int isTry = cell.getStringCellValue().trim().equals("是")? 1 : 0;
//						social.setIsTry(isTry);
//					}
//					//获取是否报名
//					cell = row.getCell(21);
//					if (cell != null) {
//						System.out.println(cell.getStringCellValue());
//						int isPay = cell.getStringCellValue().trim().equals("是")? 1 : 0;
//						social.setIsPay(isPay);
//					}
//					social.setId(UuidUtil.get32UUID());
//					social.setToken(token);
//					Account account = tokenManager.getCurrentAccount(token);
//					social.setCampusId(account.getCampusId());
//					//判断是否有重复,通过电话号码
//					if (isDumplicated(social)) {
//						social = socialDao.findByPhone(social);
//						social.setUpdateBy(account.getAccountName());
//						social.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//						socialDao.update(social);
//					} else {
//						social.setAdvisor(account.getAccountName());
//						socialDao.insert(social);
//					}
//				}
//			}
//		}
//		if (in != null) {
//			in.close();
//		}
//	}
//
//	@Override
//	public boolean isDumplicated(Social social) {
//		Social o = socialDao.findByPhone(social);
//		return o == null ? false : true;
//	}
//	
//}
