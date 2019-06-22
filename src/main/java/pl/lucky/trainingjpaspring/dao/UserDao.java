package pl.lucky.trainingjpaspring.dao;

import pl.lucky.trainingjpaspring.model.User;

public interface UserDao {

    void save(User user);

    User get(Long id);

    void update(User user);

    void delete(User user);
}
