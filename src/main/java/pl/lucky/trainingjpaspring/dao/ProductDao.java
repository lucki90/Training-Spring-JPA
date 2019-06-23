package pl.lucky.trainingjpaspring.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {

}
