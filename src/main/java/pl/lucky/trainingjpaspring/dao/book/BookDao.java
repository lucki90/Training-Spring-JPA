package pl.lucky.trainingjpaspring.dao.book;

import pl.lucky.trainingjpaspring.model.book.Book;

public interface BookDao {

    void save(Book book);

    Book get(Long id);

    void update(Book book);

    void remove(Long id);
}
