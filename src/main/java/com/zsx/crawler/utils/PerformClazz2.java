package com.zsx.crawler.utils;

import com.zsx.crawler.pojo.CompanyInfo;
import com.zsx.crawler.utils.ExcelTools.ExcelUtil;
import com.zsx.crawler.utils.QiXinBaoCompanyCrawler.QiXinBaoCrawlerCompanyUtil;
import com.zsx.crawler.utils.QiXinBaoCompanyCrawler.QiXinBaoCrawlerCompanyUtil2;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class PerformClazz2 {
    public static void main(String []args) {
        String url = "https://www.qixin.com/search?area.province=11&key=%E6%96%87%E5%8C%96%E4%BC%A0%E6%92%AD&page=";
        for (int pageCount = 1; pageCount <= 500; pageCount++) {
            QiXinBaoCrawlerCompanyUtil2.getInfo(url+pageCount);
        }
    }
}
