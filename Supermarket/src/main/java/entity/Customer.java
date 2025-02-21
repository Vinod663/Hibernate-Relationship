package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")

//Inverse side (Customer-order)
public class Customer {
    @Id
    @Column(name = "customer_id")//@Column → Maps a field to a database column.
    private String id;

    private String name;
    private String nic;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
}
