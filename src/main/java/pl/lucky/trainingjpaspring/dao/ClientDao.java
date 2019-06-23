package pl.lucky.trainingjpaspring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lucky.trainingjpaspring.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
//    @Override
//    public Client get(Long key){
//        Client client = super.get(key);
//        client.getOrders().size();
//        return client;
//    }

    public void removeAllOrders(Client client) {
        Client managedClient = get(client.getId());
        managedClient.getOrders().clear();
    }

}
