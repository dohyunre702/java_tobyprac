package reference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class Dao02 {
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/likelion-db", "root", dbPassword);
        return c;
    }
    public void add() throws ClassNotFoundException, SQLException {

        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, "01");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "password");

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public static void main (String[]args) throws SQLException, ClassNotFoundException {
        Dao02 dao = new Dao02();
        dao.add();
    }
}
