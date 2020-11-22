package com.atguigu.basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * @author LHF
 * @create 2020-08-24-11:27
 *  群发
 */
public class TestQunFa {
    private  volatile static boolean exit = false;
    private  static Scanner input = new Scanner(System.in);
    private static String username;//区别谁发的

    public static void main(String[] args) throws Exception {
        //1、创建一个Socket，可以广播的socket，指定端口号为9999
        MulticastSocket socket = new MulticastSocket(9999);
        //2、指定广播的IP地址
        InetAddress ip = InetAddress.getByName("230.0.0.1");
        //3、把当前的socket加入到广播组
        socket.joinGroup(ip);
        //4、是否给自己也发一份，false表示给自己发一份
        socket.setLoopbackMode(false);

        System.out.println("请输入用户名：");
        username = input.nextLine();

        //因为当前程序既是发送方，又是接收方，所以用两个线程，分别处理发送和接收，才能同时进行发送和接收
        SendThead s = new SendThead(socket, ip);
        ReceiveThread r = new ReceiveThread(socket);

        s.start();
        r.start();

        try {
            s.join();//等发送结束，再关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        socket.close();
        input.close();

    }

    static class SendThead extends Thread {
        private MulticastSocket socket;
        private InetAddress ip;

        public SendThead(MulticastSocket socket, InetAddress ip) {
            this.socket = socket;
            this.ip = ip;
        }

        @Override
        public void run() {
            while (!exit){
                System.out.println("输入广播消息");
                String message = input.nextLine();
                if ("bye".equals(message)){
                    exit = true;
                    break;
                }

                byte[] data = (username + ":" + message).getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, ip, 9999);

                try {
                    socket.send(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReceiveThread extends Thread {
        private MulticastSocket socket;

        public ReceiveThread(MulticastSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!exit){
                byte[] data = new byte[1024];
                DatagramPacket dp = new DatagramPacket(data, data.length);
                try {
                    socket.receive(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String str = new String(data, 0, dp.getLength());
                System.out.println(str);
            }
        }
    }
}
