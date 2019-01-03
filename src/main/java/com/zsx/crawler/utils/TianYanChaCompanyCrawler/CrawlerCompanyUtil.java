package com.zsx.crawler.utils.TianYanChaCompanyCrawler;


import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerCompanyUtil {

    public static void main(String []args){

        String web = WebUtil.getPageContent("https://www.tianyancha.com/search?key=%E6%95%99%E8%82%B2%E7%A7%91%E6%8A%80&base=bj");
        Pattern pageCount = Pattern.compile("<div class=\"result-footer\">.*?</div>");
        Matcher matcher1 = pageCount.matcher(web);
        while (matcher1.find()){
           String group =  matcher1.group();
           System.out.println("页数：" + group);
        }
        Pattern companyInfo = Pattern.compile("<span class=\"tt hidden\">.*?</span>");
        Matcher matcher = companyInfo.matcher(web);
        while(matcher.find()){
            String group = matcher.group();
//            System.out.println(group);
            String eachGroup = group.substring(group.indexOf("<span class=\"tt hidden\">")+24,group.indexOf("</span>"));
//            System.out.println(eachGroup);
            JSONObject json = new JSONObject(eachGroup);
//            System.out.println(json);
            //公司名称
            String companyName = json.get("name").toString();
            //法人
            String legalperson = json.get("legalPersonName").toString();
            //注册资本
            String registeredfund = json.get("regCapital").toString();
            //注册时间
            String registeredtime = json.get("estiblishTime").toString();
            //电话列表
            String phone = json.get("phoneList").toString();
            //邮箱列表
            String email = json.get("emailList").toString();
            //注册地址
            String address = json.get("regLocation").toString();
            String qita = "经营领域："+ json.get("businessScope") + "\n"+json.get("matchField");
            System.out.println(companyName);
            System.out.println(legalperson);
            System.out.println(registeredfund);
            System.out.println(registeredtime);
            System.out.println(email);
            System.out.println(address);
            System.out.println(qita);
            System.out.println();
        }
    }


}