package com.iweb.controller;

import com.iweb.DAO.*;
import com.iweb.view.MainView;

import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);
    public static UsersDAOImpl udi = new UsersDAOImpl();
    public static EmplyDAOImpl edi = new EmplyDAOImpl();
    public static DpartDAOImpl ddi = new DpartDAOImpl();
    public static PositionDAOImpl pdi = new PositionDAOImpl();
    public static NoticeDAOImpl ndi = new NoticeDAOImpl();

    public static void mainController(String key) {

            switch (key) {
                case "1":
//                跳转到登录页面
                    System.out.println("即将跳转到登录页面...");
                    MainView.login();
                    break;
                case "2":
//                跳转到注册页面
                    System.out.println("即将跳转到注册页面...");
                    MainView.register();
                    break;
                case "3":
                    System.out.println("删除成功");
                    break;
                default:
                    //打印提示 重新回到主页面
                    System.out.println("输入范围有误,请重新输入");
                    MainView.mainView();
            }
    }




    public static void registerController(String key) {
        switch (key) {
            case "1":
                MainView.register();
                break;
            case "2":
                System.out.println("退出成功");
                break;
        }
    }


    public static void userController(String key, String uid) {
        switch (key) {
            case "1":
                udi.findByUid(uid);
                break;
            case "2":
                System.out.println("即将跳转到修改页面");
                System.out.println("请选择 1修改用户信息 2修改当前用户对应的员工信息");
                String key1 = sc.nextLine();
                switch (key1) {
                    case "1":
                        System.out.println("即将跳转到用户信息修改界面");
                        System.out.println("请输入修改后的密码");
                        String pw = sc.nextLine();
                        System.out.println("用户密码修改成功");
                        udi.update(pw, uid);
                        break;
                    case "2":
                        System.out.println("即将跳转到个人员工信息修改界面");
                        System.out.println("请输入修改后员工ename");
                        String ename1 = sc.nextLine();
                        System.out.println("请输入修改后员工sex");
                        String sex1 = sc.nextLine();
                        System.out.println("请输入修改后员工idNumber");
                        String idNumber1 = sc.nextLine();
                        System.out.println("请输入修改后员工pid");
                        String pid1 = sc.nextLine();
                        System.out.println("请输入修改后员工did");
                        String did1 = sc.nextLine();
                        System.out.println("员工信息修改成功");
                        edi.updateByuid(ename1, sex1, idNumber1, pid1, did1,uid);
                        break;
                }
                break;
        }
    }

    public static void rootuserController(String key) {
        switch (key) {
            case "1":
                System.out.println("即将跳转到用户管理页面");
                System.out.println("请选择 1用户创建 2用户删除 3用户修改 4用户查询");
                String key1 = sc.nextLine();
                userManager(key1);
                break;
            case "2":
                System.out.println("即将跳转到员工管理界面");
                System.out.println("请选择 1员工添加 2员工删除 3员工修改 4员工查询");
                String key2 = sc.nextLine();
                EmpManager(key2);
                break;
            case "3":
                System.out.println("即将跳转到部门管理界面");
                System.out.println("请选择 1部门添加 2部门删除 3部门修改 4部门查询");
                String key3 = sc.nextLine();
                dpartManager(key3);
                break;
            case "4":
                System.out.println("即将跳转到职位管理界面");
                System.out.println("请选择 1职位添加 2职位删除 3职位修改 4职位查询");
                String key4 = sc.nextLine();
                positionManager(key4);
                break;
            case "5":
                System.out.println("即将跳转到公告管理界面");
                System.out.println("请选择 1公告添加 2公告删除 3公告修改 4公告查询");
                String key5 = sc.nextLine();
                noticeManager(key5);
                break;
            case "6":
                System.out.println("退出成功");
                break;
        }
    }




    public static void userManager(String key) {
        switch (key) {
            case "1":
                System.out.println("下面将进行用户创建功能");
                MainView.register();
                break;
            case "2":
                System.out.println("下面将进行用户删除功能");
                System.out.println("请输入需要删除的用户uid");
                String uid = sc.nextLine();
                udi.delete(uid);
                System.out.println("用户删除成功");
                break;
            case "3":
                System.out.println("下面将进行用户修改功能(1修改密码 2修改权限)");
                String key1 = sc.nextLine();
                switch (key1) {
                    case "1":
                        System.out.println("请输入需要更改的用户的uid");
                        String uid1 = sc.nextLine();
                        System.out.println("请输入更改后的用户密码");
                        String pw = sc.nextLine();
                        System.out.println("密码修改成功");
                        udi.update(pw, uid1);
                        break;
                    case "2":
                        System.out.println("请输入需要更改的用户的uid");
                        String uid2 = sc.nextLine();
                        System.out.println("请输入修改后的权限(普通用户/管理员)");
                        String root = sc.nextLine();
                        String s = "普通用户";
                        //字符串不可以直接比较，必须使用equals
                        if(udi.count()==1 && root.equals(s)){
                            System.out.println("无法修改权限,管理员数量已达最低");
                            break;
                        }else{
                            System.out.println("权限修改成功");
                            udi.rootUpdate(uid2, root);
                            break;
                        }

                }
                break;
            case "4":
                System.out.println("下面将进行用户查询功能(1根据uid查询用户信息 2查询用户表所有信息 3根据root关键词查询)");
                String key2 = sc.nextLine();
                userSelect(key2);
                break;
        }
    }

    public static void userSelect(String key) {
        switch (key) {
            case "1":
                System.out.println("根据uid查询用户信息");
                System.out.println("请输入需要查询的uid");
                String uid = sc.nextLine();
                udi.findByUid(uid);
                break;
            case "2":
                System.out.println("查询用户表所有信息");
                udi.findAll();
                break;
            case "3":
                System.out.println("根据root关键词查询");
                System.out.println("请输入关键词");
                String root ="%"+sc.nextLine()+"%";
                udi.ulike(root);
                break;
        }
    }

    public static void EmpManager(String key) {
        switch (key) {
            case "1":
                System.out.println("下面将进行员工添加功能");
                System.out.println("请输入员工eid");
                String eid = sc.nextLine();
                System.out.println("请输入员工ename");
                String ename = sc.nextLine();
                System.out.println("请输入员工sex");
                String sex = sc.nextLine();
                System.out.println("请输入员工idNumber");
                String idNumber = sc.nextLine();
                System.out.println("请输入员工pid");
                String pid = sc.nextLine();
                System.out.println("请输入员工did");
                System.out.println("员工添加成功");
                String did = sc.nextLine();
                if(edi.getEid(eid)==null) {
                    edi.save(eid, ename, sex, idNumber, pid, did);
                }else {
                    System.out.println("eid已存在，请重新输入");
                    EmpManager("1");
                }
                break;
            case "2":
                System.out.println("下面将进行员工删除功能");
                String eid1 = sc.nextLine();
                System.out.println("员工数据删除成功");
                edi.delete(eid1);
                break;
            case "3":
                System.out.println("下面将进行员工修改功能");
                System.out.println("请输入需要修改的员工eid");
                String eid2 = sc.nextLine();
                System.out.println("请输入修改后员工ename");
                String ename1 = sc.nextLine();
                System.out.println("请输入修改后员工sex");
                String sex1 = sc.nextLine();
                System.out.println("请输入修改后员工idNumber");
                String idNumber1 = sc.nextLine();
                System.out.println("请输入修改后员工pid");
                String pid1 = sc.nextLine();
                System.out.println("请输入修改后员工did");
                String did1 = sc.nextLine();
                System.out.println("员工数据修改成功");
                edi.update(eid2, ename1, sex1, idNumber1, pid1, did1);
                break;
            case "4":
                System.out.println("下面将进行员工查询功能(1根据eid查询用户信息 2查询员工表所有信息 3根据员工名关键词查询)");
                String key1 = sc.nextLine();
                EmpSelect(key1);
                break;
        }
    }

    public static void EmpSelect(String key) {
        switch (key) {
            case "1":
                System.out.println("根据eid查询用户信息");
                System.out.println("请输入需要查询的eid");
                String eid = sc.nextLine();
                edi.findByEid(eid);
                break;
            case "2":
                System.out.println("查询员工表所有信息");
                edi.findAll();
                break;
            case "3":
                System.out.println("根据员工名关键词查询");
                System.out.println("请输入关键词");
                String ename = "%"+sc.nextLine()+"%";
                edi.elike(ename);
                break;
        }
    }

    public static void dpartManager(String key) {
        switch (key) {
            case "1":
                System.out.println("下面将进行部门添加功能");
                System.out.println("请输入did");
                String did = sc.nextLine();
                System.out.println("请输入dname");
                String dname = sc.nextLine();
                if(ddi.getDid(did)==null) {
                    System.out.println("部门添加成功");
                    ddi.save(did, dname);
                }else {
                    System.out.println("did已存在，请重新输入");
                    dpartManager("1");
                }
                break;
            case "2":
                System.out.println("下面将进行部门修改功能");
                System.out.println("请输入需要修改的did");
                String did1 = sc.nextLine();
                System.out.println("请输入修改后的dname");
                String dname1 = sc.nextLine();
                System.out.println("部门修改成功");
                ddi.update(did1,dname1);
                break;
            case "3":
                System.out.println("下面将进行部门删除功能");
                System.out.println("请输入需要删除的部门did");
                String did2 = sc.nextLine();
                System.out.println("部门数据删除成功");
                ddi.delete(did2);
                break;
            case "4":
                System.out.println("下面将进行部门查询功能(1根据did查询部门信息 2查询部门表所有信息 3根据部门名关键词查询)");
                String key1 = sc.nextLine();
                dpartSelect(key1);
                break;
        }
    }

    public static void dpartSelect(String key) {
        switch (key) {
            case "1":
                System.out.println("根据did查询部门信息");
                System.out.println("请输入需要查询的did");
                String did = sc.nextLine();
                ddi.findByDid(did);
                break;
            case "2":
                System.out.println("查询部门表所有信息");
                ddi.findAll();
                break;
            case "3":
                System.out.println("根据部门名关键词查询");
                System.out.println("请输入关键词");
                String dname = "%"+sc.nextLine()+"%";
                ddi.dlike(dname);
                break;
        }
    }

    public static void positionManager(String key) {
        switch (key) {
            case "1":
                System.out.println("下面将进行职位添加功能");
                System.out.println("请输入pid");
                String pid = sc.nextLine();
                System.out.println("请输入pname");
                String pname = sc.nextLine();
                if(pdi.getPid(pid)==null) {
                    System.out.println("职位添加成功");
                    pdi.save(pid,pname);
                }else {
                    System.out.println("pid已存在，请重新输入");
                    positionManager("1");
                }
                break;
            case "2":
                System.out.println("下面将进行职位修改功能");
                System.out.println("请输入需要修改的pid");
                String pid1 = sc.nextLine();
                System.out.println("请输入修改后的pname");
                String pname1 = sc.nextLine();
                System.out.println("职位修改成功");
                pdi.update(pid1,pname1);
                break;
            case "3":
                System.out.println("下面将进行职位删除功能");
                System.out.println("请输入需要删除的职位pid");
                String pid2 = sc.nextLine();
                System.out.println("职位数据删除成功");
                pdi.delete(pid2);
                break;
            case "4":
                System.out.println("下面将进行职位查询功能(1根据pid查询职位信息 2查询职位表所有信息 3根据职位名关键词查询)");
                String key1 = sc.nextLine();
                positionSelect(key1);
                break;
        }
    }

    public static void positionSelect(String key) {
        switch (key) {
            case "1":
                System.out.println("根据pid查询职位信息");
                System.out.println("请输入需要查询的pid");
                String pid = sc.nextLine();
                pdi.findByPid(pid);
                break;
            case "2":
                System.out.println("查询职位表所有信息");
                pdi.findAll();
                break;
            case "3":
                System.out.println("根据职位名关键词查询");
                System.out.println("请输入关键词");
                String pname = "%"+sc.nextLine()+"%";
                pdi.plike(pname);
                break;
        }
    }

    public static void noticeManager(String key) {
        switch (key) {
            case "1":
                System.out.println("下面将进行公告添加功能");
                System.out.println("请输入nid");
                String nid = sc.nextLine();
                System.out.println("请输入txtSave");
                String txtSave = sc.nextLine();
                if(ndi.getNid(nid)==null) {
                    System.out.println("公告添加成功");
                    ndi.save(nid,txtSave);
                }else {
                    System.out.println("nid已存在，请重新输入");
                    noticeManager("1");
                }
                break;
            case "2":
                System.out.println("下面将进行公告修改功能");
                System.out.println("请输入需要修改的nid");
                String nid1 = sc.nextLine();
                System.out.println("请输入修改后的txtSave");
                String txtSave1 = sc.nextLine();
                System.out.println("公告修改成功");
                ndi.update(nid1,txtSave1);
                break;
            case "3":
                System.out.println("下面将进行公告删除功能");
                System.out.println("请输入需要删除的公告nid");
                String nid2 = sc.nextLine();
                System.out.println("公告删除成功");
                ndi.delete(nid2);
                break;
            case "4":
                System.out.println("下面将进行公告查询功能(1根据nid查询公告信息 2查询公告表所有信息 3根据公告内容查询)");
                String key1 = sc.nextLine();
                noticeSelect(key1);
                break;
        }
    }

    public static void noticeSelect(String key) {
        switch (key) {
            case "1":
                System.out.println("根据nid查询职位信息");
                System.out.println("请输入需要查询的nid");
                String nid = sc.nextLine();
                ndi.findByNid(nid);
                break;
            case "2":
                System.out.println("查询公告表所有信息");
                ndi.findAll();
                break;
            case "3":
                System.out.println("根据公告内容查询");
                System.out.println("请输入公告片段");
                String txtSave = "%"+sc.nextLine()+"%";
                ndi.nlike(txtSave);
                break;
        }
    }

}
