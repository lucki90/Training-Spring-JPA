package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import pl.lucky.trainingjpaspring.dao.BookDao;
import pl.lucky.trainingjpaspring.model.Book;

@SpringBootApplication
@Configuration
public class TrainingJpaSpringApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

        BookDao bookDao = ctx.getBean(BookDao.class);

        Book book = new Book("1234567890462", "aaaa", "ssss");
        bookDao.save(book);

        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);
        Thread.sleep(5000);
        ctx.close();
    }

}
