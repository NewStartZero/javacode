package com.iweb.DAO;

import com.iweb.pojo.Position;
import com.iweb.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionDAOImpl implements PositionDAO{


    @Override
    public void findByPid(String pid) {
        Position position = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT * FROM position1 WHERE pid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            if (resultSet.next()) {
                String pid1 = resultSet.getString("pid");
                String pname= resultSet.getString("pname");

                System.out.println("pid: " + pid1 + ", pname: " + pname);
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
            String query = "SELECT * FROM position1";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String pid = resultSet.getString("pid");
                String pname= resultSet.getString("pname");

                System.out.println("pid: " + pid + ", pname: " + pname);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPid(String pid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT eid FROM position1 WHERE pid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pid);
            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("pid");
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
    public void save(String pid,String pname) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建插入语句
            String insert = "INSERT INTO position1 (pid, pname) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, pid);
            statement.setString(2, pname);

            // 执行插入操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String pid,String pname) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE position1 SET pname = ? WHERE pid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, pname);
            statement.setString(2, pid);

            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String pid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建删除语句
            String delete = "DELETE FROM position1 WHERE pid = ?";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, pid);

            // 执行删除操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void plike(String pname) {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM position1 WHERE pname LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 设置模糊查询条件，例如匹配包含 "" 的字符串
            statement.setString(1, pname);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String pid = resultSet.getString("pid");
                String pname1= resultSet.getString("pname");

                System.out.println("pid: " + pid + ", pname: " + pname1);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
