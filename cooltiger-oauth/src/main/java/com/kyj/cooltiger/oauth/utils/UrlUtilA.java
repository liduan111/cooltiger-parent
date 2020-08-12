package com.kyj.cooltiger.oauth.utils;

import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.oauth.entity.Userpo;
import com.kyj.cooltiger.oauth.interceptor.AuthorizationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/28 15:45
 */
public class UrlUtilA {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public HttpServletRequest request;;

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param paramMap 请求参数
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, ?> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String param = "";
        Iterator<String> it = paramMap.keySet().iterator();

        while(it.hasNext()) {
            String key = it.next();
            param += key + "=" + paramMap.get(key) + "&";
        }

        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public  String getClientIp() {

        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }else{
            if(xff.length() > 15){
                xff = xff.substring(0, 14);
            }
        }
        return xff;
    }

    public static JSONObject getJsonRequest(HttpServletRequest request) {
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取请求的用户Id
     *
     * @return 客户端Ip
     */
    public  Long getUserId() {
        Userpo user =(Userpo) request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY);
        if(user == null) {
            return 476L;
        }else {
            return user.getUserId();
        }

    }




}
