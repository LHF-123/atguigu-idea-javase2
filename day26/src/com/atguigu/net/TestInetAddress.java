package com.atguigu.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    java.lang
    java.util
    java.io
    java.text

    java.net
    InetAddress:此类表示互联网协议（IP）地址
    （1）InetAddress getLocalHost()
        域名：www.baidu.com
        IP地址：因为IP地址的数字比较长，数字不方便记忆，所以设计了域名（单词）组成，来与IP地址对应。
                由域名解析器（DNS）来解析对应的关系。

        InetAddress getByName(xx)
        getByAddress()

    （2）
     主机名：getHostName()
     IP地址：getHostAddress()
 */
public class TestInetAddress {

    @Test
    public void test4() throws UnknownHostException {
        //byte:[-128, 127]
        //ip:[0, 255]
        byte[] addr = {(byte) 192, (byte) 168, (byte) 137, 1};
        InetAddress h = InetAddress.getByAddress(addr);
        System.out.println(h);
    }

    @Test
    public void test3() throws UnknownHostException {
        InetAddress h = InetAddress.getByName("192.168.137.1");
        System.out.println(h);// /192.168.137.1
    }

    @Test
    public void test2() throws UnknownHostException {
        InetAddress h = InetAddress.getByName("www.baidu.com");
        System.out.println(h);//www.baidu.com/220.181.38.149
    }

    @Test
    public void test1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DELL-Feng/192.168.137.1

        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
    }
}
