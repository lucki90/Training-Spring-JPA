package pl.lucky.trainingjpaspring.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lucky.trainingjpaspring.springData.model.Car;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //find in db with parameter
    List<Car> findByBrand(String brand);

    Optional<Car> findFirstByPrice(double price);

    List<Car> findFirst3ByBrand(String brand);

    //find in db with parameters
    List<Car> findAllByBrandOrName(String brand, String name);

    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    //find in db containing parameter
    List<Car> findAllByBrandLike(String patter);

    //find in db where number is...
    List<Car> findAllByPriceGreaterThanEqual(double price);

    List<Car> findAllByPriceBetween(double price1, double price2);

    //find in db in order
    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    //find where brand is not null
    List<Car> findAllByBrandNotNull();

    //find where name in collection
    List<Car> findAllByNameIn(Collection<String> names);

    List<Car> findAllByBrandAndPrice(String brand, double price);

    List<Car> findAllByBrandNotLike(String pattern);


}