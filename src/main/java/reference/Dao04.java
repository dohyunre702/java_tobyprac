package reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao04 {
    SimpleConnectionMaker scm = new SimpleConnectionMaker();

    public void add() throws ClassNotFoundException, SQLException {

        Connection c = scm.getConnection();

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
        Dao04 dao = new Dao04();
        dao.add();
    }
}
