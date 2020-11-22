package com.atguigu.tcp.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 *  群聊的客户端：
 *  1、从键盘输入消息
 *  2、接收大家的消息
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器
        Socket socket = new Socket("192.168.137.1", 9999);

        //2、启动两个线程
        new Receiver(socket).start();
        new Send(socket).start();

    }
}
class Receiver extends Thread {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Send extends Thread {
    private Socket socket;

    public Send(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //发送
        Scanner scanner = new Scanner(System.in);
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            while (true) {
                System.out.println("请输入要发送的信息：");
                String message = scanner.nextLine();

                //给服务器发送
                ps.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}