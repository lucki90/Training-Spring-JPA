package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lucky.trainingjpaspring.dao.UserDaoImpl;
import pl.lucky.trainingjpaspring.dao.UserDetailsDao;
import pl.lucky.trainingjpaspring.model.User;
import pl.lucky.trainingjpaspring.model.UserDetails;

@SpringBootApplication
public class TrainingJpaSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

        UserDaoImpl userDao = ctx.getBean(UserDaoImpl.class);

        User user = new User("tommm","pass","tom@wp.pl");
        userDao.save(user);

        UserDetails details = new UserDetails("tom","luc","Gdansk");
        user.setUserDetails(details);
        userDao.update(user);

        user.setPassword("aaaaaaa");
        user.getUserDetails().setFirstName("AaaAAaa");
        userDao.update(user);

        UserDetailsDao detailsDao = ctx.getBean(UserDetailsDao.class);
        UserDetails userFromDb = detailsDao.get(1L);
        System.out.println(userFromDb);

        ctx.close();
    }

}
