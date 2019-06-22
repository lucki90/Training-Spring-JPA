package pl.lucky.trainingjpaspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.User;
import pl.lucky.trainingjpaspring.model.UserDetails;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(User user) {
        UserDetails details = user.getUserDetails();
        if (details != null && details.getId() == null) {
            em.persist(details);
        }
        em.persist(user);
    }

    @Override
    public User get(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void update(User user) {
        UserDetails details = user.getUserDetails();
        if (details != null) {
            details = em.merge(details);
            user.setUserDetails(details);
        }
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        User userToDelete = em.merge(user);
        em.remove(userToDelete.getUserDetails());
        em.remove(userToDelete);
    }
}
