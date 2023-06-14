package com.iweb.view;

import com.iweb.DAO.UsersDAO;
import com.iweb.DAO.UsersDAOImpl;
import com.iweb.controller.MainController;
import com.iweb.pojo.Users;
import com.iweb.service.UserService;

import java.util.Scanner;

/**
 * @author 22607
 */
public class MainView {
    public static Scanner sc = new Scanner(System.in);
   public static UsersDAOImpl udi = new UsersDAOImpl();

    public static void mainView(){
        System.out.println("欢迎来到员工管理系统！！！");
        System.out.print("请选择您的操作(1.登录 2.注册 3.退出):");
        String Input = sc.nextLine();
        MainController.mainController(Input);
    }


    //登录
    public static void login() {
        System.out.println("请输入uid");
        String uid = sc.nextLine();
        System.out.println("请输入password");
        String password = sc.nextLine();
        UserService.logService(uid,password);
    }


    //注册
    public static void register() {
        System.out.println("请输入uid");
        String uid = sc.nextLine();
        System.out.println("请输入password");
        String pw = sc.nextLine();
        UserService.registerService(uid,pw);
    }


}
















