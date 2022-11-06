package com.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

//DAO 확장을 위한 인터페이스 도입
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException,
            SQLException;
}
