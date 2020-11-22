package com.atguigu.manyclient;

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
 *  服务器要“同时”接收“多个客户端”的连接
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //1、创建ServerSocket
        ServerSocket server = new ServerSocket(9999);

        //2、接收连接
        while (true){
            Socket socket = server.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "已连接");

            new ClientHandler(socket).start();//每一个客户端启动一个线程
        }
    }

}
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {//用try-with-resource实现

        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream();
             Scanner scanner = new Scanner(input);){
            //3、不断的接收单词
            while (scanner.hasNextLine()){
                //读取一行
                String line = scanner.nextLine();

                //把单词反转
                StringBuilder s = new StringBuilder(line);
                s.reverse();

                //给客户端返回，按行返回
                output.write((s + "\n").getBytes());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //普通方法实现
    /*@Override
    public void run() {
        InputStream input = null;
        OutputStream output = null;
        Scanner scanner = null;
        try {
            //3、不断的接收单词
            input = socket.getInputStream();
            output = socket.getOutputStream();
            scanner = new Scanner(input);
            while (scanner.hasNextLine()){
                //读取一行
                String line = scanner.nextLine();

                //把单词反转
                StringBuilder s = new StringBuilder(line);
                s.reverse();

                //给客户端返回，按行返回
                output.write((s + "\n").getBytes());
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //4、关闭
            scanner.close();
            try {
                output.close();
                input.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

}
