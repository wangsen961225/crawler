package com.zsx.crawler.utils.ExcelTools;

import com.zsx.crawler.pojo.CompanyInfo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelAppendContentUtil {
    public static void appendContent(CompanyInfo companyInfo) throws Exception {
        FileInputStream fs=new FileInputStream("C:\\Users\\Administrator\\Desktop\\CompanyInfoExcel\\test.xls");  //获取表
        POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
        HSSFWorkbook wb=new HSSFWorkbook(ps);
        HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
        HSSFRow row=sheet.getRow(0);  //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
//        System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());  //分别得到最后一行的行号，和一条记录的最后一个单元格

        FileOutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\CompanyInfoExcel\\test.xls");  //向表中写数据
        row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
        row.createCell(0).setCellValue(companyInfo.getCompanyName()); //设置第一个（从0开始）单元格的数据
        row.createCell(1).setCellValue(companyInfo.getLegalPerson());
        row.createCell(2).setCellValue(companyInfo.getRegisteredFund());
        row.createCell(3).setCellValue(companyInfo.getRegisteredTime());
        row.createCell(4).setCellValue(companyInfo.getPhone());
        row.createCell(5).setCellValue(companyInfo.getEmail());
        row.createCell(6).setCellValue(companyInfo.getAddress());
        row.createCell(7).setCellValue(companyInfo.getQita());

        out.flush();
        wb.write(out);
        out.close();
//        System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
    }
}
