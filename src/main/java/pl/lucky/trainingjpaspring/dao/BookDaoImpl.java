package pl.lucky.trainingjpaspring.dao;

import org.springframework.stereotype.Repository;
import pl.lucky.trainingjpaspring.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public BookDaoImpl() {
    }

    public void save(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(book);
        tx.commit();
        em.close();
    }

    public Book get(Long id) {
        EntityManager em = emf.createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }
}
