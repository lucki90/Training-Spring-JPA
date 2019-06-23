package pl.lucky.trainingjpaspring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "details")
    private String details;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product(String name, Double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product [id=" + id
                + ", name=" + name
                + ", price=" + price
                + ", details=" + details + "]";
    }
}
