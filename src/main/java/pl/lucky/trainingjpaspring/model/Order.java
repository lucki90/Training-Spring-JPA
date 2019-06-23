package pl.lucky.trainingjpaspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_order")
@NoArgsConstructor
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "details", length = 512)
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    private List<Product> products;

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
        products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order [id=" + id
                + ", orderDetails=" + orderDetails
                + ", client=" + client.getFirstName() + " " + client.getLastName() + products.size()
                + ",\n products=" + products + "]";
    }
}
