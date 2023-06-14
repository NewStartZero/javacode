package com.iweb.DAO;

import com.iweb.pojo.Position;

/**
 * @author 22607
 */
public interface PositionDAO {
    /**
     *根据职位ID查询职位信息
     *@param pid 职位ID
     */
    void findByPid(String pid);

    /**
     *查询所有职位信息
     */
    void findAll();

    /**
     * 获取职位id
     * @param pid 职位id
     * @return pid
     */
    String getPid(String pid);

    /**
     *保存新的职位信息
     *@param pid 职位ID
     *@param pname 职位名称
     */
    void save(String pid,String pname);

    /**
     *更新指定职位的信息
     *@param pid 职位ID
     *@param pname 新的职位名称
     */
    void update(String pid,String pname);

    /**
     *删除指定职位
     @param pid 职位ID
     */
    void delete(String pid);

    /**
     *根据职位名称进行关键字查询
     @param pname 职位名称的关键字
     */
    void plike(String pname);
}
