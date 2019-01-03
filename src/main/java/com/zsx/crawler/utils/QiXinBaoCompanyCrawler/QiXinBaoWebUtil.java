package com.zsx.crawler.utils.QiXinBaoCompanyCrawler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class QiXinBaoWebUtil {
    public static String getPageContent(String url) throws Exception {
        StringBuffer sb = new StringBuffer();
        // 建立连接
        URL u = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) u.openConnection();
        httpUrlConn.setDoInput(true);
        httpUrlConn.setRequestMethod("GET");
        //设置请求头
        httpUrlConn.setRequestProperty("Cookie","cookieShowLoginTip=2; Hm_lvt_52d64b8d3f6d42a2e416d59635df3f71=1545893437,1545893455,1545895375,1545958773; sid=s%3ASC3g6UUMGhFvjX2mDvmH_H9xmRhweTeT.aLoUCTYS60m0Smdvtu8eU4GdsVTXp9PCbC7DaeFGlTg; latest_pos=OWY5NTQzODYtOWU1NC00MTlhLTgwN2MtYTkzYjE0NmZkZDcx; Hm_lpvt_52d64b8d3f6d42a2e416d59635df3f71=1545961891");
        httpUrlConn.setRequestProperty("Upgrade-Insecure-Requests", "1");
        httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");

        System.out.println(httpUrlConn.getHeaderField("Set-Cookie"));
        System.out.println();
    // 获取输入流
        InputStream is = httpUrlConn.getInputStream();
        // 将字节输入流转换为字符输入流
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        // 为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(isr);
        // 读取返回结果
        String data = null;
        while ((data = br.readLine()) != null) {
            sb.append(data);
//                System.out.println(data);
        }
        // 释放资源
        br.close();
        isr.close();
        is.close();
        httpUrlConn.disconnect();

        return sb.toString();
    }
}
