package com.atguigu.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 *  URL:
 *      俗称网址
 *      专业：统一资源定位符（Uniform Resource Locator），它是URI（Uniform Resource Identifier）的一种。
 *
 *  格式：
 *   <传输协议>://<主机名>:<端口号>/<文件名>
 *   <传输协议>://<主机名>:<端口号>/<文件名>#片段名
 *   http://www.baidu.com:80/index.html
 *
 *  <传输协议>://<主机名>:<端口号>/<文件名>?参数列表
 *  http://localhost:8080/res/login.jsp?username=name&password=123
 *
 *  tomcat就是一个服务器，浏览器是一个客户端
 *      http://localhost:8080/Login/test.html
 */
public class TestUrl {
    public static void main(String[] args) throws IOException {
        //tomcat就是一个服务器，Java程序也可以作为一个客户端
        URL url = new URL("http://localhost:80/Login/test.jsp");
        //项目文件在eclipse，tomcat端口号已被改为80

        System.out.println("协议：" + url.getProtocol());
        System.out.println("主机名：" + url.getHost());
        System.out.println("端口号：" + url.getPort());
        System.out.println("路径名：" + url.getPath());
        System.out.println("文件名：" + url.getFile());
        System.out.println("锚点：" + url.getRef());
        System.out.println("查询名：" + url.getQuery());

        //接收服务器的消息
        InputStream in = url.openStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
        isr.close();
        in.close();
    }
}
