package reference;

import java.sql.Connection;
import java.sql.SQLException;

public class KUserDao extends UserDao03Abstract{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
