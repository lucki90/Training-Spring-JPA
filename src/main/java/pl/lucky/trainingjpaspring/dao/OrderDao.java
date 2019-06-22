package pl.lucky.trainingjpaspring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.Order;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order,Long> {
}
