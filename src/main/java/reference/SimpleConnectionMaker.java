package reference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class SimpleConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/likelion-db", "root", dbPassword);
        return c;
    }
}
