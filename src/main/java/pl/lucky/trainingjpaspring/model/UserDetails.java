package pl.lucky.trainingjpaspring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 7021150458271420830L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_details")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String address;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    public UserDetails(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @PrePersist
    public void prePersist(){
        System.out.println("Saving userDetail: " + this);
    }

    @PostPersist
    public void postPersist(){
        System.out.println("User savedDetail: " + this);
    }
}
