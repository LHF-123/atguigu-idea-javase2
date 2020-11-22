package com.atguigu.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
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
public class Server {

    public static void main(String[] args) throws IOException {
        //1、创建ServerSocket
        ServerSocket server = new ServerSocket(9999);

        //2、接收连接
        Socket socket = server.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "已连接");

        //3、不断的接收单词
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //无法分析每一个单词
        /*byte[] data = new byte[1024];
        int len;
        while ((len = input.read(data)) != -1){
            new String(data, 0, len);
        }*/

        //换个思路，客户端每个单词按行发送
        //服务器就可以进行读取
        //BufferedReader: readLine()
        //Scanner: nextLine()

        Scanner scanner = new Scanner(input);//从客户端的网络流中按行读
        while (scanner.hasNextLine()){
            //读取一行
            String line = scanner.nextLine();

            //把单词反转
            StringBuilder s = new StringBuilder(line);
            s.reverse();

            //给客户端返回，按行返回
            output.write((s + "\n").getBytes());
        }

        //4、关闭
        scanner.close();
        output.close();
        input.close();
        socket.close();
        server.close();
    }

}
