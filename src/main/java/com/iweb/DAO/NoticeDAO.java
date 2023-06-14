package com.iweb.DAO;

import com.iweb.pojo.Notice;

/**
 * @author 22607
 */
public interface NoticeDAO {
    /**
     *根据通知ID查询通知信息
     *@param nid 通知ID
     */
    void findByNid(String nid);

    /**
     *查询所有通知信息
     */
    void findAll();

    String getNid(String nid);

    /**
     *保存新的通知信息
     *@param nid 通知ID
     *@param txtSave 通知内容
     */
    void save(String nid,String txtSave);

    /**
     *更新指定通知的信息
     *@param nid 通知ID
     *@param txtSave 新的通知内容
     */
    void update(String nid,String txtSave);

    /**
     *删除指定通知
     *@param nid 通知ID
     */
    void delete(String nid);

    /**
     *根据通知内容进行关键字查询
     *@param txtSave 通知内容的关键字
     */
    void nlike(String txtSave);
}
