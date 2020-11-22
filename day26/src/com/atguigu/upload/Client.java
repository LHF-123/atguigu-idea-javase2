package com.atguigu.upload;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 *  每一个客户端，可以给服务器上传文件
 *  服务器接收到的文件，放到服务器的upload文件夹中，并且接收完后，给客户端返回“上传成功”
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器
        Socket socket = new Socket("192.168.137.1", 6666);

        //2、指定要上传的文件，选择要上传的文件
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要上传的文件路径和文件名：");
        String file = scanner.nextLine();//E:\资料\Java SE\day26_设计模式单例网络编程\面试题.docx

        //3、上传文件名和文件内容
        OutputStream output = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(output);

        //发送文件名
        dos.writeUTF(file.substring(file.lastIndexOf("\\")));

        //发送文件内容
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1){
            dos.write(data, 0, len);
        }
        //半关闭，只关闭写的通道，不关闭读的通道
        socket.shutdownOutput();

        //4、接收服务器返回的结果
        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String result = br.readLine();
        System.out.println(result);

        //5、关闭
        br.close();
        isr.close();
        in.close();
        fis.close();
        dos.close();
        output.close();
        scanner.close();
        socket.close();

    }
}
