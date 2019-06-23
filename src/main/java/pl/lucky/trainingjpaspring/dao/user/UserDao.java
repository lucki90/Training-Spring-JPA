package pl.lucky.trainingjpaspring.dao.user;

import pl.lucky.trainingjpaspring.model.user.User;

public interface UserDao {

    void save(User user);

    User get(Long id);

    void update(User user);

    void delete(User user);
}
