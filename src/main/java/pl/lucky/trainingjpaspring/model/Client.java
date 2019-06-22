package pl.lucky.trainingjpaspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Data
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    public Client(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", address=" + address
                + ", orders=" + orders + "]";
    }

}