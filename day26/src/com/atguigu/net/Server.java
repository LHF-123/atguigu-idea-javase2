package com.atguigu.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP网络编程的服务器端：
 *
 * 步骤：
 * 1、创建一个ServerSocket的对象，指定IP地址和监听的端口号
 *      ip如果没有指定，那么默认是运行该程序的本机地址
 *
 * 2、监听客户端的连接
 *      如果没有人连接，那么该方法就会阻塞
 *
 * 3、如果有人连接了，就可以进行通信
 *  （1）接受数据
 *  （2）发送数据
 *
 *  4、断开连接
 *  （1）关闭从socket获取的输入输出流对象，也会导致socket关闭。
 *      习惯上还是会先关闭IO流，后关闭socket。
 *  （2）一旦关闭就不能再通信了，只能重新连接
 *  （3）TCP程序最好能够正确关闭，因为TCP程序是面向连接，
 *      TCP程序的连接之前有“三次握手”，关闭时“四次握手”才能关闭。
 *      一次TCP连接的成本很高，因此要珍惜
 *
 *  后面的学习数据库的知识时，会说到一个数据库连接池的概念，
 *  其中一个原因，就是因为这个连接太宝贵了，希望能够重复使用。
 *
 *  Socket中有这样的方法：
 *  （1）getOutputStream()
 *  （2）getInputStream()
 *  （3）getInetAddress()：获取对方的IP地址
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //1、创建一个ServerSocket的对象，指定IP地址和监听的端口号
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待你的连接");

        //2、监听（接受）客户端的连接
        Socket client = server.accept();
        InetAddress host = client.getInetAddress();
        System.out.println(host.getHostAddress() + "客户端连接成功");

        //3、发送数据，发送“欢迎你连接”
        //这里发送数据，就是要写数据，这个数据写到网络中，写给客户端的
        //写数据就要用到输出流
        OutputStream out = client.getOutputStream();
        out.write("欢迎你连接".getBytes());

        //4、如果不通信了，就断开连接
        out.close();
        client.close();

        //5、如果需要，关闭服务器
        server.close();
    }

}
