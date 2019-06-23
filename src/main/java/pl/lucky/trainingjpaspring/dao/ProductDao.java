package pl.lucky.trainingjpaspring.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.Product;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {

    public List<Product> getAll(){
//        final String getAll = "SELECT p FROM Product p";
//        TypedQuery<Product> getAllQuery = em.createQuery(getAll,Product.class);
        TypedQuery<Product> getAllQuery = em.createNamedQuery("Product.findAll",Product.class);
        return getAllQuery.getResultList();
    }

    public void deleteAll(){
        final String deleteAll = "DELETE FROM Product p";
        Query deleteAllQuery = em.createQuery(deleteAll);
        deleteAllQuery.executeUpdate();
    }

    public List<Product> customGet(String jpqlQuery){
        TypedQuery<Product> query = em.createQuery(jpqlQuery,Product.class);
        return query.getResultList();
    }

}
