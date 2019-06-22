package pl.lucky.trainingjpaspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_order")
@NoArgsConstructor
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(nullable = false)
    private String product;
    @Column(name = "details", length = 512)
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(String product, String orderDetails) {
        this.product = product;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", product=" + product
                + ", orderDetails=" + orderDetails + "]";
    }
}
