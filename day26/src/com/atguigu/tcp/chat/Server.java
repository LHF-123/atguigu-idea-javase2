package com.atguigu.tcp.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-08-24-15:41
 */
public class Server {
    //用集合记录所有在线的客户端
    private static ArrayList<Socket> online = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        //1、创建ServerSocket
        ServerSocket server = new ServerSocket(9999);

        //2、接收n多人连接
        while (true) {
            Socket socket = server.accept();
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println(ip + "连接成功");

            //把当前客户端添加到online的集合中
            online.add(socket);

            //每一个客户端都需要一个线程
            new MessageHandle(socket).start();
        }
    }

    static class MessageHandle extends Thread {
      private Socket socket;

        public MessageHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //一上来，就给大家打招呼，xx上线了
            sendToOther(socket.getInetAddress().getHostAddress() + "上线了");

            //不断的接收当前客户端的消息，并且给其他客户端转发消息
            InputStream in = null;
            try {
                in = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    //给其他客户端发消息
                    sendToOther(socket.getInetAddress().getHostAddress() + ":" +line);
                }
            } catch (IOException e) {
                sendToOther(socket.getInetAddress().getHostAddress() + "掉线了");
            }

            sendToOther(socket.getInetAddress().getHostAddress() + "下线了");
        }
        
        //转发
        public void sendToOther(String message){
            //遍历所有的online的socket，每人发一份，可以排除自己
            for (Socket other : online) {
                if (!other.equals(socket)) {//排除自己
                    try {
                        PrintStream ps = new PrintStream(other.getOutputStream());
                        ps.println(message);
                    } catch (IOException e) {
                        sendToOther(socket.getInetAddress().getHostAddress() + "掉线了");
                    }
                }
            }
        }
    }
}
//思考题，掉线的和下线了要从online移除