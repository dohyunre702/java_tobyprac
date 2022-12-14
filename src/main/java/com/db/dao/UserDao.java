package com.db.dao;

import com.db.domain.User;

import java.sql.*;
import java.util.Map;
//
public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao() {
        //UserDao가 어떤 ConnectinMaker 구현 클래스의 오브젝트를 이용하게 할지 결정한다.
        //즉, UserDao와 특정 구현 클래스 사이의 관계를 설정해 주는 것에 대한 관심사를 갖고 있다.
        connectionMaker = new DConnectionMaker();
    }

    public void add() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, "01");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "password");

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public static void main (String[]args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(); //error
        userDao.add();
    }
}
