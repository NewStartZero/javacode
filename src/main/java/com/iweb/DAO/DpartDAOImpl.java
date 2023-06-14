package com.iweb.DAO;

import com.iweb.pojo.Dpart;
import com.iweb.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DpartDAOImpl implements DpartDAO {


    @Override
    public void findByDid(String did) {
        Dpart depart = null;
        try (// 数据库连接
             Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT * FROM depart WHERE did = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, did);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            if (resultSet.next()) {
                String did1 = resultSet.getString("did");
                String dname= resultSet.getString("dname");

                System.out.println("did: " + did1 + ", dname: " + dname);
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
            String query = "SELECT * FROM depart";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String did = resultSet.getString("did");
                String dname= resultSet.getString("dname");

                System.out.println("did: " + did + ", dname: " + dname);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDid(String did){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT did FROM depart WHERE did = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, did);
            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("did");
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
    public void save(String did, String dname) {
        try (// 数据库连接
             Connection connection = Connect.getConnection();) {
            // 创建插入语句
            String insert = "INSERT INTO depart (did, dname) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, did);
            statement.setString(2, dname);

            // 执行插入操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String did, String dname) {
        try (// 数据库连接
             Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE depart SET dname = ? WHERE did = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, dname);
            statement.setString(2, did);

            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String did) {
        try (// 数据库连接
             Connection connection = Connect.getConnection();) {
            // 创建删除语句
            String delete = "DELETE FROM depart WHERE did = ?";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, did);

            // 执行删除操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dlike(String dname) {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM depart WHERE dname LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 设置模糊查询条件，例如匹配包含 "管理员" 的字符串
            statement.setString(1, dname);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String did= resultSet.getString("did");
                String dname1 = resultSet.getString("dname");

                System.out.println("did: " + did + ", dname: " + dname1);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
