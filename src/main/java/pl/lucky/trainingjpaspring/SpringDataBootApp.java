package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lucky.trainingjpaspring.springData.model.Car;
import pl.lucky.trainingjpaspring.springData.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBootApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBootApp.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));


        CarRepository carRepository = ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        Car firstCar = carRepository.findById(1L).get();
        carRepository.delete(firstCar);

        carRepository.findAll().forEach(System.out::println);

        ctx.close();

    }

}
