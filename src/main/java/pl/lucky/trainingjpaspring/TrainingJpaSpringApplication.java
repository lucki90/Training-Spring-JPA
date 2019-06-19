package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lucky.trainingjpaspring.dao.BookDao;
import pl.lucky.trainingjpaspring.model.Book;

@SpringBootApplication
public class TrainingJpaSpringApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

        BookDao bookDao = ctx.getBean(BookDao.class);

        Book book = new Book("1234567890462", "fdsfds", "fhfg");
        Book book1 = new Book("1234567890462", "dddd", "ssss");
        bookDao.save(book);
        bookDao.save(book1);

        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);
        Thread.sleep(5000);
        ctx.close();
    }

}
