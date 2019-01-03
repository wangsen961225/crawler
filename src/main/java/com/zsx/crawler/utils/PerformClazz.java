package com.zsx.crawler.utils;

import com.zsx.crawler.pojo.CompanyInfo;
import com.zsx.crawler.utils.ExcelTools.ExcelUtil;
import com.zsx.crawler.utils.QiXinBaoCompanyCrawler.QiXinBaoCrawlerCompanyUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class PerformClazz {
    public static void main(String []args) {
        String url = "https://www.qixin.com/search?area.province=11&key=%E6%95%99%E8%82%B2&page=";
        for (int pageCount = 1; pageCount <= 20; pageCount++) {
            List<CompanyInfo> info = QiXinBaoCrawlerCompanyUtil.getInfo(url);

            String[] title = {"公司名称", "法人", "注册资本", "注册时间", "电话", "邮箱", "注册地址", "其他"};
            String fileName = "公司信息表" + System.currentTimeMillis() + ".xls";
            String sheetName = "公司信息表";

            String[][] content = new String[info.size()][title.length];
            for (int j = 0; j < info.size(); j++) {
                CompanyInfo obj = info.get(j);
                content[j][0] = obj.getCompanyName();
                content[j][1] = obj.getLegalPerson();
                content[j][2] = obj.getRegisteredFund();
                content[j][3] = obj.getRegisteredTime();
                content[j][4] = obj.getPhone();
                content[j][5] = obj.getEmail();
                content[j][6] = obj.getAddress();
                content[j][7] = obj.getQita();
            }

            HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\CompanyInfoExcel\\公司信息表" + System.currentTimeMillis() + ".xls");
                wb.write(fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
