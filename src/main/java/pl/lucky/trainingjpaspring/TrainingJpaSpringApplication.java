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

@SpringBootApplication
public class TrainingJpaSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);
        System.out.println("Klient: " + client);

        Order order = new Order(" z dostawą do domu");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);

        Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
        Product product2 = new Product("Telefon APple iPhone SE", 2200.0, "pokrowiec gratis");
        ProductDao productDao = ctx.getBean(ProductDao.class);
        productDao.save(product1);
        productDao.save(product2);

        orderDao.addProductsToOrder(order.getId(), product1, product2);

        ctx.close();
    }

}
