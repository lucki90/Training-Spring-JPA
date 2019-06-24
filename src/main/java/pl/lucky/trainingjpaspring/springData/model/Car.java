package pl.lucky.trainingjpaspring.springData.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;
    private String name;
    private String brand;
    private Double price;

    public Car(String name, String brand, Double price) {
        super();
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name
                + ", brand=" + brand + ", price=" + price + "]";
    }

}

