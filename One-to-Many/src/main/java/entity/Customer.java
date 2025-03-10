package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
/*@ToString*/

@AllArgsConstructor
@NoArgsConstructor
/*@Data*/
@Entity
@Table(name = "customer")
public class Customer {
    //inverse side - foreign key eka dena kena
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    /*@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)*///customer idn baladdi penne one to many widihata order eka
    //Eager
    //Lazy
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders; //customer kenekta orders ekakata wada tiyenna puluwan
}
