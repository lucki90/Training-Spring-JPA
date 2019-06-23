package pl.lucky.trainingjpaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lucky.trainingjpaspring.dao.ClientDao;
import pl.lucky.trainingjpaspring.dao.OrderDao;
import pl.lucky.trainingjpaspring.model.Client;
import pl.lucky.trainingjpaspring.model.Order;

@SpringBootApplication
public class TrainingJpaSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainingJpaSpringApplication.class, args);

//        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
//        ClientDao clientDao = ctx.getBean(ClientDao.class);
//        clientDao.save(client);
//        System.out.println(client);
//
//        Order order = new Order( "42', dostawa do domu");
//        order.setClient(client);
//        OrderDao orderDao = ctx.getBean(OrderDao.class);
//        orderDao.save(order);
//
//        System.out.println("##########################################");
//        Client getClient = clientDao.get(1L);
//        System.out.println(getClient);

        ctx.close();
    }

}
