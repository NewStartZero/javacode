package com.iweb.DAO;

import com.iweb.pojo.Dpart;

/**
 * @author 22607
 */
public interface DpartDAO {

    /**
     * 通过部门id查找部门信息
     * @param did 部门id
     */
    void findByDid(String did);

    /**
     * 查询所有部门信息
     */
    void findAll();

    String getDid(String did);

    /**
     * 保存新的部门信息
     * @param did 部门id
     * @param dname 部门名字
     */
    void save(String did,String dname);

    /**
     * 更新部门信息
     * @param did 部门id
     * @param dname 部门名字
     */
    void update(String did,String dname);


    /**
     * 根据did删除部门
     * @param did 部门id
     */
    void delete(String did);


    /**
     * 根据关键词查询部门信息
     * @param dname
     */
    void dlike(String dname);
}
