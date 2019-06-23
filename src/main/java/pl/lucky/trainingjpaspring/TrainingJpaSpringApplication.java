package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lucky.trainingjpaspring.dao.ClientDao;
import pl.lucky.trainingjpaspring.dao.OrderDao;
import pl.lucky.trainingjpaspring.dao.ProductDao;
import pl.lucky.trainingjpaspring.model.Client;
import pl.lucky.trainingjpaspring.model.Order;
import pl.lucky.trainingjpaspring.model.Product;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrainingJpaSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Telewizor",  4500.0,"Samsung"));
        products.add(new Product("Opiekacz",  120.0,"Opiex"));
        products.add(new Product("Laptop",  3599.0,"Samsung"));
        products.add(new Product("Kino domowe", 2600.0, "Yamaha"));
        products.add(new Product("Smartfon", 2100.0, "Sony"));

        ProductDao productDao = ctx.getBean(ProductDao.class);
        products.forEach(productDao::save);

        System.out.println("All products:");
        List<Product> allProducts = productDao.getAll();
        allProducts.forEach(System.out::println);

        System.out.println("Products more expensive than 3000");
        List<Product> expensiveProducts = productDao.customGet("SELECT p FROM Product p WHERE p.price > 3000");
        expensiveProducts.forEach(System.out::println);

        System.out.println("All products ordered by price");
        List<Product> productsByPrice = productDao.customGet("SELECT p FROM Product p ORDER BY p.price ASC");
        productsByPrice.forEach(System.out::println);

        System.out.println("Expensive Samsung Products:");
        List<Product> expendiveSamsungProducts =
                productDao.customGet("SELECT p FROM Product p WHERE p.details = 'Samsung' AND p.price > 4000");
        expendiveSamsungProducts.forEach(System.out::println);

//        productDao.deleteAll();

        ctx.close();
    }

}
