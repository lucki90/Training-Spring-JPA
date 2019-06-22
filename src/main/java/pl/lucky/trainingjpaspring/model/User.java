package pl.lucky.trainingjpaspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name", nullable = false, unique=true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique=true)
    private String email;

    @OneToOne/*(cascade = {CascadeType.ALL})*/
    @JoinColumn(name = "id_details")
    private UserDetails userDetails;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @PrePersist
    public void prePersist(){
        System.out.println("Saving user: " + this);
    }

    @PostPersist
    public void postPersist(){
        System.out.println("User saved: " + this);
    }
}
