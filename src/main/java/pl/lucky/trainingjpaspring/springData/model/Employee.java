package pl.lucky.trainingjpaspring.springData.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "Employee.findByLastNameAndSalary",
        query = "SELECT e FROM Employee e WHERE e.lastName=:lastName AND e.salary>=:salary")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String firstName;

    private String lastName;

    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", salary=" + salary
                + "]";
    }

}
