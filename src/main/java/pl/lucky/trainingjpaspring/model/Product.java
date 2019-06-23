package pl.lucky.trainingjpaspring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findAllOrderByPrice", query = "SELECT p FROM Product p ORDER BY p.price"),
        @NamedQuery(name = "Product.deleteAll", query = "DELETE FROM Product p "),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
})
public class Product implements Serializable {

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
