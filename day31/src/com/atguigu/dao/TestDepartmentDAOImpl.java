package com.atguigu.dao;

import com.atguigu.bean.Department;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LHF
 * @create 2020-09-05-21:56
 */
public class TestDepartmentDAOImpl {
//JUnit的单元测试不能用，改为main方法，分别测试

    public void main(){
        //1、键盘输入
        Scanner input = new Scanner(System.in);

        System.out.println("请输入部门的名称：");
        String name = input.nextLine();

        System.out.println("请输入部门的简介：");
        String desc = input.nextLine();

        Department dept = new Department(0, name, desc);

        //通过DepartmentDAOImpl操作数据库
        DepartmentDAO dao = new DepartmentDAOImpl();
        dao.add(dept);

        System.out.println("添加成功");

    }

    public static void main(String[] args){
        //1、键盘输入
        Scanner input = new Scanner(System.in);

        System.out.println("请输入部门的编号：");
        int did = input.nextInt();


        //通过DepartmentDAOImpl操作数据库
        DepartmentDAO dao = new DepartmentDAOImpl();
        dao.deleteByDid(did);

        System.out.println("删除成功");

    }

    @Test
    public void testGetAll(){
        DepartmentDAO dao = new DepartmentDAOImpl();
        ArrayList<Department>  all = dao.getAll();
        for (Department department : all) {
            System.out.println(department);
        }
    }
}
