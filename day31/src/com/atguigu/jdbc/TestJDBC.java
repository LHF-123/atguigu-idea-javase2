package com.atguigu.jdbc;

/*
 * 1、什么是JDBC？
 *    Java Database Connectivity：Java连接数据库
 *
 * JDBC是代表一组API，一个独立于特定的数据库系统（DBMS）、通用的SQL数据库存取和操作的公共接口（一组API）。
 * SUN公司（Oracle）为了使得Java代码可以跨数据库，即数据库换了，我们JDBC的代码不动（或少动），设计了一组公共的接口（标准）
 * 规定了所有操作数据库的代码，应该用哪些类型，哪些方法。
 *
 * 这些操作数据库底层的具体代码由数据库厂商来实现，这些实现类，我们就称为“数据库驱动”。
 * 这就意味着，你要连接和操作mysql的驱动，如果要连接和操作oracle，那么就需要拿到oracle的驱动。
 *
 * 那么Java代码中就通过接口 + 驱动 + 标准的sql语句就可以实现java代码与各种数据库的连接和操作
 *
 * JDBC的API是SUN公司提供的，而这些接口的实现类（驱动）由数据库厂商提供
 *
 * 2、开发JDBC程序的步骤
 * （1）把驱动jar引入到项目中来，
 *  在java项目中。自己建立一个lib，把mysql-connector-java-5.1.48-bin.jar放到lib文件夹中，然后添加到build path路径下
 *  如果在web项目中，有专门的的lib文件夹，不用自己建了
 *
 * （2）编写JDBC代码
 */
public class TestJDBC {
}
