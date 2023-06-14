package com.iweb.service;

import com.iweb.DAO.UsersDAOImpl;
import com.iweb.controller.MainController;
import com.iweb.pojo.Users;
import com.iweb.view.MainView;

import java.util.Scanner;

public class UserService {
    public static UsersDAOImpl udi = new UsersDAOImpl();
    public static Scanner sc = new Scanner(System.in);

    public static void logService(String uid,String password){
        if (udi.getUid(uid)!=null && udi.getpw(uid).equals(password)) {
            System.out.println("登录成功！");
            String str = "普通用户";
            // 执行登录成功后的操作
            if(udi.getRoot(uid).equals(str)){

                System.out.println("请选择 1查询个人信息  2修改信息");
                String key = sc.nextLine();
                MainController.userController(key,uid);
            }else {
                System.out.println("请选择 1用户管理页面  2员工管理界面 3部门管理界面 4职位管理界面 5公告管理界面 6退出");
                String key = sc.nextLine();
                MainController.rootuserController(key);
            }
        } else if(udi.getUid(uid)==null){
            System.out.println("用户不存在");
        }
        else {
            System.out.println("用户名或密码错误，请重新登录！");
            MainView.login();
        }
    }

    public static void registerService(String uid,String pw){
        Users user = new Users(uid,pw);
        if (udi.getUid(user.getUid())==user.getUid()) {
            System.out.println("uid已被注册，请选择1继续注册/2退出");
            String key = sc.nextLine();
            MainController.registerController(key);
        }else{
            System.out.println("用户注册成功,即将跳转到员工号(eid)绑定界面");
            udi.save(user);

            System.out.println("请输入需要绑定的员工号(eid)");
            String eid = sc.nextLine();
            udi.bind(eid,uid);
            System.out.println("绑定成功,即将跳转到登录界面");
            MainView.login();
        }
    }
}
