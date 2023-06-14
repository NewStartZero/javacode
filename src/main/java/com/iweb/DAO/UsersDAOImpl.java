package com.iweb.DAO;

import com.iweb.pojo.Users;
import com.iweb.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAOImpl implements UsersDAO{

    @Override
    public void findByUid(String uid) {
        Users user = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT * FROM users WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, uid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            if (resultSet.next()) {
                String pw = resultSet.getString("pw");
                String root = resultSet.getString("root");
                System.out.println("uid: " + uid + ", pw: " + pw+ ", root: "+root);
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
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String uid = resultSet.getString("uid");
                String pw= resultSet.getString("pw");
                String root= resultSet.getString("root");

                System.out.println("uid: " + uid + ", pw: " + pw+ ", root: "+root);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Users user) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建插入语句
            String insert = "INSERT INTO users (uid, pw, root) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, user.getUid());
            statement.setString(2, user.getPw());
            statement.setString(3, user.getRoot());

            // 执行插入操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rootUpdate(String uid,String root) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE users SET root = ? WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, root);
            statement.setString(2, uid);


            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(String pw,String uid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE users SET pw = ? WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, pw);
            statement.setString(2, uid);

            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String uid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建删除语句
            String delete = "DELETE FROM users WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, uid);

            // 执行删除操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUid(String uid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT uid FROM users WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, uid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("uid");
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
    public String getpw(String uid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT pw FROM users WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, uid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("pw");
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
    public String getRoot(String uid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT root FROM users WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, uid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("root");
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
    public void bind(String eid, String uid){
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {

            String delete = "insert into Employee(eid,uid) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, eid);
            statement.setString(2, uid);

            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ulike(String root) {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM users WHERE root LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 设置模糊查询条件，例如匹配包含 "" 的字符串
            statement.setString(1, root);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String uid = resultSet.getString("uid");
                String pw= resultSet.getString("pw");
                String root1= resultSet.getString("root");

                System.out.println("uid: " + uid + ", pw: " + pw+ ", root: "+root1);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count(){
        int c =0;
        String s ="管理员";
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT COUNT(root) ct FROM users GROUP BY root HAVING root=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, s);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                c = resultSet.getInt("ct");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}

