package reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao05WithInterface {

    private ConnectionMaker connectionMaker = new MySqlConnectionMaker();

    public UserDao05WithInterface(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }


    public void createTable() throws SQLException, ClassNotFoundException {

        Connection c = connectionMaker.getConnection();
        Statement stmt = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id VARCHAR(45) NOT NULL,\n"
                + "	name VARCHAR(45) NOT NULL,\n"
                + "	password VARCHAR(45)\n"
                + ");";
        stmt.execute(sql);

    }

    public void add() throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.getConnection();

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
        UserDao05WithInterface dao = new UserDao05WithInterface(() -> {
            return null;
        });
    }
}
