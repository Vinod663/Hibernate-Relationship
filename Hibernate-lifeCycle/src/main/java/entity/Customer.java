package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)//customer idn baladdi penne one to many widihata order eka
    private List<Order> orders; //customer kenekta orders ekakata wada tiyenna puluwan
}
