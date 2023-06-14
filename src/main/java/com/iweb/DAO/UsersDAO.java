package com.iweb.DAO;

import com.iweb.pojo.Users;

/**
 * @author 22607
 */
public interface UsersDAO {
    /**
     根据用户ID查询用户信息
     @param uid 用户ID
     */
    void findByUid(String uid);

    /**
     查询所有用户信息
     */
    void findAll();

    /**
     添加用户
     @param user 用户对象
     */
    void save(Users user);

    /**
     修改用户密码
     @param pw 新密码
     @param uid 用户ID
     */
    void update(String pw,String uid);

    /**
     修改用户权限
     @param uid 用户ID
     @param root 权限
     */
    void rootUpdate(String uid,String root);

    /**
     删除用户
     @param uid 用户ID
     */
    void delete(String uid);

    /**
     获取用户ID
     @param uid 用户ID
     @return 用户ID
     */
    String getUid(String uid);

    /**
     获取用户密码
     @param pw 用户密码
     @return 用户密码
     */
    String getpw(String pw);

    /**
     获取用户角色
     @param root 用户角色
     @return 用户角色
     */
    String getRoot(String root);

    /**
     绑定职位和用户
     @param pid 职位ID
     @param uid 用户ID
     */
    void bind(String pid,String uid);

    /**
     关键字查询用户角色
     @param root 关键字
     */
    void ulike(String root);

    int count();
}
