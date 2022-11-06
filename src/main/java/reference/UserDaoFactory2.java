package reference;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory2 {
    @Bean
    public UserDao05WithInterface userDao() {
        MySqlConnectionMaker mySqlConnectionMaker = new MySqlConnectionMaker();
        return new UserDao05WithInterface(mySqlConnectionMaker);
    }
}
