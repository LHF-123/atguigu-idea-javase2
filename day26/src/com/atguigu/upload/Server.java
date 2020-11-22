package com.atguigu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *  每一个客户端，可以给服务器上传文件
 *  服务器接收到的文件，放到服务器的upload文件夹中，并且接收完后，给客户端返回“上传成功”
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1、创建ServerSocket
        ServerSocket server = new ServerSocket(6666);

        //2、接收n个客户端的连接
        while (true){
            Socket socket = server.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "连接成功");

            new FileHandler(socket).start();
        }
    }
}
class FileHandler extends Thread {
    private Socket socket;

    public FileHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //接收每一个客户端上传的文件代码
        try {
            InputStream input = socket.getInputStream();

            //文件名：（1）思路：客户端传过来
            //接收文件名，文件名是一个字符串
            //因为文件名是字符串，而文件内容是字节数据，这里用DataInputStream
            DataInputStream dis = new DataInputStream(input);
            String fileName = dis.readUTF();

            //第二步：处理文件名
            //文件可能重名怎么解决？
            //文件名可以使用唯一的编码方式来解决，其中一种就是用“时间戳” 202008241018564.xxx
            long time = System.currentTimeMillis();

            //截取的后缀名
            String ext = fileName.substring(fileName.lastIndexOf("."));
            fileName = time + ext;

            OutputStream output = new FileOutputStream("upload/" + fileName);

            //第三步：接收文件内容
            //因为不知道什么文件，不能用字符流，只能用字节流
            byte[] data = new byte[1024];
            int len;
            while ((len = dis.read(data)) != -1){
                output.write(data, 0, len);
            }

            //第四步：给客户端返回上传成功
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("上传成功");

            //第五步：关闭
            ps.close();
            output.close();
            dis.close();
            input.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}