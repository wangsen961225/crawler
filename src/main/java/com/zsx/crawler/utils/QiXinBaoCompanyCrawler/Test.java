package com.zsx.crawler.utils.QiXinBaoCompanyCrawler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

    public static void main(String []args) {
        StringBuffer sb = new StringBuffer();
        try {
            // 建立连接
            URL u = new URL("https://www.qixin.com/api/search");
            HttpURLConnection httpUrlConn = (HttpURLConnection) u.openConnection();
            // 发送POST请求必须设置如下两行
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setRequestMethod("POST");

            //设置请求头
            httpUrlConn.setRequestProperty("Accept", "application/json, text/plain, */*");
            httpUrlConn.setRequestProperty("Accept-Encoding","gzip, deflate, br");
            httpUrlConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            httpUrlConn.setRequestProperty("Connection", "keep-alive");
            httpUrlConn.setRequestProperty("Content-Length", "51");
            httpUrlConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpUrlConn.setRequestProperty("Cookie", "Hm_lvt_52d64b8d3f6d42a2e416d59635df3f71=1545893437,1545893455,1545895375,1545958773; sid=s%3ASC3g6UUMGhFvjX2mDvmH_H9xmRhweTeT.aLoUCTYS60m0Smdvtu8eU4GdsVTXp9PCbC7DaeFGlTg; latest_pos=MjhhMzA3YjgtZWUyMi00MmUwLWI2NDMtNDE1ODI2YjU1YmZi; Hm_lpvt_52d64b8d3f6d42a2e416d59635df3f71=1545986705");
            httpUrlConn.setRequestProperty("Host", "www.qixin.com");
            httpUrlConn.setRequestProperty("Origin", "https://www.qixin.com");
    //        httpUrlConn.setRequestProperty("Referer", "https://www.qixin.com/search?area.province=11&key=%E6%95%99%E8%82%B2&page=1");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
            httpUrlConn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            PrintWriter printWriter = new PrintWriter(httpUrlConn.getOutputStream());
            JSONObject obj = new JSONObject("{area: {province: \"11\"}, key: \"教育\", page: 1}");
            printWriter.write("{\"area\":{\"province\":\"11\"},\"key\":\"教育\",\"page\":1}");
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

        } catch (Exception e) {

            e.printStackTrace();

        }
        System.out.println(sb.toString());
//        return sb.toString();
    }

}

