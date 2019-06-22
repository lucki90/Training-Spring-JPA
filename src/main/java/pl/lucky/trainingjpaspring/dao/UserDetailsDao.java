package pl.lucky.trainingjpaspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.lucky.trainingjpaspring.model.UserDetails;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDao {

    private EntityManager em;

    @Autowired
    public UserDetailsDao(EntityManager em) {
        this.em = em;
    }

    public UserDetails get(Long id) {
        return em.find(UserDetails.class, id);
    }

}
