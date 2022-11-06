package reference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public abstract class UserDao03Abstract {

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

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
    }
}
