package com.atguigu.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/*
 *  客户端给服务器发送的请求方式有很多种，其中最常用的有两种
 *  （1）get
 *  （2）post
 */
public class TestURLConnection {
    public static void main(String[] args) throws Exception {
        //Java代码也可以实现这种提交数据的方式
        URL url = new URL("http://localhost:80/Login/IdeaLogin");

        URLConnection connection = url.openConnection();

        connection.setDoOutput(true);//必须是true才能用post方法，给服务器发送数据

        OutputStream outputStream = connection.getOutputStream();
        String data = "username=liu&password=123";
        outputStream.write(data.getBytes());

        //接收服务器返回的结果
        InputStream in = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
        isr.close();
        in.close();
        outputStream.close();
    }
}
