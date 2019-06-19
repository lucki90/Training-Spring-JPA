package pl.lucky.trainingjpaspring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    public BookDaoImpl() {
    }

    @Transactional
    public void save(Book book) {
        em.persist(book);
    }

    public Book get(Long id) {
        Book book = em.find(Book.class, id);
        return book;
    }
}
