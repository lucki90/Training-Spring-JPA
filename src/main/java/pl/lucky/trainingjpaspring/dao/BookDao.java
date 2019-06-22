package pl.lucky.trainingjpaspring.dao;

import pl.lucky.trainingjpaspring.model.Book;

public interface BookDao {

    void save(Book book);

    Book get(Long id);

    void update(Book book);

    void remove(Long id);
}
