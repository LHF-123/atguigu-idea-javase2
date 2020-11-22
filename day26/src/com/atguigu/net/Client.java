package com.atguigu.net;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/*
 *  TCP网络编程的客户端：
 *  1、创建Socket对象，并且指定“服务器”的IP地址和端口号
 *  主动与服务器建立连接
 *
 *  如果服务器没开或IP地址或端口号写错了，会报java.net.ConnectException: Connection refused: connect
 *
 *  2、通信
 *  （1）接收数据
 *  （2）发送数据
 *
 *  3、断开
 *
 */
public class Client {

    public static void main(String[] args) throws IOException {
        //1、创建Socket对象，并且指定“服务器”的IP地址和端口号
        //主动与服务器建立连接
        Socket socket = new Socket("192.168.137.1", 8888);

        //2、接收数据
        InputStream in = socket.getInputStream();
        int len;
        byte[] data = new byte[1024];
        while ((len = in.read(data)) != -1){
            System.out.println(new String(data, 0, len));
        }

        //3、关闭连接
        in.close();
        socket.close();
    }

}
