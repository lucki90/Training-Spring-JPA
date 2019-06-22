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

        //CREATE
        Book book = new Book("1234567890464", "fdsfds", "fhfg");
        Book book1 = new Book("1234567890463", "dddd", "ssss");
        bookDao.save(book);
        bookDao.save(book1);

        //UPDATE
        book1.setId(1L);
        bookDao.update(book1);

        //READ
        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);

        //DELETE
        bookDao.remove(1L);
        Book book3 = bookDao.get(1L);
        System.out.println(book3);


        ctx.close();
    }

}
