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
        Order order = new Order("z dostawą do domu");
        Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
        Product product2 = new Product("Telefon Apple iPhone SE", 2200.0, "pokrowiec gratis");
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        client.addOrder(order);

        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);

        clientDao.removeAllOrders(client);

        ctx.close();
    }

}
