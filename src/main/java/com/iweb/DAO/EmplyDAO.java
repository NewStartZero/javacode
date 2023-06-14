package com.iweb.DAO;

import com.iweb.pojo.Emply;

/**
 * @author 22607
 */
public interface EmplyDAO {
    /**
     *根据员工ID查询员工信息
     *@param eid 员工ID
     */
    void findByEid(String eid);

    /**
     *查询所有员工信息
     */
    void findAll();

    String getEid(String eid);

    /**
     *保存新的员工信息
     *@param eid 员工ID
     *@param ename 员工姓名
     *@param sex 员工性别
     *@param idNumber 员工身份证号码
     *@param pid 员工职位ID
     *@param did 员工部门ID
     */
    void save(String eid,String ename,String sex,String idNumber,String pid,String did);

    /**
     *更新指定员工的信息
     *@param eid 员工ID
     *@param ename 员工姓名
     *@param sex 员工性别
     *@param idNumber 员工身份证号码
     *@param pid 员工职位ID
     *@param did 员工部门ID
     */
    void update(String eid,String ename,String sex,String idNumber,String pid,String did);

    /**
     * 修改当前用户绑定的员工信息
     * @param ename
     *@param ename 员工姓名
     *@param sex 员工性别
     *@param idNumber 员工身份证号码
     *@param pid 员工职位ID
     *@param did 员工部门ID
     * @param uid 用户id
     */
    void updateByuid(String ename,String sex,String idNumber,String pid,String did,String uid);

    /**
     *删除指定员工
     *@param eid 员工ID
     */
    void delete(String eid);

    /**
     *根据员工姓名进行关键字查询
     *@param ename 员工姓名的关键字
     */
    void elike(String ename);
}
