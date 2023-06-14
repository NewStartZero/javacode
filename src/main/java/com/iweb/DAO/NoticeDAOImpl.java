package com.iweb.DAO;

import com.iweb.pojo.Notice;
import com.iweb.util.Connect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDAOImpl implements NoticeDAO{

    @Override
    public void findByNid(String nid) {
        Notice notice = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT * FROM notice WHERE nid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            if (resultSet.next()) {
                String nid1= resultSet.getString("nid");
                String txtSave= resultSet.getString("txtSave");

                System.out.println("nid: " + nid1 + ", txtSave: " + txtSave);
            }

            // 关闭资源
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAll() {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM notice";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nid = resultSet.getString("nid");
                String txtSave= resultSet.getString("txtSave");

                System.out.println("nid: " + nid + ", txtSave: " + txtSave);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNid(String nid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT nid FROM notice WHERE nid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nid);
            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("nid");
            }

            // 关闭资源
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void save(String nid,String txtSave) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建插入语句
            String insert = "INSERT INTO notice (nid, txtSave) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, nid);
            statement.setString(2, txtSave);

            // 执行插入操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String nid,String txtSave) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE notice SET txtSave = ? WHERE nid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, txtSave);
            statement.setString(2, nid);

            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String nid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建删除语句
            String delete = "DELETE FROM notice WHERE nid = ?";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, nid);

            // 执行删除操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nlike(String txtSave) {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM notice WHERE txtSave LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 设置模糊查询条件，例如匹配包含 "" 的字符串
            statement.setString(1, txtSave);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nid = resultSet.getString("nid");
                String txtSave1= resultSet.getString("txtSave");

                System.out.println("nid: " + nid + ", txtSave: " + txtSave1);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
