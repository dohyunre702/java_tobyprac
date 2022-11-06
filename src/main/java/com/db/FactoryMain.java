package com.db;

import reference.UserDao05WithInterface;
import reference.UserDaoFactory;

import java.sql.SQLException;

public class FactoryMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoFactory factory = new UserDaoFactory();
        UserDao05WithInterface userDao = factory.userDao();
        userDao.add();
    }
}
