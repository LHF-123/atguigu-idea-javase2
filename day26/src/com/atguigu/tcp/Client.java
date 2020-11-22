package com.atguigu.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 *  一个客户端从键盘输入英语单词，然后给服务器发送，
 *  服务器接收到这个单词后，把单词“反转”，然后返回给客户端。
 *  直到客户端输入bye为止
 *
 *  例如：hello --> olleh
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器
        Socket socket = new Socket("192.168.137.1", 9999);

        //2、从键盘读取英语单词
        Scanner scanner = new Scanner(System.in);
        OutputStream out = socket.getOutputStream();
        PrintStream ps = new PrintStream(out);//包装out的目的，为了使用println方法

        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);//用它把字节流转为字符流
        BufferedReader br = new BufferedReader(isr);//为了调用他的readLine

        while (true){
            System.out.println("请输入单词：");
            String word = scanner.nextLine();
            if ("bye".equals(word)){
                break;
            }

            //给服务器发送
            //按行处理PrintStream
            ps.println(word);

            //接收服务器单词
            String line = br.readLine();
            System.out.println("从服务器返回的单词" + line);
        }

        //4、断开连接
        br.close();
        isr.close();
        in.close();
        ps.close();
        out.close();
        scanner.close();
        socket.close();
    }
}
