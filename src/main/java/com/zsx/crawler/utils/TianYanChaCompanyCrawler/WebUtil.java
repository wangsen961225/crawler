package com.zsx.crawler.utils.TianYanChaCompanyCrawler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebUtil {
    public static String getPageContent(String url){
        StringBuffer sb = new StringBuffer();
        try {
            // 建立连接
            URL u = new URL(url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) u.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            //设置请求头
//            httpUrlConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            httpUrlConn.setRequestProperty("Accept-Encoding","gzip, deflate, br");
//            httpUrlConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
//            httpUrlConn.setRequestProperty("Connection", "keep-alive");
            //            httpUrlConn.setRequestProperty("Host", "www.tianyancha.com");
//            httpUrlConn.setRequestProperty("Referer", "https://www.tianyancha.com/");
//            httpUrlConn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            httpUrlConn.setRequestProperty("Cookie","aliyungf_tc=AQAAANPRq2O4CgAANDbZ3ZK5v/j8N2zW; csrfToken=sxUW5AnBm5QAhT3sOGB_4RUi; TYCID=f4d8b550097411e99d7b43a922ef36d4; undefined=f4d8b550097411e99d7b43a922ef36d4; ssuid=1815741408; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1545873482; _ga=GA1.2.561404863.1545873483; _gid=GA1.2.1038318909.1545873483; RTYCID=70299aa85cd74593a648e7579fe527b5; CT_TYCID=7a283b8966fb40008adc063aa9be315a; token=4353441f696943fc8421b4d1289e0965; _utm=2f54e64ecac444f588ade21120368bb0; tyc-user-info=%257B%2522claimEditPoint%2522%253A%25220%2522%252C%2522myQuestionCount%2522%253A%25220%2522%252C%2522explainPoint%2522%253A%25220%2522%252C%2522nickname%2522%253A%2522%25E7%25B4%25A2%25E9%25A2%259D%25E5%259B%25BE-hsw%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522nicknameSup%2522%253A%2522hsw%2522%252C%2522state%2522%253A%25220%2522%252C%2522announcementPoint%2522%253A%25220%2522%252C%2522nicknameOriginal%2522%253A%2522%25E7%25B4%25A2%25E9%25A2%259D%25E5%259B%25BE%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522discussCommendCount%2522%253A%25220%2522%252C%2522monitorUnreadCount%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522new%2522%253A%25221%2522%252C%2522claimPoint%2522%253A%25220%2522%252C%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTE4ODU0MjA2NSIsImlhdCI6MTU0NTg3NDA4OCwiZXhwIjoxNTYxNDI2MDg4fQ.NATdjIsRY0l8kqnX62PgzjsLwjL6MvJZrjQ5lW_1yPscNtraHpEzKoQOt_FnvTvUJp7aNOpR9KlKLa8owTJhfA%2522%252C%2522pleaseAnswerCount%2522%253A%25220%2522%252C%2522redPoint%2522%253A%25220%2522%252C%2522bizCardUnread%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252215188542065%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTE4ODU0MjA2NSIsImlhdCI6MTU0NTg3NDA4OCwiZXhwIjoxNTYxNDI2MDg4fQ.NATdjIsRY0l8kqnX62PgzjsLwjL6MvJZrjQ5lW_1yPscNtraHpEzKoQOt_FnvTvUJp7aNOpR9KlKLa8owTJhfA; cloud_token=265bbd0d24a742f3b5083c468d6d1d9c; __insp_wid=677961980; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudGlhbnlhbmNoYS5jb20vc2VhcmNoP2tleT0lRTYlOTUlOTklRTglODIlQjIlRTclQTclOTElRTYlOEElODAmYmFzZT1iag%3D%3D; __insp_targlpt=5pWZ6IKy56eR5oqAX_ebuOWFs_aQnOe0oue7k_aenC3lpKnnnLzmn6U%3D; __insp_norec_sess=true; _gat_gtag_UA_123487620_1=1; __insp_slim=1545880185624; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1545880186");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
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
                System.out.println(data);
            }
            // 释放资源
            br.close();
            isr.close();
            is.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
