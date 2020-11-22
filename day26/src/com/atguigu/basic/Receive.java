package com.atguigu.basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 *  UDP接收方
 */
public class Receive {
    public static void main(String[] args) throws Exception {
        //1、创建DatagramSocket需要指定端口号
        DatagramSocket ds = new DatagramSocket(9999);

        //2、准备接收数据的数据报和字节数组
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        System.out.println("等待接收数据......");

        //3、接收数据
        ds.receive(dp);//通过socket来接收

        //4、显示数据
        String message = new String(dp.getData());
        System.out.println(message);

        //5、关闭
        ds.close();
    }
}
