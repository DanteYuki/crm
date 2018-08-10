package com.xykj.business.service.classManage;

import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jxl.CellType;

@Service("AttendanceService")
public class AttendanceServiceImpl implements AttendanceService{

	private final static String excel2003L =".xls";    //2003- 版本的excel  
	private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
	/**
	 * 读取上传Excel
	 */
	@Override
	public void readExcel(MultipartFile file) throws Exception {
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
		if (workbook != null) {
			Sheet sheet = workbook.getSheetAt(0);
			//遍历Sheet中每一行
			for(int i = sheet.getFirstRowNum();i <= sheet.getLastRowNum() ;i++) {
//			for(int i = 8;i <= 23;i++) {
				if((i % 25 >= 8) && (i % 25 <= 23)) {
					//获取 每个单元格
					row = sheet.getRow(i);
					System.out.println("第" + i + "行数据");
					for(int j = row.getFirstCellNum();j <= row.getLastCellNum();j++) {
						cell = row.getCell(j);
						if(cell != null) {
							switch (cell.getCellType()) {
								case 0 :
									System.out.print(j + "," + cell.getDateCellValue() + '\t');
									break;
								case 1 :
									String cellString = "";
									SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
									if (cell.getStringCellValue().endsWith("*")) {
										cellString = cell.getStringCellValue().substring(0, cell.getStringCellValue().indexOf("*"));
										System.out.print(j + "," + sdf.parse(cellString) + '\t');
										continue;
									} else if (cell.getStringCellValue().indexOf(":") != -1){
										System.out.print(j + "," + cell.getDateCellValue() + '\t');
										continue;
									} else {
										cellString = cell.getStringCellValue();
										System.out.print(j + "," + cellString + '\t');
										continue;
									}
								default :
									System.out.print(j + "," + '\t');
									break;
							}
						}
					}
					System.out.println();
				}
			}
		}
		if(in != null) {
			in.close();
		}
	}


}
