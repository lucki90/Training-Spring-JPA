package pl.lucky.trainingjpaspring.springData.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lucky.trainingjpaspring.springData.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}