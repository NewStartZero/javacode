package com.iweb.DAO;

import com.iweb.pojo.Emply;
import com.iweb.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmplyDAOImpl implements EmplyDAO{


    @Override
    public void findByEid(String eid) {
        Emply employee = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT * FROM Employee e left join depart d on e.did=d.did left join position1 p" +
                    "on e.pid=p.pid WHERE eid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eid);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            if (resultSet.next()) {
                String ename = resultSet.getString("ename");
                String sex = resultSet.getString("sex");
                String idNumber = resultSet.getString("idNumber");
                String pname = resultSet.getString("pname");
                String dname = resultSet.getString("dname");
                System.out.println("eid: " + eid + ", ename: " + ename+", sex:"+sex+", idNumber"+idNumber
                        +", pname: "+pname+", dname: "+dname);
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
            String query = "SELECT * FROM Employee e left join depart d on e.did=d.did left join position1 p " +
                    "on e.pid=p.pid ";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String eid = resultSet.getString("eid");
                String ename= resultSet.getString("ename");
                String sex = resultSet.getString("sex");
                String idNumber = resultSet.getString("idNumber");
                String pname = resultSet.getString("pname");
                String dname = resultSet.getString("dname");
                System.out.println("eid: " + eid + ", ename: " + ename+", sex:"+sex+", idNumber"+idNumber
                +", pname: "+pname+", dname: "+dname);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getEid(String eid){
        String s = null;
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建查询语句
            String query = "SELECT eid FROM Employee WHERE eid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eid);
            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString("eid");
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
    public void save(String eid,String ename,String sex,String idNumber,String pid,String did) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建插入语句
            String insert = "INSERT INTO Employee (eid, ename, sex, idNumber, pid, did) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, eid);
            statement.setString(2, ename);
            statement.setString(3, sex);
            statement.setString(4, idNumber);
            statement.setString(5, pid);
            statement.setString(6, did);

            // 执行插入操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String eid,String ename,String sex,String idNumber,String pid,String did) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE Employee SET ename = ?, sex = ?, idNumber = ?, pid = ?, did = ? WHERE eid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, ename);
            statement.setString(2, sex);
            statement.setString(3, idNumber);
            statement.setString(4, pid);
            statement.setString(5, did);
            statement.setString(6, eid);

            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByuid(String ename,String sex,String idNumber,String pid,String did,String uid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建更新语句
            String update = "UPDATE Employee SET ename = ?, sex = ?, idNumber = ?, pid = ?, did = ? WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, ename);
            statement.setString(2, sex);
            statement.setString(3, idNumber);
            statement.setString(4, pid);
            statement.setString(5, did);
            statement.setString(6, uid);
            // 执行更新操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String eid) {
        try(// 数据库连接
            Connection connection = Connect.getConnection();) {
            // 创建删除语句
            String delete = "DELETE FROM Employee WHERE eid = ?";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1, eid);

            // 执行删除操作
            statement.executeUpdate();

            // 关闭资源
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void elike(String ename) {
        try (Connection connection = Connect.getConnection()) {
            String query = "SELECT * FROM Employee e left join depart d on e.did=d.did left join position1 p" +
                    " on e.pid=p.pid WHERE ename LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // 设置模糊查询条件，例如匹配包含 "" 的字符串
            statement.setString(1, ename);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String eid = resultSet.getString("eid");
                String ename1= resultSet.getString("ename");
                String sex = resultSet.getString("sex");
                String idNumber = resultSet.getString("idNumber");
                String pname = resultSet.getString("pname");
                String dname = resultSet.getString("dname");
                System.out.println("eid: " + eid + ", ename: " + ename1+", sex:"+sex+", idNumber"+idNumber
                        +", pname: "+pname+", dname: "+dname);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
