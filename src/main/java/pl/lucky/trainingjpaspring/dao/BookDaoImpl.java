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

    @Override
    @Transactional
    public void update(Book book) {
//        em.merge(book);
        Book bookFromDb = em.find(Book.class, book.getId());
        if(bookFromDb != null) {
            bookFromDb.setTitle(book.getTitle());
            bookFromDb.setIsbn(book.getIsbn());
            bookFromDb.setAuthor(book.getAuthor());
        }
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
        System.out.println("Removed object with id: " + id);
    }


}
