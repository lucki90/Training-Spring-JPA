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
        cars.add(new Car("A5", "Audi", 67000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A8", "Audi", 28000.0));
        cars.add(new Car("Corolla", "Toyota", 31000.0));
        cars.add(new Car("Vectra", "Opel", 29500.0));
        cars.add(new Car("Astra", "Opel", 29500.0));


        CarRepository carRepository = ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        carRepository.findByBrand("Toyota").forEach(System.out::println);
        System.out.println();
        System.out.println(carRepository.findFirst3ByBrand("Opel"));
        System.out.println();
        carRepository.findAllByBrandAndPrice("Audi",4900).forEach(System.out::println);

        carRepository.findAllByBrandOrderByPriceAsc("Audi").forEach(System.out::println);

        carRepository.findAllByBrandNotNull().forEach(System.out::println);

        carRepository.findAllByBrandNotLike("audi").forEach(System.out::println);
        ctx.close();

    }

}
