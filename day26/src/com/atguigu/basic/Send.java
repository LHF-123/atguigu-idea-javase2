package com.atguigu.basic;

import java.io.IOException;
import java.net.*;

/*
 *  UDP编程：
 *  DatagramSocket
 *  DatagramPacket
 *
 *  UDP的发送端
 */
public class Send {
    public static void main(String[] args) throws IOException {
        //1、先创建一个DatagramSocket
        //可以不指定端口号和IP地址,自动选择端口号，ip默认本机
        DatagramSocket ds = new DatagramSocket();

        //2、准备发送的数据
        String str = "大家好！";
        byte[] data = str.getBytes();

        //3、把数据包装成一个数据报
        /*
         *  参数一：字节数组，就是要发送的数据
         *  参数二：数据的长度
         *  参数三：接收方的主机名和IP地址
         *  参数四：接收方监听的端口号
         */
        InetAddress ip = InetAddress.getByName("192.168.137.1");
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 9999);

        //4、发送
        ds.send(dp);//通过socket对象发送数据报
        System.out.println("数据发送完毕");

        //5、关闭
        ds.close();
    }
}
