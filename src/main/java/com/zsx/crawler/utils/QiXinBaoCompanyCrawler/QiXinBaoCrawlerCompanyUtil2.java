package com.zsx.crawler.utils.QiXinBaoCompanyCrawler;

import com.zsx.crawler.pojo.CompanyInfo;
import com.zsx.crawler.utils.ExcelTools.ExcelAppendContentUtil;
import com.zsx.crawler.utils.PerformClazz2;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QiXinBaoCrawlerCompanyUtil2 {
    public static void getInfo(String url) {
//        List<CompanyInfo> list = new ArrayList<CompanyInfo>();
        String web = null;
        try {
            web = QiXinBaoWebUtil.getPageContent(url);
        } catch (Exception e) {
            System.out.println("遇到网络机器人验证，点击下方链接验证后继续爬取！");
            System.out.println(e.getMessage().substring(e.getMessage().indexOf("https:")));
            Scanner sc = new Scanner(System.in);
            System.out.println("输入‘OK’继续爬取：");
            String ok = sc.nextLine();
            if ("ok".equals(ok.toLowerCase())) {
                System.out.println("开始继续爬取...");
                try {
                    web = QiXinBaoWebUtil.getPageContent(url);
                } catch (Exception e1) {
                    System.out.println("验证失败！程序结束！请重新执行爬取！");
                }
            }
        }
        Pattern companyInfoAll = Pattern.compile("\"companies\":.*?personName");
        Matcher matcher = companyInfoAll.matcher(web);
        while (matcher.find()) {
            String group = matcher.group();
//            System.out.println(group);
            String eachGroup = group.substring(group.indexOf("\"items\":") + 8, group.indexOf(",\"personName"));
//            System.out.println(eachGroup);
            JSONArray array = new JSONArray(eachGroup);
            for (int i = 0; i < array.length(); i++) {
                JSONObject eachArray = new JSONObject(array.get(i).toString());
                //公司名称
                String companyName = eachArray.get("name").toString();
                //法人
                String legalPerson = eachArray.get("oper_name").toString();
                //注册资本
                String registeredFund = eachArray.get("reg_capi").toString();
                //注册时间
                String registeredTime = eachArray.get("start_date").toString();
                //电话
                String phone = eachArray.get("phone").toString();
                //邮箱
                String email = eachArray.get("email").toString();
                //注册地址
                String address = eachArray.get("address").toString();
                //其他
                String qita = eachArray.get("match_items").toString();

                CompanyInfo companyInfo = new CompanyInfo(companyName, legalPerson, registeredFund, registeredTime, phone, email, address, qita);

                try {
                    ExcelAppendContentUtil.appendContent(companyInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                    list.add(companyInfo);
//                System.out.println(companyName);
////                System.out.println(legalPerson);
////                System.out.println(registeredFund);
////                System.out.println(registeredTime);
////                System.out.println(phone);
////                System.out.println(email);
////                System.out.println(address);
////                System.out.println(qita);
////                System.out.println();
            }
        }
//        return list;
    }
}
